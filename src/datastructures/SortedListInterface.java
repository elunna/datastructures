package datastructures;

import java.util.Iterator;

/**
 *
 * @author Erik Lunna
 */
/**
 * An interface for the ADT sorted list. Entries in the list have positions that
 * begin with 1.
 *
 * @param <T>
 */
public interface SortedListInterface<T extends Comparable<? super T>> {

    /**
     * Determines the number of entries in this List.
     *
     * @return the size.
     */
    public int size();

    /**
     * Determines whether this SortedList is empty.
     *
     * @return true if empty, false if not.
     */
    public boolean isEmpty();

    /**
     * Detects whether this List contains a given entry.
     *
     * @param anEntry the entry to locate
     * @return true if the List contains anEntry, or false otherwise
     */
    public boolean contains(T anEntry);

    /**
     * Gets the position of an entry in this sorted list.
     *
     * @param anEntry the object to be found
     * @return the index of the first entry, if it exists; otherwise it returns
     * the negative position anEntry would occupy.
     */
    public int getPosition(T anEntry);

    public T get(int index);

    /**
     * Adds a new entry to sorted list. Entry is inserted in the appropriate
     * order.
     *
     * @param newEntry the object to be added as a new entry
     * @return
     */
    public boolean add(T newEntry);

    /**
     * Removes an entry from this list.
     *
     * @param anEntry The object to remove.
     * @return true if anEntry was located and removed
     */
    public boolean remove(T anEntry);

    /**
     * Removes and returns the entry at a given index within the List.
     *
     * @param index to remove.
     * @return The entry, if it exists, or throw an exception if an invalid
     * index was given.
     */
    public T remove(int index);

    /**
     * Removes all entries from this List.
     */
    public void clear();

    /**
     * Generates a new iterator instance for this List.
     *
     * @return an iterator.
     */
    public Iterator getIterator();

    /**
     * Retrieves all entries that are in this List.
     *
     * @return a new array containing all the entries in the List.
     */
    public T[] toArray();
}
