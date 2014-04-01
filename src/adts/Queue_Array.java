package adts;

/**
 * File:    Queue_Array
 * Description: This queue is fixed capacity, it is capable
 * of reaching a full state and rejecting any new entries.
 * 
 * This array also works in a circular fashion, but it can
 * fill all of its entries.
 * 
 * @author Erik Lunna<eslunna@gmail.com>
 * Date: 11/12 Purpose:
 * @param <T>
 */
public class Queue_Array<T> implements QueueInterface<T> {

    private static final int INITIAL_CAPACITY = 20;
    private int capacity;
    private T[] array;
    private int frontIndex;
    private int backIndex;

    public Queue_Array() {
        this(INITIAL_CAPACITY);
    }

    public Queue_Array(int capacity) {
        // the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempBag; // unchecked cast
        tempBag = (T[]) new Object[capacity];
        array = tempBag;
        frontIndex = -1;    // If frontIndex = -1, the queue is empty
        backIndex = -1;
    }

    @Override
    public void enqueue(T newEntry) {
        if (!isEmpty() && !isFull()) {
            // case 1: The back of the line coincide with the end of the array
            if (backIndex == array.length - 1) {
                backIndex = 0;
            } // case 2: The back of the line is any other index.
            else {
                backIndex++;
            }
            // move the new entry into the array.
            array[backIndex] = newEntry;
        } else {
            // the queue is empty, default both to 0.
            frontIndex = 0;
            backIndex = 0;
        }
        
        // or use
        // backIndex = (backIndex + 1) % queue.length;

    }

    @Override
    public T dequeue() {
        // check that array isn't empty
        if (isEmpty()) {
            return null;
        }
        // copy and remove the front entry.
        T front = array[frontIndex];

        // check that size is one.
        if (frontIndex == backIndex) {
            frontIndex = -1; // set to cleared.
        } else {
            if (frontIndex < array.length - 1) {
                frontIndex++;
            } else {
                frontIndex = 0;
            }

        }
        return front;
    }

    @Override
    public T getFront() {
        if (!isEmpty()) {
            return array[frontIndex];
        } else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return frontIndex == -1;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    @Override
    public int getLength() {
        if (frontIndex == -1) {
            return 0;
        }       
        else if (frontIndex > backIndex) {
            return (array.length - frontIndex) + backIndex;
        }
        else if (frontIndex < backIndex) {
            return backIndex - frontIndex + 1;
        }
        else {
            return 1;   // Size is 1.
        }
    }

    private boolean isFull() {
        // check that the indices are adjacent.
        return (backIndex - frontIndex == 0
                || frontIndex - backIndex == 1);
    }
}
