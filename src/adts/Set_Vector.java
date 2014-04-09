package adts;

import java.util.Vector;

/**
 * File: Description:
 *
 * @author lunatunez
 * @param <T>
 */
public class Set_Vector<T> implements SetInterface<T> {

    @SuppressWarnings("FieldMayBeFinal")
    private Vector<T> vector;

    public Set_Vector() {
        this.vector = new Vector<>();
    }
    // *************************************************************************
    // *** STATIC METHODS ******************************************************

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
    public boolean isFull() {
        return false;
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
    public T[] toArray() {
        return (T[]) vector.toArray();
    }

    @Override
    public T[] enumerate() {
        return this.toArray();
    }

    public T getMin() {
        if (vector.isEmpty()) {
            return null;
        } else {
            T min = vector.get(0);
            for (int i = 0; i < vector.size(); i++) {
                if (((Comparable) min).compareTo((Comparable) vector.get(i)) < 0) {
                    min = vector.get(i);
                }
            }
            return min;
        }
    }

    public T getMax() {
        if (vector.isEmpty()) {
            return null;
        } else {
            T max = vector.get(0);
            for (int i = 0; i < vector.size(); i++) {
                if (((Comparable) max).compareTo((Comparable) vector.get(i)) > 0) {
                    max = vector.get(i);
                }
            }
            return max;
        }
    }

    @Override
    public SetInterface union(SetInterface anotherSet) {
        Set_Array union = new Set_Array();
        // Add all the elements of this set
        for (T t : this.toArray()) {
            if (!union.contains(t)) {
                union.add(t);
            }
        }
        // Add the element from the other set, checking duplicates
        for (Object t : anotherSet.toArray()) {
            if (!union.contains((Comparable) t)) {
                union.add((Comparable) t);
            }
        }
        return union;
    }

    @Override
    public SetInterface intersection(SetInterface anotherSet) {
        Set_Array intersection = new Set_Array();

        for (int i = 0; i < this.size(); i++) {
            if (anotherSet.contains((Comparable) vector.get(i))) {
                intersection.add(vector.get(i));
            }
        }
        return intersection;
    }

    @Override
    public SetInterface difference(SetInterface anotherSet) {
        Set_Array difference = new Set_Array();

        for (int i = 0; i < this.size(); i++) {
            if (!anotherSet.contains((Comparable) vector.get(i))) {
                difference.add(vector.get(i));
            }
        }
        return difference;
    }

    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
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
    public T remove(int index) {
        if (this.isEmpty() || index < 0 || index > vector.size() - 1) {
            return null;
        } else {
            Object result = vector.remove(index);
            return (T) result;
        }

    }

}
