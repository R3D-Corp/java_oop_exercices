package applauncher;

public record Program(String fullName, String alias) {

    public Program(String fullName) {
        this(fullName, fullName.substring(fullName.lastIndexOf('.') + 1));
    }

    @Override
    public String toString() {
        return alias;
    }
};
