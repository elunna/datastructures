package adts;

/**
 *
 * @author Erik Lunna<eslunna@gmail.com>
 * @param <T>
 */
public interface StackInterface<T> {

    public static final int DEFAULT_INITIAL_CAPACITY = 5;
    // *************************************************************************
    // *** STATIC METHODS ******************************************************

    /**
     * Retrieves this stack’s top entry.
     *
     * @return The object at the top or, if empty return null
     */
    public T peek();

    /**
     * Retrieves the entry under this stack’s top entry.
     *
     * @return The object under the top or, if it DNE return null
     */
    public T peek2();

    /**
     * Detects whether this stack is empty
     *
     * @return true if empty, false if there are contents in the stack.
     */
    public boolean isEmpty();

    /**
     * @return the current size of the Stack
     */
    public int getSize();

    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
    /**
     * Adds a new entry to the top of this stack.
     *
     * @param newEntry is a non-null entry.
     * @return Returns true if the operation succeeded. If passed a null
     * newEntry, return false. If the operation fails, return false.
     */
    public boolean push(T newEntry);

    /**
     * Removes and return top entry of stack
     *
     * @return The object at the top or, if empty return null
     */
    public T pop();

    /**
     * Removes all entries from this stack
     */
    public void clear();

}
