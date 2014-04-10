package adts;

import java.util.Arrays;

/**
 * File: Description:
 *
 * @author lunatunez
 * @param <T>
 */
public class List_Array<T> implements ListInterface<T> {
    protected T[] array;
    protected int numberOfEntries;

    public List_Array() {
        this(DEFAULT_CAPACITY);
    }

    public List_Array(int capacity) throws IllegalArgumentException {
        numberOfEntries = 0;
        if (capacity <= 0) {
            throw new IllegalArgumentException("Bad constructor arg");
        }
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[capacity]; // unchecked cast
        array = tempBag;
    }

    // *************************************************************************
    // *** STATIC METHODS ******************************************************
    @Override
    public T get(int index) {
        if (!isEmpty()
                && index >= 0
                && index < array.length) {
            return array[index];
        } else {
            return null;
        }
    }

    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
    @Override
    public boolean insert(int index, T newEntry) {
        if (newEntry == null
                || index < 0
                || index > numberOfEntries) {
            return false;
        } else {
            ensureCapacity();
            array[numberOfEntries] = newEntry;
            numberOfEntries++;
            return true;
        }
    }

    @Override
    public boolean replace(int index, T newEntry) {
        if (isEmpty()
                || index < 0
                || index > numberOfEntries - 1
                || newEntry == null) {
            return false;
        } else {
            array[index] = newEntry;
            return true;
        }
    }

    /**
     * Doubles the size of the array bag if it is full. If user specified zero
     * capacity Ensure capacity of at least 1. (minimum required)
     */
    private void ensureCapacity() {
        if (numberOfEntries == array.length) {
            array = Arrays.copyOf(array, 2 * array.length);
        } else if (array.length == 0) {

            array = Arrays.copyOf(array, 1);
        }
    }

    // *************************************************************************
    // *** STATIC METHODS ******************************************************
    /**
     * Gets the current number of entries in this bag.
     *
     * @return the integer number of entries currently in the bag
     */
    @Override
    public int size() {
        return numberOfEntries;
    }

    /**
     * Sees whether this bag is empty.
     *
     * @return true if the bag is empty, or false if not
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /**
     * Sees whether this bag is full.
     *
     * @return true if the bag is full, or false if not
     */
    @Override
    public boolean isFull() {
        return numberOfEntries == array.length;
    }

    /**
     * Tests whether this bag contains a given entry.
     *
     * @param anEntry the entry to locate
     * @return true if the bag contains anEntry, or false otherwise
     */
    @Override
    public boolean contains(T anEntry) {
        if (anEntry == null) {
            return false;
        }
        boolean found = false;
        for (int i = 0; !found && (i < numberOfEntries); i++) {
            if (anEntry.equals(array[i])) {
                found = true;
            }
        }
        return found;
    }

    /**
     * Retrieves all entries that are in this bag.
     *
     * @return a newly allocated array of all the entries in the bag
     */
    @Override
    public T[] toArray() {
        @SuppressWarnings(value = "unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; // unchecked cast
        System.arraycopy(array, 0, result, 0, numberOfEntries);
        return result;
    }

    /**
     * Searches the bag for anEntry and if found, returns its location index. If
     * not found, return null.
     *
     * @param anEntry
     * @return
     */
    public int getIndexOf(T anEntry) {
        int where = -1;
        boolean stillLooking = true;
        for (int index = 0; stillLooking && (index < numberOfEntries); index++) {
            if (anEntry.equals(array[index])) {
                stillLooking = false;
                where = index;
            }
        }
        return where;
    }

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry the entry to be counted
     * @return the number of times anEntry appears in the bag
     */
    public int getFrequencyOf(T anEntry) {
        int counter = 0;
        for (int i = 0; i < numberOfEntries; i++) {
            if (anEntry.equals(array[i])) {
                counter++;
            }
        }
        return counter;
    }

    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry the object to be added as a new entry
     * @return true if the addition is successful, or false if not
     */
    @Override
    public boolean add(T newEntry) {
        boolean result = true;
        if (isFull()) {
            result = false;
        } else if (newEntry == null) {
            result = false;
        } else {
            array[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return result;
    }

    /**
     * Removes the last entry from this bag, if possible.
     *
     * @return either the removed entry, if the removal was successful, or null
     * otherwise
     */
    @Override
    public T remove() {
        T result = null;
        if (isEmpty()) {
            return result;
        }
        numberOfEntries--;
        result = array[numberOfEntries];
        array[numberOfEntries] = null;
        return result;
    }

    /**
     * Removes and returns the entry at a given index within the arraybag.
     *
     * @param index
     * @return If no such entry exists, returns null.
     */
    @Override
    public T remove(int index) {
        T result = null;
        if (index < 0 || index > numberOfEntries - 1 || isEmpty()) {
            return result;
        }
        result = array[index];
        numberOfEntries--;
        if (index != numberOfEntries) {
            // Fill removed entry with last entry
            array[index] = array[numberOfEntries];
            // Erase last entry
            array[numberOfEntries] = null;
        }
        return result;
    }

    /**
     * Removes all entries from this bag.
     */
    @Override
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }
}