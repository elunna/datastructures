package adts;

import java.util.Arrays;

/**
 * File: Description:
 *
 * @author lunatunez
 * @param <T>
 */
public class List_Array<T> implements ListInterface<T> {

    private T[] array;
    private int numberOfEntries;

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
    public int size() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public boolean isFull() {
        return numberOfEntries == array.length;
    }

    @Override
    public T get(int index) {
        return array[index];
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
        // the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; // unchecked cast
        System.arraycopy(array, 0, result, 0, numberOfEntries);

        return result;
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
        if (newEntry == null) {
            return false;
        } else {
            ensureCapacity();
            array[numberOfEntries] = newEntry;
            numberOfEntries++;
            return true;
        }
    }

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

    /**
     * Removes one unspecified entry from this bag, if possible.
     *
     * @return either the removed entry, if the removal was successful, or null
     * otherwise
     */
    @Override
    public T remove() {
        if (size() > 0) {
            T result = remove(numberOfEntries - 1);
            if (result != null) {
                numberOfEntries--;
                return result;
            }
        }
        return null;
    }

    /**
     * Removes and returns the entry at a given index within the arraybag. If
     * the entry doesn't exist, returns null.
     *
     * @param index
     * @return
     */
    @Override
    public T remove(int index) {
        T result = null;
        if (!isEmpty() && (index >= 0)) {
            result = array[index]; // entry to remove
            numberOfEntries--;
            array[index] = array[numberOfEntries]; // replace entry with last entry
            array[numberOfEntries] = null; // remove last entry
        }
        return result;
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

    @Override
    public void clear() {
        while (!isEmpty()) {
            remove();
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

}
