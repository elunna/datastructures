package datastructures;

/**
 * Describes the operations for the Stack data structure. A Stack only allows
 * access to the top element, tt is a Last-In-First-out structure. A client can
 * push items to the top of the Stack and pop them off one at a time.
 *
 * @author Erik Lunna
 * @param <T>
 */
public interface StackInterface<T> {

    public static final int DEFAULT_INITIAL_CAPACITY = 5;

    /**
     * Determines the current number of entries in this Stack.
     *
     * @return the size/length.
     */
    public int size();

    /**
     * Detects whether this stack is empty
     *
     * @return true if empty, false if there are contents in the stack.
     */
    public boolean isEmpty();

    /**
     * Retrieves this stack’s top entry.
     *
     * @return The object at the top or, if empty, return null
     */
    public T peek();

    /**
     * Adds a new entry to the top of this stack.
     *
     * @param newEntry is a non-null entry.
     * @return Returns true if the operation succeeded. If passed a null
     * newEntry or if the operation fails, return false.
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

    /**
     * Retrieves all entries that are in this Stack.
     *
     * @return a new array containing all the entries in the Stack.
     */
    public T[] toArray();

}

//    public void display();
