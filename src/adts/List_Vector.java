package adts;

import java.util.Arrays;
import java.util.Objects;
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

    @Override
    public boolean equals(Object aThat) {
        if (this == aThat) {
            return true;
        }
        if (!(aThat instanceof List_Vector)) {
            return false;
        }
        List_Vector that = (List_Vector) aThat;
        return Arrays.equals(this.toArray(), that.toArray()); //array!
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.vector);
        return hash;
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
