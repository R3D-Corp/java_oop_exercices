package labs.trollshop;

public class ArmorRack extends Rack<Armor> {

    private final static Armor[] EMPTY_ARRAY = new Armor[0];

    public ArmorRack(int capacity, Armor[] items) {
        super(capacity, items);
    }

    public ArmorRack(Armor[] armor) {
        super(armor);
    }

    public ArmorRack(int capacity) {
        this(capacity, EMPTY_ARRAY);
    }
}
