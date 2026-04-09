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

    /**
     * Finds all java programs/exercices from source code.
     * @return List<String> Alls progams found in the path.
     */
    private static List<String> findProgramsInBin(java.security.CodeSource src) {
        List<String> classNames = new ArrayList<>();

        try {
            java.net.URL jar = src.getLocation();
            java.util.zip.ZipInputStream zip = new java.util.zip.ZipInputStream(jar.openStream());

            while (true) {
                java.util.zip.ZipEntry e = zip.getNextEntry();
                if (e == null) break; // Stop the search part if there is no entry anymore.

                String name = e.getName();
                if (name.endsWith(".class") && !name.contains("$")) { // We search only for .class files. (Compilated java)
                    String className = name.replace("/", ".").replace(".class", "");
                    
                    boolean isRelevant = className.startsWith("labs") || className.startsWith("theory"); // Is an program that I made.
                    boolean isLauncher = className.equals(ProgramExecutor.class.getName());

                    if (isRelevant && !isLauncher) {
                        if (hasMainMethod(className)) {
                            classNames.add(className);
                        }
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        java.util.Collections.sort(classNames);
        return classNames;
    }
    
    /**
     * Finds all java programs/exercices in `.java` in a path.
     * @return List<String> Alls progams found in the path.
     */
    private static List<String> findProgramsInFile(String path) {
        Path start = Paths.get(path);
        
        try (Stream<Path> stream = Files.walk(start)) {
            return stream
                .filter(p -> p.toString().endsWith(".java"))
                .map(p -> formatClassName(start, p))
                .filter(className -> !className.contains("$"))
                .collect(Collectors.toList());
        } catch(IOException e) {
            System.out.println(e);
            return new ArrayList<>();
        }
    }
    
    /**
     * Find all other programs which are launchable.
     * @param rootPath
     * @return List<String> All launchables programs.
     */
    public static List<String> findPrograms(String path) {
        java.security.CodeSource src = ProgramExecutor.class.getProtectionDomain().getCodeSource();
        if(src == null) return new ArrayList<String>();

        List<String> programs = src.getLocation().getFile().endsWith(".jar") ? findProgramsInBin(src) : findProgramsInFile(path);
        java.util.Collections.sort(programs);

        return programs;
    }
    
    /**
     * Check if a java class has a main method.
     * @param className the class to check.
     * @return Have an main method.
     */
    public static boolean hasMainMethod(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            clazz.getMethod("main", String[].class);
            return true;
        } catch(NoSuchMethodException | ClassNotFoundException e) {
            return false;
        }
    }

    /**
     * Check if a java class is ready to be launched.
     * @param className the class to check.
     * @return Is ready to launch.
     */
    public static boolean isReadyToRun(String className) {
        try{
            Class.forName(className);
            return true;
        } catch(ClassNotFoundException e) {
            return false;
        }
    }

    /**
     * Ask a class to stop itself.
     * @param className the class to stop.
     * @param out the pipedOutput to clear and to give last feedback.
     */
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

    /**
     * Ask all class to stop themself.
     * @param out the pipedOutput to clear and to give last feedbacks.
     */
    public static void stopAllProcess(PipedOutputStream out) {
        threads.forEach((name, thread) -> {
            stopClass(name, out);
        });
    }
    
    /**
     * Launch a new instance of class in an sepereate thread.
     * @param className the class to launch.
     */
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
