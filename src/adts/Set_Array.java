package adts;

import java.util.Arrays;
import java.util.Random;

/**
 * File: Description:
 *
 * @author lunatunez
 * @param <T>
 */
public class Set_Array<T> implements SetInterface<T> {

    protected T[] array;
    protected int numberOfEntries;

    public Set_Array() {
        this(DEFAULT_CAPACITY);
    }

    public Set_Array(int capacity) throws IllegalArgumentException {
        numberOfEntries = 0;
        if (capacity <= 0) {
            throw new IllegalArgumentException("Bad constructor capacity parameter");
        }
        @SuppressWarnings("unchecked")
        T[] tempSet = (T[]) new Object[capacity]; // unchecked cast
        array = tempSet;
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

    @Override
    public int cardinality() {
        return size();
    }

    public int capacity() {
        return array.length;
    }

    @Override
    public boolean isElement(T anEntry) {
        return contains(anEntry);
    }

    public T getMin() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public T getMax() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T[] enumerate() {
        return toArray();
    }

    @Override
    public SetInterface union(SetInterface anotherSet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SetInterface intersection(SetInterface anotherSet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SetInterface difference(SetInterface anotherSet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//
//    @Override
//    public SetInterface union(SetInterface anotherSet) {
//        Set_Array union = new Set_Array();
//        // Add all the elements of this set
//        for (T t : this.toArray()) {
//            if (!union.contains(t)) {
//                union.add(t);
//            }
//        }
//        // Add the element from the other set, checking duplicates
//        for (Object t : anotherSet.toArray()) {
//            if (!union.contains((Comparable) t)) {
//                union.add((Comparable) t);
//            }
//        }
//        return union;
//    }
//
//    @Override
//    public SetInterface intersection(SetInterface anotherSet) {
//        Set_Array intersection = new Set_Array();
//
//        for (int i = 0; i < this.size(); i++) {
//            if (anotherSet.contains((Comparable) array[i])) {
//                intersection.add(array[i]);
//            }
//        }
//        return intersection;
//    }
//
//    @Override
//    public SetInterface difference(SetInterface anotherSet) {
//        Set_Array difference = new Set_Array();
//
//        for (int i = 0; i < this.size(); i++) {
//            if (!anotherSet.contains((Comparable) array[i])) {
//                difference.add(array[i]);
//            }
//        }
//        return difference;
//    }
    
    @Override
    public boolean equals(Object aThat) {
        if (this == aThat) {
            return true;
        }
        if (!(aThat instanceof Set_Array)) {
            return false;
        }
        Set_Array that = (Set_Array) aThat;
        return Arrays.equals(this.toArray(), that.toArray()); //array!
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Arrays.deepHashCode(this.array);
        hash = 59 * hash + this.numberOfEntries;
        return hash;
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
        if (this.contains(newEntry)) {
            result = false;
        } else if (newEntry == null) {
            result = false;
        } else {
            ensureCapacity();
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

    @Override
    public boolean remove(T anEntry) {
        if (anEntry == null || size() == 0) {
            return false;
        }

        int index = getIndexOf(anEntry);
        T result = remove(index);

        return result != null;
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

    public T removeRandom() {
        T result = null;
        if (isEmpty()) {
            return result;
        } else {
            Random randomNumbers = new Random();
            int randomIndex = randomNumbers.nextInt(numberOfEntries);
            result = this.remove(randomIndex);
            return result;
        }
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
