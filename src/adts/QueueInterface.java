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
     * Retrieves the entry at the front of this queue.
     *
     * @return either the object at the front or, if the queue is
     * empty, null
     */
    public T getFront();

    /**
     * Detects whether this queue is empty.
     *
     * @return true if the queue is empty, or false otherwise
     */
    public boolean isEmpty();

    /**
     * Gets the integer size of this queue.
     * @return  an int indicating the length this queue
     */
    public int getLength();
    
    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
   
    
    /**
     * Adds a new entry to the back of the queue.
     *
     * @param newEntry an object to be added
     */
    public void enqueue(T newEntry);

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