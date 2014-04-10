package adts;

import java.util.Vector;

/**
 * File: Description:
 *
 * @author lunatunez
 * @param <T>
 */
public class List_Vector<T> implements ListInterface<T> {

    @SuppressWarnings("FieldMayBeFinal")
    private Vector vector;

    public List_Vector() {
        this.vector = new Vector<>();
    }

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
        if (index < 0
                || index > vector.size() - 1
                || isEmpty()) {
            return null;
        } else {

            return (T) vector.get(index);
        }
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
        if (newEntry != null) {
            return vector.add(newEntry);
        } else {
            return false;
        }
    }

    @Override
    public boolean insert(int index, T newEntry) {
        if (index < 0
                || index > vector.size()
                || newEntry == null) {
            return false;
        } else {
            vector.add(index, newEntry);
            return true;
        }
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        } else {
            Object result = vector.get(0);
            vector.remove(0);
            return (T) result;
        }
    }

    @Override
    public T remove(int index) {
        if (isEmpty()
                || index < 0
                || index > vector.size() - 1) {
            return null;
        } else {
            Object result = vector.get(index);
            vector.remove(index);
            return (T) result;
        }
    }

    @Override
    public boolean replace(int index, T newEntry) {
        if (index < 0 || 
                index > vector.size() - 1 ||
                newEntry == null) {
            return false;
        } else {
            vector.set(index, newEntry);
            return true;
        }

    }

    @Override
    public void clear() {
        vector.clear();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
