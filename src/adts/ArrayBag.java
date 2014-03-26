package adts;

/**
 * Description:  This is an array based generic collection.
 * This bag is a fixed sized array. 
 * It includes methods to manage manage its contents.
 * 
 * @author Erik Lunna<eslunna@gmail.com>
 * Date: 
 * 
 * @param <T>
 */
public class ArrayBag<T> implements BagInterface<T> {

    private final T[] bagArray;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;

    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayBag(int capacity) {
        numberOfEntries = 0;
        if (capacity < 0) {
            capacity = 0;
        }
        // the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[capacity]; // unchecked cast
        bagArray = tempBag;
    }

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
        } else {  // assertion: result is true here
            bagArray[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return result;
        // Returns true if add executed
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
        System.arraycopy(bagArray, 0, result, 0, numberOfEntries);

        return result;
    }

    /**
     * Sees whether this bag is full.
     * @return true if the bag is full, or false if not
     */
    @Override
    public boolean isFull() {
        return numberOfEntries == bagArray.length;
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
     * Gets the current number of entries in this bag.
     *
     * @return the integer number of entries currently in the bag
     */
    @Override
    public int getSize() {
        return numberOfEntries;
    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     *
     * @return either the removed entry, if the removal was successful, or null
     * otherwise
     */
    @Override
    public T remove() {
        T result = remove(numberOfEntries - 1);
        return result;
    }

    /**
     * Removes and returns the entry at a given index within the arraybag.
     * @param givenIndex
     * @return If no such entry exists, returns null.
     */
    @Override
    public T remove(int givenIndex) {
        T result = null;
        if (!isEmpty() && (givenIndex >= 0)) {
            result = bagArray[givenIndex]; // entry to remove
            numberOfEntries--;
            bagArray[givenIndex] = bagArray[numberOfEntries]; 
            // replace entry with last entry
            bagArray[numberOfEntries] = null;
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

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry the entry to be counted
     * @return the number of times anEntry appears in the bag
     */
    @Override
    public int getFrequencyOf(T anEntry) {
        int counter = 0;

        for (int i = 0; i < numberOfEntries; i++) {
            if (anEntry.equals(bagArray[i])) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Searches the bag for anEntry and if found, returns its location index. If
     * not found, return null.
     *
     * @param anEntry
     * @return
     */
    @Override
    public int getIndexOf(T anEntry) {
        int where = -1;
        boolean stillLooking = true;
        for (int index = 0; stillLooking && (index < numberOfEntries); index++) {
            if (anEntry.equals(bagArray[index])) {
                stillLooking = false;
                where = index;
            }
        }
        return where;
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
            if (anEntry.equals(bagArray[i])) {
                found = true;
            }
        }
        return found;
    }
}