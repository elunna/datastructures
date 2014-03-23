package adts;

import java.util.Vector;

/**
 *
 * @author Erik Lunna
 * @param <T>
 */
public class List_Vector<T> implements ListInterface<T> {

    private Vector<T> list; // entries in list
    private static int DEFAULT_INITIAL_CAPACITY = 20;

    public List_Vector(int initialSize) {
        list = new Vector<>(initialSize);
    } // end constructor

    public List_Vector() {
        this(DEFAULT_INITIAL_CAPACITY);
    } // end default constructor

    @Override
    public void add(T newEntry) {
        list.add(newEntry);
    }

    @Override
    public boolean add(int newPosition, T newEntry) {
        boolean isSuccessful = true;
        if ((newPosition >= 1) && (newPosition <= list.size() + 1)) {
            list.add(newPosition - 1, newEntry);
        } else {
            isSuccessful = false;
        }
        return isSuccessful;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;
        if ((givenPosition >= 1) && (givenPosition <= list.size())) {
            assert !isEmpty();
            list.set(givenPosition - 1, newEntry);
        } else {
            isSuccessful = false;
        }
        return isSuccessful;
    }

    @Override
    public T[] toArray() {
        // @SuppressWarnings(“unchecked”);
        T[] result = (T[]) list.toArray();
        return result;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;
        if ((givenPosition >= 1) && (givenPosition <= list.size())) {
            assert !isEmpty();
            result = list.remove(givenPosition - 1);
        }
        return result;
    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null; 
        if ((givenPosition >= 1) && (givenPosition <= list.size())) {
            assert !isEmpty();
            result = list.get(givenPosition - 1);
        }
        return result;
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean contains(T anEntry) {
        return list.contains(anEntry);
    }

    @Override
    public int getLength() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
