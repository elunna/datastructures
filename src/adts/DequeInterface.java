package adts;

/**
 *
 * @author Erik Lunna
 * @param <T>
 */
public interface DequeInterface<T> {

    public static final int DEFAULT_CAPACITY = 5;

    // *************************************************************************
    // *** STATIC METHODS ******************************************************
    
    /**
     * Gets the integer size of this queue.
     *
     * @return an int indicating the length this queue
     */
    public int size();
    
    /**
     * Check if the deque is empty
     *
     * @return true if empty, false if not empty
     */
    public boolean isEmpty();

    // public boolean isFull();

    /**
     * Look at the front entry
     *
     * @return a reference to the entry at the front
     */
    public T getFront();

    /**
     * Look at the back entry
     *
     * @return a reference to the entry at the back
     */
    public T getBack();

    
    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
    /**
     * Add an entry to the front of the deque
     *
     * @param newEntry is the entry to add
     * @return
     */
    public boolean addToFront(T newEntry);

    /**
     * Add an entry to the back of the deque
     *
     * @param newEntry is the entry to add
     * @return
     */
    public boolean addToBack(T newEntry);

    /**
     * Remove the entry from the front of the deque
     *
     * @return the remove entry if successful, otherwise null
     */
    public T removeFront();

    /**
     * Remove the entry from the back of the deque
     *
     * @return the remove entry if successful, otherwise null
     */
    public T removeBack();

    /**
     * Delete all entries in deque
     */
    public void clear();
}
