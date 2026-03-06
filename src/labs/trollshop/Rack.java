package labs.trollshop;

import java.lang.reflect.Array;
import java.util.Arrays;

import util.Contract;

public abstract class Rack<T> {
    private final T[] slots;

    @SuppressWarnings("unchecked")
    public Rack(int capacity, T[] items) {
        Contract.require(items != null, "Les items ne doivent pas être null");
        Contract.require(capacity > 0 && capacity >= items.length, "Vous ne pouvez pas avoir une capacity inférieure ou égale à 0 ou plus petite que le nombre d'items");

        this.slots = (T[]) Array.newInstance(items.getClass().getComponentType(), capacity);    

        for(int i = 0; i<items.length; i++) {
            this.slots[i] = items[i];
        }
    }

    public Rack(T[] items) {
        this(items == null ? 0 : items.length, items);
    }

    public int getCapacity() {
        return slots.length;
    }

    public int countAvailableSlots() {
        int result = 0;
        
        for(T item : this.getItems()) {
            if(item == null) result++;
        }

        return result;
    }

    public int countOccupiedSlots() {
        int result = 0;

        for(T item : this.getItems()) {
            if(item != null) result++;
        }

        return result;
    }

    public boolean isSlotAvailabeAt(int slotIndex) {
        return this.getItems()[slotIndex] == null;
    }

    public boolean isEmpty() {
        return this.countOccupiedSlots() == 0;
    }

    public boolean isFull() {
        return this.countAvailableSlots() == 0;
    }

    public T getAt(int slotIndex) {
        Contract.require(
            0 <= slotIndex && slotIndex < getCapacity(),
            "Arg. slotIndex in [0; %d] attendu. Reçu %d"
                .formatted(getCapacity(), slotIndex));

        return slots[slotIndex];
    }

    public T takeAt(int slotIndex) {
        Contract.require(slotIndex >= 0 && slotIndex < getCapacity(), "Arg. slotIndex in [0; %d] attendu. Reçu %d".formatted(getCapacity(), slotIndex));
        T item = this.getItems()[slotIndex];
        setAt(slotIndex, null);
        return item;
    }

    public void setAt(int slotIndex, T item) {
        Contract.require(slotIndex >= 0 && slotIndex < this.getCapacity(), "Arg. slotIndex in [0; %d] attendu. Reçu %d".formatted(getCapacity(), slotIndex));
        this.slots[slotIndex] = item;
    }

    public T[] getItems() {
        return (T[]) Arrays.copyOf(this.slots, this.getCapacity());
    }

    @SuppressWarnings("unchecked")
    public void compact() {
        T[] current = this.getItems();
        T[] compacted = (T[]) new Object[current.length];

        for(int i=0, compactedIndex = 0; i<current.length; i++) {
            if(current[i] != null) {
                compacted[compactedIndex] = current[i];
                compactedIndex++;
                
                current[i] = null;
            }
        }
        for(int j=0; j<compacted.length; j++) {
            this.slots[j] = compacted[j];
        }
    }
}
