package datastructures;

import java.util.Iterator;

/**
 * File: SetInterface.java Description: Describes an ADT set. A set is a
 * collection that cannot contain more that one of any given object. It cannot
 * contain duplicate entries. A Set has addition set operations like: Union,
 * Intersection, sum, difference...
 *
 * @author Erik Lunna
 * @param <T>
 */
public interface SetInterface<T> {

    public static final int DEFAULT_CAPACITY = 5;

    /**
     * Determines the number of entries in this Set.
     *
     * @return the size.
     */
    public int size();

    /**
     * Determines whether this Set is empty.
     *
     * @return true if empty, false if not.
     */
    public boolean isEmpty();

    /**
     * Detects whether this Set contains a given entry.
     *
     * @param entry
     * @return true if the Set contains anEntry, or false otherwise
     */
    public boolean contains(T entry);

    /**
     * Adds a new entry to this Set.
     *
     * @param newEntry the object to be added as a new entry
     * @return true if the addition is successful, or false if not.
     */
    public boolean add(T newEntry);

    /**
     * Removes and returns the entry at a given index within the Set.
     *
     * @param index to remove.
     * @return The entry, if it exists, or throw an exception if an invalid
     * index was given.
     */
    public T remove(int index);

    /**
     * Removes a specific entry from this Set.
     *
     * @param anEntry the entry to be removed
     * @return The object T or null if it doesn't exist. Throws an
     * IllegalArgumentException if an invalid index is given.
     *
     */
    public T remove(T anEntry);

    /**
     * Removes all entries from this Set.
     */
    public void clear();

    /**
     * Generates a new iterator instance for this Set.
     *
     * @return an iterator.
     */
    public Iterator getIterator();

    /**
     * Retrieves all entries that are in this Set.
     *
     * @return a new array containing all the entries in the Set.
     */
    public T[] toArray();

    /**
     *
     * @return The lowest value object T in the Set.
     */
    public T getMin();

    /**
     *
     * @return The highest value object T in the Set.
     */
    public T getMax();

    /**
     * Find the union of two Sets.
     *
     * @param anotherSet to compare to this one.
     * @return the union
     */
    public SetInterface union(SetInterface anotherSet);

    /**
     * Find the intersection of two Sets.
     *
     * @param anotherSet to compare to this one.
     * @return the intersection.
     */
    public SetInterface intersection(SetInterface anotherSet);

    /**
     * Find the difference of two Sets.
     *
     * @param anotherSet to compare to this one.
     * @return the difference.
     */
    public SetInterface difference(SetInterface anotherSet);
}


//    public void display();
