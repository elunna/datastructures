package adts;

/**
 * File: SetInterface.java Description: Describes an ADT set. A set is a
 * collection that cannot contain more that one of any given object. 
 * It cannot contain duplicate entries.
 * A Set has addition set operations like:
 *      Union, Intersection, sum, difference...
 *
 * @author lunatunez
 * @param <T>
 */
public interface SetInterface<T> {
    public static final int DEFAULT_CAPACITY = 5;
    
    // *************************************************************************
    // *** STATIC METHODS ******************************************************
    
    public int size();

    public int cardinality();

    public int capacity(); // get capacity, max space.

    public boolean isFull();

    public boolean isEmpty();

    public boolean contains(T anEntry);

    public boolean isElement(T anEntry); // same as contains

    public T getMin();

    public T getMax();

    public T[] toArray();

    public T[] enumerate(); // is the same as toArray???

    
    
    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
   
    public boolean add(T newEntry);

    public T remove();

    public T remove(T anEntry);

    public void clear();

    public SetInterface union(SetInterface anotherSet);

    public SetInterface intersection(SetInterface anotherSet);

    public SetInterface difference(SetInterface anotherSet);
    
    
}
