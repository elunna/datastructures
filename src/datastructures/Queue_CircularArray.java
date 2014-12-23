package datastructures;

import java.util.Arrays;

/**
 * A dynamic size Queue using a circular array implementation.
 *
 * The circular array structure contains one unused space. This space is used
 * because it enables us to only need the frontindex and backindex to calculate
 * if the queue is full or empty.
 *
 * Full when frontIndex == (backIndex + 2) % queue.length 
 * Empty when frontIndex == (backIndex + 1) % queue.length
 *
 * @author Erik Lunna
 * @param <T>
 */
public class Queue_CircularArray<T> implements QueueInterface<T> {

    protected T[] array;
    protected int numberOfEntries;
    private int frontIndex;
    private int backIndex;

    public Queue_CircularArray() {
        this(QueueInterface.DEFAULT_CAPACITY);
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

    @Override
    public int size() {
        return numberOfEntries;
    }

    @Override
    public boolean isFull() {
        return frontIndex == ((backIndex + 2) % array.length);
    }

    @Override
    public boolean isEmpty() {
        boolean result;
        if (size() == 0) {
            assert frontIndex == (backIndex + 1) % array.length;
            result = true;
        } else {
            assert frontIndex != (backIndex + 1) % array.length :
                    "isEmpty formula doesn't indicate empty, but numberOfNodes = null";
            result = false;
        }
        return result;
    }

    @Override
    public T getFront() {
        T front = null;
        if (!isEmpty()) {
            return array[frontIndex];
        }
        return front;
    }

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
