package datastructures;

import java.util.Arrays;

/**
 * A dynamic size Stack using an array implementation.
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
     * Constructor that takes a capacity argument for it's initial capacity.
     * Throws an exception if the capacity is 0 or less.
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

    @Override
    public int size() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
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
    public boolean push(T newEntry) {
        boolean result = true;
        if (newEntry == null) {
            result = false;
        } else {
            array[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return result;
    }

    @Override
    public T pop() {
        T result = null;
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        numberOfEntries--;
        result = array[numberOfEntries];
        array[numberOfEntries] = null;
        return result;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            pop();
        }
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
        if (!(aThat instanceof Stack_Array)) {
            return false;
        }
        Stack_Array that = (Stack_Array) aThat;
        return Arrays.equals(this.toArray(), that.toArray()); //array!
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Arrays.deepHashCode(this.array);
        hash = 59 * hash + this.numberOfEntries;
        return hash;
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
