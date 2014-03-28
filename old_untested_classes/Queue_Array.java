package adts;

/**
 * An outline of an array-based implementation of the ADT queue 
 * implements a queue of objects by using A Circular Array
 *
 * @author Erik Lunna
 * <eslunna@gmail.com>
 * Purpose: Circular array of queue entries and one unused location
 * @param <T>
 */
public class Queue_Array<T> implements QueueInterface<T> {
    private static final int DEFAULT_INITIAL_CAPACITY = 50;
    private T[] queue;
    private int frontIndex;
    private int backIndex;
    
  
    public Queue_Array() {
        this(DEFAULT_INITIAL_CAPACITY);
    }  

    public Queue_Array(int initialCapacity) {
        // the cast is safe because the new array contains null entries 
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[]) new Object[initialCapacity + 1];
        queue = tempQueue;
        frontIndex = 0;
        backIndex = initialCapacity;
    }


    @Override
    public void enqueue(T newEntry) {
        ensureCapacity();
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;
    }

    @Override
    public T getFront() {
        T front = null;
        if (!isEmpty()) {
            front = queue[frontIndex];
        }
        return front;
    }

    @Override
    public T dequeue() {
        T front = null;
        if (!isEmpty()) {
            front = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) % queue.length;
        }
        return front;
    }

    @Override
    public boolean isEmpty() {
        return frontIndex == ((backIndex + 1) % queue.length);
    } 
    
    /**
     * detects when the array is full, and doubles size if it is full 
     */
    private void ensureCapacity() {
        // if array is full, double size of array 
        if (frontIndex == ((backIndex + 2) % queue.length)) {
            
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            // the cast is safe because the new array contains null entries 
            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[]) new Object[2 * oldSize];
            queue = tempQueue;
            for (int index = 0; index < oldSize - 1; index++) {
                queue[index] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;
            }
            frontIndex = 0;
            backIndex = oldSize - 2;
        }
    }

    @Override
    public void clear() {
        //frontIndex = 0; backIndex = queue.length - 1;
        // or
        while (!isEmpty()) {
            dequeue();
        }
    }

    // Test this!!
    @Override
    public int getLength() {
        
        if (frontIndex < backIndex) {
            return backIndex - frontIndex;
            
        }
        else if (frontIndex > backIndex) {
            return queue.length - frontIndex + backIndex;
        }
        else 
            return -1;
    
    }

}
