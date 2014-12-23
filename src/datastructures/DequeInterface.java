package datastructures;

/**
 * Describes the operations for the Deque data structure. A Deque only allows
 * access to the front and back elements. It can act as a FIFO structure or a
 * LIFO structure. A client can enqueue items to the back of the Queue, and
 * dequeue them from the front of the Queue.
 *
 * @author Erik Lunna
 * @param <T>
 */
public interface DequeInterface<T> {

    public static final int DEFAULT_CAPACITY = 10;

    /**
     * Gets the size of this Deque.
     *
     * @return the length.
     */
    public int size();

    /**
     * Checks if the Deque is empty.
     *
     * @return true if empty, false if not empty
     */
    public boolean isEmpty();

    /**
     * Returns the value of the front-most entry.
     *
     * @return the front value.
     */
    public T peekFront();

    /**
     * Returns the value of the back-most entry.
     *
     * @return the back value.
     */
    public T peekBack();

    /**
     * Retrieves all entries that are in this Deque.
     *
     * @return a new array containing all the entries in the Deque .
     */
    public T[] toArray();

    /**
     * Add an entry to the front of the Deque.
     *
     * @param newEntry is the entry to add
     * @return
     */
    public boolean pushFront(T newEntry);

    /**
     * Adds an entry to the back of the Deque.
     *
     * @param newEntry is the entry to add
     * @return
     */
    public boolean pushBack(T newEntry);

    /**
     * Removes the entry from the front of the Deque.
     *
     * @return the removed entry if successful, otherwise null
     */
    public T popFront();

    /**
     * Removes the entry from the back of the Deque.
     *
     * @return the removed entry if successful, otherwise null
     */
    public T popBack();

    /**
     * Delete all entries in Deque.
     */
    public void clear();
}
