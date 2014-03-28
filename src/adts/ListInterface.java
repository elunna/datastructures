package adts;

/**
 * An interface for the ADT list. Entries in the list have positions that begin
 * with 1.
 *
 * @param <T>
 */
public interface ListInterface<T> {

    /**
     * Adds a new entry to the end of this list. 
     * Entries currently in list are unaffected.
     *
     * @param newEntry the object to be added as a new entry
     */
    public void add(T newEntry);

    /**
     * Adds an entry to the position within the list. 
     * This pushes entries at or above the position specified up 1.
     *
     * @param newPosition int that specifies the new position
     * @param newEntry the object to add
     * @return true if successful, 
     *      or false if newPosition < 1,
            * or newPosition > getLength() + 1
     */
    public boolean add(int newPosition, T newEntry);

    /**
     * Removes the entry at a given position. 
     * Existing entries are dropped down 1 if they were above the entry.
     *
     * @param givenPosition integer that specifies position to remove
     * @return a reference to the removed entry 
     *      or null, if list is empty, 
     *      or givenPosition < 1, 
     *      or givenPosition > getLength()
     */
    public T remove(int givenPosition);

    /**
     * Removes all entries from this list.
     */
    public void clear();

    /**
     * Replaces an entry at an index with another entry
     *
     * @param givenPosition integer that specifies the position of the entry
     * to replace
     * @param newEntry the object that will take the place of the existing entry
     * @return true for a successful replacement, 
     * or false if either the list is empty, givenPosition < 1, 
     * or givenPosition > getLength()
     */
    public boolean replace(int givenPosition, T newEntry);

    /**
     * Retrieves the entry at a given position in this list.
     *
     * @param givenPosition integer that specifies the index of the entry
     * @return a reference to the indicated entry or null, 
     * if either the list is empty, givenPosition < 1, 
     * or givenPosition > getLength()
     */
    public T getEntry(int givenPosition);

    /**
     * Determine whether this list contains a specific entry.
     *
     * @param anEntry the object that represents the desired entry
     * @return true if the list contains anEntry, or false if not
     */
    public boolean contains(T anEntry);

    /**
     * Gets the length of this list.
     *
     * @return the integer number of entries currently in the list
     */
    public int getLength();

    /**
     * Sees whether this list is empty.
     *
     * @return true if the list is empty, or false if not
     */
    public boolean isEmpty();

    /**
     * Retrieves an array that is a copy of the current entries in the list.
     *
     * @return
     */
    public T[] toArray();
}
