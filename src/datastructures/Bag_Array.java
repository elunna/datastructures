package datastructures;

import java.util.Arrays;

/**
 * A static size Bag ADT using an array implementation.
 *
 * @author Erik Lunna
 *
 * @param <T>
 */
public class Bag_Array<T> implements BagInterface<T> {

    protected T[] array;
    protected int numberOfEntries;

    /**
     * Default constructor creates a new Bag_Array with size DEFAULT_CAPACITY.
     */
    public Bag_Array() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs a Bag_Array that can hold capacity objects.
     *
     * @param capacity
     * @throws IllegalArgumentException
     */
    public Bag_Array(int capacity) throws IllegalArgumentException {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Bad constructor arg");
        }
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[capacity]; // unchecked cast
        array = tempBag;

    }

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

    /**
     * Removes and returns the entry at a given index within the Bag.
     *
     * @param index to remove.
     * @return The entry, if it exists, or throw an exception if an invalid
     * index was given.
     */
    private T remove(int index) {
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
        if (!(aThat instanceof Bag_Array)) {
            return false;
        }
        Bag_Array that = (Bag_Array) aThat;
        return Arrays.equals(this.toArray(), that.toArray()); //array!
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Arrays.deepHashCode(this.array);
        hash = 67 * hash + this.numberOfEntries;
        return hash;
    }

    /**
     * Searches the bag for anEntry and if found, returns its location index. If
     * not found, return null.
     *
     * @param anEntry The entry to search for.
     * @return The index of anEntry
     */
    private int getIndexOf(T anEntry) {
        if (anEntry == null) {
            throw new IllegalArgumentException();
        }
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
