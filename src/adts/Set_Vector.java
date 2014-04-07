package adts;

import java.util.Vector;

/**
 * File: Description:
 *
 * @author lunatunez
 * @param <T>
 */
public class Set_Vector<T> implements SetInterface<T> {

    private Vector<T> vector;

    public Set_Vector(Vector<T> vector) {
        this.vector = vector;
    }

    @Override
    public int size() {
        return vector.size();
    }

    @Override
    public int cardinality() {
        return vector.size();
    }

    @Override
    public boolean isEmpty() {
        return vector.isEmpty();
    }

    @Override
    public boolean contains(T anEntry) {
        if (vector.isEmpty() || anEntry == null) {
            return false;
        } else {
            return vector.contains(anEntry);
        }
    }

    @Override
    public boolean isElement(T anEntry) {
        return contains(anEntry);

    }

    @Override
    public T getMin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T getMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T[] toArray() {
        return (T[]) vector.toArray();
    }

    @Override
    public T[] enumerate() {
        return this.toArray();
    }

    @Override
    public boolean add(T newEntry) {
        boolean result = false;
        if (newEntry != null && !this.contains(newEntry)) {
            result = vector.add(newEntry);
            return result;
        } else {
            return result;
        }
    }

    @Override
    public T remove() {
        if (this.isEmpty()) {
            return null;
        } else {
            T result = vector.remove(vector.size() - 1);
            return result;
        }
    }

    @Override
    public boolean remove(T anEntry) {
        if (this.isEmpty() || anEntry == null) {
            return false;
        } else {
            boolean result = vector.remove(anEntry);
            return result;
        }
    }

    @Override
    public void clear() {
        vector.clear();
    }

    @Override
    public SetInterface union(SetInterface anotherSet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SetInterface intersection(SetInterface anotherSet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SetInterface difference(SetInterface anotherSet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
