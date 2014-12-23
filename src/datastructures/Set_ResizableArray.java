package datastructures;

import java.util.Arrays;
import java.util.Iterator;

/**
 * A dynamic size Set using a resizable array implementation.
 *
 * @author Erik Lunna
 * @param <T>
 */
public class Set_ResizableArray<T> implements SetInterface<T> {

    protected T[] array;
    protected int numberOfEntries;

    public Set_ResizableArray() {
        this(DEFAULT_CAPACITY);
    }

    public Set_ResizableArray(int capacity) throws IllegalArgumentException {
        numberOfEntries = 0;
        if (capacity <= 0) {
            throw new IllegalArgumentException("Bad constructor capacity parameter");
        }
        @SuppressWarnings("unchecked")
        T[] tempSet = (T[]) new Object[capacity]; // unchecked cast
        array = tempSet;
    }

    @Override
    public int size() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

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
    public T getMin() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T getMax() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SetInterface union(SetInterface anotherSet) {

        Set_ResizableArray union = new Set_ResizableArray();
        // Add all the elements of this set
        for (T t : this.toArray()) {
            if (!union.contains(t)) {
                union.add(t);
            }
        }
        // Add the element from the other set, checking duplicates
        for (Object t : anotherSet.toArray()) {
            if (!union.contains((Comparable) t)) {
                union.add((Comparable) t);
            }
        }
        return union;
    }

    @Override
    public SetInterface intersection(SetInterface anotherSet) {
        Set_ResizableArray intersection = new Set_ResizableArray();

        for (int i = 0; i < this.size(); i++) {
            if (anotherSet.contains((Comparable) array[i])) {
                intersection.add(array[i]);
            }
        }
        return intersection;
    }

    @Override
    public SetInterface difference(SetInterface anotherSet) {
        Set_ResizableArray difference = new Set_ResizableArray();

        for (int i = 0; i < this.size(); i++) {
            if (!anotherSet.contains((Comparable) array[i])) {
                difference.add(array[i]);
            }
        }
        return difference;
    }

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

    @Override
    public T remove(T anEntry) {
        if (anEntry == null
                || isEmpty()) {
            throw new IllegalArgumentException();
        } else {

            int index = getIndexOf(anEntry);
            T result = remove(index);

            return result;
        }
    }

    @Override
    public T remove(int index) {
        if (index < 0
                || index > numberOfEntries - 1
                || isEmpty()) {
            throw new IllegalArgumentException();
        }
        T result = array[index];
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
    public void clear() {
        while (!isEmpty()) {
            remove(0);
        }
    }

    @Override
    public Iterator getIterator() {
        return new ArrayIterator(array);
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings(value = "unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; // unchecked cast
        System.arraycopy(array, 0, result, 0, numberOfEntries);
        return result;
    }

    @Override
    public boolean equals(Object aThat) {
        if (this == aThat) {
            return true;
        }
        if (!(aThat instanceof Set_ResizableArray)) {
            return false;
        }
        Set_ResizableArray that = (Set_ResizableArray) aThat;
        return Arrays.equals(this.toArray(), that.toArray()); //array!
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Arrays.deepHashCode(this.array);
        hash = 59 * hash + this.numberOfEntries;
        return hash;
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

    /**
     * Searches the bag for anEntry and if found, returns its location index. If
     * not found, return null.
     *
     * @param anEntry
     * @return
     */
    private int getIndexOf(T anEntry) {
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
}

//    // Displays all the elements of bag line by line.
//    @Override
//    public void display() {
//        displayArray(0, numberOfEntries - 1);
//    }
//
//    /**
//     * Does the work of recursively displaying the individual elements
//     *
//     * @param first
//     * @param last
//     */
//    private void displayArray(int first, int last) {
//        System.out.println(array[first]);
//        if (first < last) {
//            displayArray(first + 1, last);
//        }
//    }
