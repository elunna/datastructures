package adts;

/**
 * File: Description:
 *
 * @author lunatunez
 */
/**
 * An interface for the ADT sorted list. Entries in the list have positions that
 * begin with 1.
 *
 * @param <T>
 */
public interface SortedListInterface<T extends Comparable<? super T>> {

    /**
     * Adds a new entry to sorted list.  Entry is inserted in 
     * the appropriate order.
     *
     * @param newEntry the object to be added as a new entry
     */
    public void add(T newEntry);

    /**
     * Removes an entry from this list.
     *
     * @param anEntry The object to remove.
     * @return true if anEntry was located and removed
     */
    public boolean remove(T anEntry);

    /**
     * Gets the position of an entry in this sorted list.
     *
     * @param anEntry the object to be found
     * @return the index of the first entry, if it exists; 
     * otherwise it returns the negative position anEntry would
     * occupy.
     */
    public int getPosition(T anEntry);

    public T get(int index);

    public boolean contains(T anEntry);

    public T remove(int index);

    public void clear();

    public int size();

    public boolean isEmpty();

    public T[] toArray();
}
