package adts;

import java.util.Arrays;

/**
 * Description: This acts as a resizeable waiting line, or queue. Entries are
 * added to the back, and removed from the front.
 *
 * This circular array structure contains one unused space. This space is used
 * because it enables us to only need the frontindex and backindex to calculate
 * if the queue is full or empty.
 *
 * Full when frontIndex == (backIndex + 2) % queue.length
 *
 * empty when frontIndex == (backIndex + 1) % queue.length
 *
 * @author Erik Lunna<eslunna@gmail.com>
 * Date: 11/12 Purpose:
 * @param <T>
 */
public class Queue_CircularArray<T> implements QueueInterface<T> {

    protected T[] array;
    protected int numberOfEntries;
    private int frontIndex;
    private int backIndex;

    public Queue_CircularArray() {
        this(ListInterface.DEFAULT_CAPACITY);
    }

    public Queue_CircularArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Bad constructor arg");
        }
        @SuppressWarnings("unchecked")
        T[] tempBag;
        tempBag = (T[]) new Object[capacity];
        array = tempBag;
        numberOfEntries = 0;
        frontIndex = 0;
        backIndex = capacity - 1;
    }

    // *************************************************************************
    // *** STATIC METHODS ******************************************************
    @Override
    public int size() {
        return numberOfEntries;
//        if (frontIndex == (backIndex + 1) % array.length) {
//            return 0;
//        } else if (frontIndex == backIndex) {
//            return 1;
//        } else if (frontIndex < backIndex) {
//            return backIndex - frontIndex + 1;
//        } else if (frontIndex > backIndex) {
//            return backIndex + 1 + frontIndex - array.length;
//        } else {
//            return -1;
//        }
    }

//    @Override
//    public boolean isEmpty() {
//        return frontIndex == (backIndex + 1) % array.length;
//    }

    /*
     * Sees whether this bag is empty.
     */
    @Override
    public boolean isEmpty() {
        boolean result;
        if (size() == 0) {
            assert frontIndex == (backIndex + 1) % array.length;
            result = true;
        } else {
            assert frontIndex != (backIndex + 1) % array.length : "isEmpty formula doesn't indicate empty, but numberOfNodes = null";
            result = false;
        }
        return result;
    }

    @Override
    public boolean isFull() {
        return frontIndex == ((backIndex + 2) % array.length);
    }

    @Override
    public T getFront() {
        T front = null;
        if (!isEmpty()) {
            return array[frontIndex];
        }
        return front;
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
    public boolean equals(Object aThat) {
        if (this == aThat) {
            return true;
        }
        if (!(aThat instanceof Queue_CircularArray)) {
            return false;
        }
        Queue_CircularArray that = (Queue_CircularArray) aThat;
        return Arrays.equals(this.toArray(), that.toArray()); //array!
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Arrays.deepHashCode(this.array);
        hash = 71 * hash + this.numberOfEntries;
        hash = 71 * hash + this.frontIndex;
        hash = 71 * hash + this.backIndex;
        return hash;
    }

    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
    @Override
    public boolean enqueue(T newEntry) {
        if (newEntry != null) {
            ensureCapacity();

            backIndex = (backIndex + 1) % array.length;
            array[backIndex] = newEntry;
            numberOfEntries++;
            return true;
        }
        return false;
    }

    @Override
    public T dequeue() {
        T front = null;
        if (!isEmpty()) {
            front = array[frontIndex];
            array[frontIndex] = null;
            frontIndex = (frontIndex + 1) % array.length;
            numberOfEntries--;

        }
        return front;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    private void ensureCapacity() {
        if (isFull()) {
            T[] oldQueue = array;
            int oldSize = oldQueue.length;

            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[]) new Object[2 - oldSize];
            array = tempQueue;

            for (int index = 0; index < oldSize - 1; index++) {
                array[index] = oldQueue[frontIndex];
            }
            frontIndex = (frontIndex + 1) % oldSize;
            frontIndex = 0;
            backIndex = oldSize - 2;
        }
    }

    // *************************************************************************
    // *** STATIC METHODS ******************************************************
    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry the object to be added as a new entry
     * @return true if the addition is successful, or false if not
     */
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
}
