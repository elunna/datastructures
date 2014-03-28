package adts;

/**
 *
 * @author Erik Lunna
 * @param <T>
 */
public interface DequeInterface<T> {

    /**
     * Add an entry to the front of the deque
     * @param newEntry is the entry to add
     */
    public void addToFront(T newEntry);

    /**
     * Add an entry to the back of the deque
     * @param newEntry is the entry to add
     */
    public void addToBack(T newEntry);

    /**
     * Remove the entry from the front of the deque
     * @return the remove entry if successful, otherwise null
     */
    public T removeFront();

    /**
     * Remove the entry from the back of the deque
     * @return the remove entry if successful, otherwise null
     */
    public T removeBack();

    /**
     * Look at the front entry
     * @return a reference to the entry at the front
     */
    public T getFront();

    /**
     * Look at the back entry
     * @return a reference to the entry at the back
     */
    public T getBack();

    /**
     * Check if the deque is empty
     * @return true if empty, false if not empty
     */
    public boolean isEmpty();

    /**
     * Delete all entries in deque
     */
    public void clear();
}