package applauncher;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProgramExecutor {
    // Basiquement la liste de tous les threads.
    private static HashMap<String, Thread> threads = new HashMap<>();

    private static String formatClassName(Path root, Path file) {
        String relative = root.relativize(file).toString();
        return relative
        .replace(".java", "")
        .replace("/", ".")
        .replace("\\", ".");
    }


    public static List<String> findPrograms(String rootPath) {
        List<String> classNames = new ArrayList<>();

        try {

            java.security.CodeSource src = ProgramExecutor.class.getProtectionDomain().getCodeSource();
            if (src != null && src.getLocation().getFile().endsWith(".jar")) {
                java.net.URL jar = src.getLocation();
                java.util.zip.ZipInputStream zip = new java.util.zip.ZipInputStream(jar.openStream());
                
                while (true) {
                    java.util.zip.ZipEntry e = zip.getNextEntry();
                    if (e == null) break;
                    String name = e.getName();
                    // On ne prend que les .class (le JAR contient du compilé, pas du .java)
                    if (name.endsWith(".class") && !name.contains("$")) {
                        String className = name.replace("/", ".").replace(".class", "");
                        // On filtre pour ne pas afficher le launcher lui-même ou les libs
                        if (className.startsWith("chap") || className.startsWith("io")) {
                            if (hasMainMethod(className)) {
                                classNames.add(className);
                            }
                        }
                    }
                }
                java.util.Collections.sort(classNames);
                return classNames;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        classNames = findProgramsFileSystem(rootPath);
        java.util.Collections.sort(classNames);
        return classNames;
    }

    public static List<String> findProgramsFileSystem(String rootPath) {

        Path start = Paths.get(rootPath);
        
        try (Stream<Path> stream = Files.walk(start)) {
            return stream
            .filter(path -> path.toString().endsWith(".java"))
            .map(path -> formatClassName(start, path))
            .filter(className -> !className.contains("$"))
            .collect(Collectors.toList());
        } catch(IOException e) {
            System.out.println(e);
            return new ArrayList<>();
        }
    }

    public static boolean hasMainMethod(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            clazz.getMethod("main", String[].class);
            return true;
        } catch(NoSuchMethodException | ClassNotFoundException e) {
            return false;
        }
    }

    public static boolean isReadyToRun(String className) {
        try{
            Class.forName(className);
            return true;
        } catch(ClassNotFoundException e) {
            return false;
        }
    }


    public static void stopClass(String className, PipedOutputStream out)   {
        Thread oldThread = threads.get(className);
        if(oldThread != null && oldThread.isAlive()) {
            oldThread.interrupt();

            try {
                out.write("\n".getBytes());
                out.flush();
            } catch(IOException e) {
                e.printStackTrace();
            }
            threads.remove(className);
        }

    };


    public static void stopAllProcess(PipedOutputStream out) {
        threads.forEach((name, thread) -> {
            stopClass(name, out);
        });
    }

    public static void executeClass(String className) {

        Thread oldThread = threads.get(className);
        if(oldThread != null && !oldThread.isAlive()) {
            oldThread.interrupt();
            threads.remove(className);
        }


        Thread newThread = new Thread(() -> {
            try {
                Class<?> clazz = Class.forName(className);
                Method mainMethod = clazz.getMethod("main", String[].class);
        
                String[] params = new String[] {};
                mainMethod.invoke(null, (Object) params);
        
            } catch (Exception e) {
                System.out.println(e);
            }
        });

        threads.put(className, newThread);
        newThread.start();
    }
}
