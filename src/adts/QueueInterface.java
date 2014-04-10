package adts;

/**
 * @author Erik Lunna<eslunna@gmail.com>
 * @param <T>
 */
public interface QueueInterface<T> {
    public static final int DEFAULT_CAPACITY = 5;

    // *************************************************************************
    // *** STATIC METHODS ******************************************************

        /**
     * Gets the integer size of this queue.
     * @return  an int indicating the length this queue
     */
    public int size();

    
    /**
     * Detects whether this queue is empty.
     *
     * @return true if the queue is empty, or false otherwise
     */
    public boolean isEmpty();

    
    /**
     * Detects whether this queue is full.
     *
     * @return true if the queue is full, or false otherwise
     */
    public boolean isFull();

    
    /**
     * Retrieves the entry at the front of this queue.
     *
     * @return either the object at the front or, if the queue is
     * empty, null
     */
    public T getFront();

    
    
    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
   
    
    /**
     * Adds a new entry to the back of the queue.
     *
     * @param newEntry an object to be added
     * @return 
     */
    public boolean enqueue(T newEntry);

    /**
     * AKA: 'Poll'
     * Removes and returns the entry at the front of this queue.
     *
     * @return either the object at the front or, if the queue is
     * empty before the operation, null
     */
    public T dequeue();

    /**
     * Removes all entries from this queue.
     */
    public void clear();

}