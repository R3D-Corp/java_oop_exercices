package labs.trollshop;

public class Toolrack extends Rack<Tool> {
    private final static Tool[] EMPTY_ARRAY = new Tool[0];

    public Toolrack(int capacity, Tool[] items) {
        super(capacity, items);
    }

    public Toolrack(Tool[] tools) {
        super(tools);
    }

    public Toolrack(int capacity) {
        this(capacity, EMPTY_ARRAY);
    }
}
