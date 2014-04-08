package adts;

import java.util.Vector;

/**
 * File:        
 * Description: 
 * @author lunatunez
 * @param <T>
 */

public class List_Vector<T> implements ListInterface<T> {
    private Vector vector;

    // *************************************************************************
    // *** STATIC METHODS ******************************************************
    @Override
    public int size() {
        return vector.size();
    }

    @Override
    public boolean isEmpty() {
        return vector.isEmpty();
    }

    @Override
    public T get(int index) {
        return (T) vector.get(index);
        
    }

    @Override
    public boolean contains(T anEntry) {
        return vector.contains(anEntry);
    }

    @Override
    public T[] toArray() {
        return (T[]) vector.toArray();
    }

    
    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
    
    @Override
    public boolean add(T newEntry) {
        return vector.add(newEntry);
    }

    @Override
    public boolean insert(int index, T newEntry) {
        vector.add(index, newEntry);
        return true;
    }

    @Override
    public T remove() {
        Object result = vector.get(0);
        vector.remove(0);
        return (T) result;
    }

    @Override
    public T remove(int index) {
        Object result = vector.get(index);
        vector.remove(index);
        return (T) result;
    }

    @Override
    public boolean replace(int index, T newEntry) {
        if (vector.set(index, newEntry) != null) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        vector.clear();
    }
}