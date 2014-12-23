package datastructures;

import java.util.Arrays;

/**
 * A resizeable Bag ADT using an array implementation.
 *
 * @author Erik Lunna
 *
 * @param <T>
 */
public class Bag_ResizeableArray<T> implements BagInterface<T> {

    protected T[] array;
    protected int numberOfEntries;

    public Bag_ResizeableArray() {
        this(DEFAULT_CAPACITY);
    }

    public Bag_ResizeableArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Bad constructor arg");
        }
        numberOfEntries = 0;
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[capacity]; // unchecked cast
        array = tempBag;
    }

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
    public int size() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean isFull() {
        return numberOfEntries == array.length;
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
    public T[] toArray() {
        @SuppressWarnings(value = "unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; // unchecked cast
        System.arraycopy(array, 0, result, 0, numberOfEntries);
        return result;
    }

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

    @Override
    public int count(T anEntry) {
        int counter = 0;
        for (int i = 0; i < numberOfEntries; i++) {
            if (anEntry.equals(array[i])) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public T remove(T anEntry) {
        T result = null;
        if (anEntry == null) {
            throw new IllegalArgumentException();
        } else if (size() == 0) {
            throw new IllegalStateException();
        }

        int index = getIndexOf(anEntry);
        result = remove(index);

        return result;
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
    public T remove() {
        T result;
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        numberOfEntries--;
        result = array[numberOfEntries];
        array[numberOfEntries] = null;
        return result;
    }

    public T remove(int index) {
        T result;
        if (index < 0 || index > numberOfEntries - 1) {
            throw new IllegalArgumentException();
        } else if (isEmpty()) {
            throw new IllegalStateException();
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
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    @Override
    public boolean equals(Object aThat) {
        if (this == aThat) {
            return true;
        }
        if (!(aThat instanceof Bag_ResizeableArray)) {
            return false;
        }
        Bag_ResizeableArray that = (Bag_ResizeableArray) aThat;
        return Arrays.equals(this.toArray(), that.toArray()); //array!
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Arrays.deepHashCode(this.array);
        hash = 71 * hash + this.numberOfEntries;
        return hash;
    }

}

//    // Displays all the elements of bag line by line.
//    @Override
//    public void display() {
//        displayArray(0, numberOfEntries - 1);
//    }
/**
 * Does the work of recursively displaying the individual elements
 *
 * @return
 */
//    private void displayArray(int first, int last) {
//        System.out.println(array[first]);
//        if (first < last) {
//            displayArray(first + 1, last);
//        }
//    }
