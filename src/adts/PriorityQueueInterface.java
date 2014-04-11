package adts;

/**
 *
 * @author lunatic007
 * @param <T>
 */
public interface PriorityQueueInterface<T extends Comparable<? super T>> {

    // *************************************************************************
    // *** STATIC METHODS ******************************************************
    
    /**
     * Gets the size of this priority queue.
     *
     * @return the number of entries currently in the priority queue
     */
    public int getSize();

    /**
     * Detects whether this priority queue is empty.
     *
     * @return true if the priority queue is empty, or false otherwise
     */
    public boolean isEmpty();

    /**
     * Retrieves the item with the highest priority.
     *
     * @return either the object with the highest priority or, 
     * if the priority queue is empty, null
     */
    public T peek();

    // *************************************************************************
    // *** MUTATOR METHODS ******************************************************
    
    /**
     * Adds a new entry to this priority queue.
     *
     * @param newEntry an object
     */
    public void add(T newEntry);

    /**
     * Removes and returns the item with the highest priority.
     *
     * @return either the object with the highest priority or, if the priority
     * queue is empty before the operation, null
     */
    public T remove();

    /**
     * Removes all entries from this priority queue
     */
    public void clear();

}
