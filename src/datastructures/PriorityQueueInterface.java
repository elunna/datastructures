package datastructures;

/**
 * Describes the typical operations of a PriorityQueue. A PriorityQueue limits
 * access to only the highest priority object in the collection. A client can
 * either peek at the top object, or go ahead and dequeue it.
 *
 * @author Erik Lunna
 * @param <T>
 */
public interface PriorityQueueInterface<T extends Comparable<? super T>> {

    /**
     * Gets the size of this priority queue.
     *
     * @return the number of entries currently in the priority queue
     */
    public int size();

    /**
     * Detects whether this priority queue is empty.
     *
     * @return true if the priority queue is empty, or false otherwise
     */
    public boolean isEmpty();

    /**
     * Retrieves the item with the highest priority.
     *
     * @return either the object with the highest priority or, if the priority
     * queue is empty, null
     */
    public T peek();

    /**
     * Adds a new entry to this priority queue.
     *
     * @param newEntry an object
     * @return
     */
    public boolean enqueue(T newEntry);

    /**
     * Removes and returns the item with the highest priority.
     *
     * @return either the object with the highest priority or, if the priority
     * queue is empty before the operation, null
     */
    public T dequeue();

    /**
     * Removes all entries from this priority queue
     */
    public void clear();
}
