package applauncher;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import javax.swing.SwingUtilities;

public class ConsoleStream extends OutputStream {
    private final ConsolePane consolePane;
    private final StringBuilder buffer = new StringBuilder();

    public ConsoleStream(ConsolePane consolePane) {
        this.consolePane = consolePane;
    }

    @Override
    public void write(int b) {
        buffer.append((char) b);
        if(b == '\n' || b == '?') {
            flushBuffer();
        }
    }

    @Override
    public void write(byte[] b, int off, int len) {
        String str = new String(b, off, len, StandardCharsets.UTF_8);
        buffer.append(str);

        if(str.contains("\n") || str.contains("?")) {
            flushBuffer();
        }
    }
    private void flushBuffer() {
        if(buffer.length() > 0) {
            String text = buffer.toString();
            SwingUtilities.invokeLater(() -> {
                        consolePane.parseANSI(text);
                    });
            buffer.setLength(0);
        }
    }
}
