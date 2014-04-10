package adts;

/**
 * File: SetInterface.java Description: Describes an ADT set. A set is a
 * collection that cannot contain more that one of any given object. It cannot
 * contain duplicate entries. A Set has addition set operations like: Union,
 * Intersection, sum, difference...
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

    public boolean isEmpty();

    public boolean isFull();
    // only needed for arrays
    //public int capacity(); // get capacity, max space.
    // we don't need this for chains, only arrays

    public boolean contains(T anEntry);

    public boolean isElement(T anEntry); // same as contains

    public T[] toArray();

    public T[] enumerate();

//    public T getMin();
//
//    public T getMax();
    
    public SetInterface union(SetInterface anotherSet);

    public SetInterface intersection(SetInterface anotherSet);

    public SetInterface difference(SetInterface anotherSet);

    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
    public boolean add(T newEntry);

    public T remove();

    public T remove(int index);
    
    public boolean remove(T anEntry);
    
    

    public void clear();

}
