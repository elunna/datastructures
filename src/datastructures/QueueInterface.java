package datastructures;

/**
 * Describes the operations for the Queue data structure. A Queue only allows
 * access to the front element. It is a First-In-First_out structure. A client
 * can enqueue items to the back of the Queue, and dequeue them from the front
 * of the Queue.
 *
 * @author Erik Lunna
 * @param <T>
 */
public interface QueueInterface<T> {

    public static final int DEFAULT_CAPACITY = 10;

    /**
     * Determines the number of entries in this Queue.
     *
     * @return the length.
     */
    public int size();

    /**
     * Detects whether this queue is full.
     *
     * @return true if the queue is full, or false otherwise
     */
    public boolean isFull();

    /**
     * Detects whether this queue is empty.
     *
     * @return true if the queue is empty, or false otherwise
     */
    public boolean isEmpty();

    /**
     * Retrieves the entry at the front of this queue.
     *
     * @return either the object at the front or, if the queue is empty, null
     */
    public T getFront();

    /**
     * Adds a new entry to the back of the queue.
     *
     * @param newEntry an object to be added
     * @return
     */
    public boolean enqueue(T newEntry);

    /**
     * AKA: 'Poll' Removes and returns the entry at the front of this queue.
     *
     * @return either the object at the front or, if the queue is empty before
     * the operation, null
     */
    public T dequeue();

    /**
     * Removes all entries from this queue.
     */
    public void clear();

    /**
     * Retrieves all entries that are in this Queue.
     *
     * @return a new array containing all the entries in the Queue.
     */
    public T[] toArray();
}
