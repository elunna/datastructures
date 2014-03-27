package adts;

/**
 *
 * @author Erik Lunna<eslunna@gmail.com>
 * @param <T>
 */
public interface StackInterface<T> {

    /**
     * Adds a new entry to the top of this stack.
     *
     */
    public void push(T newEntry);

    /**
     * Removes and returns this stack’s top entry.
     *
     * @return either object at top or, if empty before op, null
     */
    public T pop();

    /**
     * Retrieves this stack’s top entry.
     *
     * empty
     */
    public T peek();

    /**
     * Detects whether this stack is empty
     */
    public boolean isEmpty();

    /**
     * Removes all entries from this stack
     */
    public void clear();
}

