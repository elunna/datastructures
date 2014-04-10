package adts;

/**
 * A class of stacks whose entries are stored in an array.
 *
 * @author Erik Lunna
 * @param <T>
 */
public class Stack_Array<T> implements StackInterface<T> {

    protected T[] array;
    protected int numberOfEntries;

    public Stack_Array() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    /**
     *
     * @param capacity
     */
    public Stack_Array(int capacity) {
        // the cast is safe because the new array contains null entries

        if (capacity <= 0) {
            throw new IllegalArgumentException("Bad constructor arg");
        }

        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[capacity];
        array = tempStack;
        numberOfEntries = 0;  // -1 = empty
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
    public boolean isFull() {
        return numberOfEntries == array.length;
    }

    /**
     * Tests whether this bag contains a given entry.
     *
     * @param anEntry the entry to locate
     * @return true if the bag contains anEntry, or false otherwise
     */
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

    @Override
    public T peek() {
        T top = null;
        if (!isEmpty()) {
            top = array[numberOfEntries - 1];
        }
        return top;
    }

    @Override
    public T peek2() {
        if (size() > 1) {
            return array[numberOfEntries - 2];
        } else {
            return null;
        }
    }
    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************

    @Override
    public boolean push(T newEntry) {
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
     * Removes and returns the entry at a given index within the arraybag.
     *
     * @param index
     * @return If no such entry exists, returns null.
     */
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

    @Override
    public T pop() {
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
     * Removes all entries from this bag.
     */
    @Override
    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }
}
