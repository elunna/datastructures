package datastructures;

import java.util.Iterator;

/**
 * Describes the operations for the List data structure.
 *
 * @param <T>
 */
public interface ListInterface<T> {

    /**
     * Sets the default capacity for a List.
     */
    public static final int DEFAULT_CAPACITY = 10;

    /**
     * Determines the number of entries in this List.
     *
     * @return the size.
     */
    public int size();

    /**
     * Determines whether this List is full.
     *
     * @return true if full, false if not.
     */
    public boolean isFull();

    /**
     * Determines whether this List is empty.
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
     * Counts the number of times a given entry appears in this List.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the List.
     */
    public int count(T anEntry);

    /**
     * Returns the data type at the specific index if it exists.
     *
     * @param index to query.
     * @return The data if it exists, or throw an exception if an invalid index
     * was given.
     */
    public T get(int index);

    /**
     * Adds a new entry to this List.
     *
     * @param newEntry the object to be added as a new entry
     * @return true if the addition is successful, or false if not.
     */
    public boolean add(T newEntry);

    /**
     * Adds a new entry to a specific index within this List.
     *
     * @param index to insert at.
     * @param newEntry the object to be added as a new entry
     * @return true if the addition is successful, or false if not.
     */
    public boolean insert(int index, T newEntry);

    /**
     * Removes and returns the entry at a given index within the List.
     *
     * @param index to remove.
     * @return The entry, if it exists, or throw an exception if an invalid
     * index was given.
     */
    public T remove(int index);

    /**
     * Removes a specific entry from this List.
     *
     * @param anEntry the entry to be removed
     * @return The object T or null if it doesn't exist. Throws an
     * IllegalArgumentException if an invalid index is given.
     *
     */
    public T remove(T anEntry);

    /**
     * Replaces an existing entry with the given entry.
     *
     * @param index to replace
     * @param newEntry is the replacer.
     * @return true if the addition is successful, or false if not.
     */
    public boolean replace(int index, T newEntry);

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