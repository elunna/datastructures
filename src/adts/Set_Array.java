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

    private T[] array;
    private int numberOfEntries;

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

    @Override
    public int size() {
        return numberOfEntries;
    }

    @Override
    public int cardinality() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {

        return size() == 0;
    }

    @Override
    public boolean isFull() {
        return numberOfEntries == array.length;
    }

    public int capacity() {
        return array.length;
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

    @Override
    public boolean isElement(T anEntry) {
        return contains(anEntry);
    }

    public T getMin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public T getMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Retrieves all entries that are in this bag.
     *
     * @return a newly allocated array of all the entries in the bag
     */
    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        System.arraycopy(array, 0, result, 0, numberOfEntries);
        return result;
    }

    @Override
    public T[] enumerate() {
        return toArray();
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
                return result;
            }
        }
        return null;
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
        if (index > array.length || index < 0) {
            return null;
        }

        if (!isEmpty()) {
            result = array[index];
            numberOfEntries--;
            array[index] = array[numberOfEntries];
            array[numberOfEntries] = null;
        }
        return result;
    }

    /**
     * Removes one occurrence of a given entry from this bag.
     *
     * @param anEntry the entry to be removed
     * @return true if the removal was successful, or false if not
     *
     */
    @Override
    public boolean remove(T anEntry) {
        if (anEntry == null || size() == 0) {
            return false;
        }
        T result;
        int index = getIndexOf(anEntry);
        if (index == -1) {
            return false;
        } else {
            result = remove(index);
        }

        return anEntry.equals(result);
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
}
