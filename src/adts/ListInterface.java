package adts;

import java.util.Iterator;

/**
 * An interface for the ADT list. Entries in the list have positions that begin
 * with 0.
 *
 * @param <T>
 */
public interface ListInterface<T> {

    public static final int DEFAULT_CAPACITY = 5;

    // *************************************************************************
    // *** STATIC METHODS ******************************************************
    public int size();

    public boolean isEmpty();

    public boolean isFull();
    
    public T get(int index);

    public boolean contains(T anEntry);

    public T[] toArray();

    public void display();
    
    public Iterator getIterator();
    
    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
    public boolean add(T newEntry);

    public boolean insert(int index, T newEntry);

    public T remove(); // remove last entry

    public T remove(int index);
    
    public boolean replace(int index, T newEntry);

    public void clear();

    // maybe implement this one later
//    public void copy(int givenPosition); // copy the element, insert 
}
