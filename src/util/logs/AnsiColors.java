package util.logs;

import java.awt.Color;

public enum AnsiColors {
    RESET("\u001B[0m", Color.WHITE),
    BOLD("\u001B[1m", null),
    RED("\u001B[31m", Color.RED),
    GREEN("\u001B[32m", Color.GREEN),
    YELLOW("\u001B[33m", Color.YELLOW),
    BLUE("\u001B[34m", Color.BLUE),
    PURPLE("\u001B[35m", new Color(200, 150, 255));

    public String code;
    private Color swingColor;

    AnsiColors(String code, Color swingColor) {
        this.code = code;
        this.swingColor = swingColor;
    }

    public String code() {
        return code;
    }

    public Color swingColor() {
        return swingColor;
    }

    
    public String apply(String text) {
        return this.code + text + RESET.code;
    }
    
    @Override
    public String toString() {
        return code;
    }

    public static AnsiColors fromCode(String code) {
        for(AnsiColors color : AnsiColors.values()) {
            if(color.code().equals(code)) {
                return color;
            }
        }
        return RESET;
    }
}
