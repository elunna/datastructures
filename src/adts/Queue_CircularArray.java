package adts;

/**
 * Description: This acts as a resizeable waiting line, or queue.
 * Entries are added to the back, and removed from the front.
 * If more entries are added then the current current capacity holds, 
 * the ensureCapacity method doubles the carrying capacity and adds it.
 *
 * This circular array structure contains one unused space.
 * This space is used because it enables us to only need
 * the frontindex and backindex to calculate if the queue
 * is full or empty.
 * 
 * Specifically, 
 *  the queue is full when 
 *      frontIndex == (backIndex + 2) % queue.length
 * 
 *  the queue is empty when,
 *      frontIndex == (backIndex + 1) % queue.length
 * 
 * @author Erik Lunna<eslunna@gmail.com>
 * Date: 11/12 Purpose:
 * @param <T>
 */
public class Queue_CircularArray<T> implements QueueInterface<T> {

    private static final int INITIAL_CAPACITY = 20;
    private T[] queue;
    private int frontIndex;
    private int backIndex;

    public Queue_CircularArray() {
        this(INITIAL_CAPACITY);
    }

    public Queue_CircularArray(int capacity) {
        // the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempBag; // unchecked cast
        tempBag = (T[]) new Object[capacity];
        queue = tempBag;
        frontIndex = 0;
        backIndex = INITIAL_CAPACITY;
    }

    @Override
    public void enqueue(T newEntry) {
        ensureCapacity();
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;

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
    public T getFront() {
        T front = null;
        if (!isEmpty()) {

            return queue[frontIndex];
        }
        return front;
    }

    @Override
    public boolean isEmpty() {
        return frontIndex == ((backIndex + 1) % queue.length);
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    // Copied from Queue_Array, check this. 
    // May be able to use a clear algorithm.
@Override
    public int getLength() {
        if (frontIndex == -1) {
            return 0;
        }       
        else if (frontIndex > backIndex) {
            return (queue.length - frontIndex) + backIndex;
        }
        else if (frontIndex < backIndex) {
            return backIndex - frontIndex + 1;
        }
        else {
            return 1;   // Size is 1.
        }
    }

    private void ensureCapacity() {
        if (frontIndex == ((backIndex + 2) % queue.length)) {
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[]) new Object[2 - oldSize];
            queue = tempQueue;

            for (int index = 0; index < oldSize - 1; index++) {
                queue[index] = oldQueue[frontIndex];
            }
            frontIndex = (frontIndex + 1) % oldSize;
            frontIndex = 0;
            backIndex = oldSize - 2;
        }
    }
}