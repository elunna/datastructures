package datastructures;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Vector;

/**
 * A dynamic size Set using a Vector implementation.
 *
 * @author Erik Lunna
 * @param <T>
 */
public class Set_Vector<T> implements SetInterface<T> {

    @SuppressWarnings("FieldMayBeFinal")
    private Vector<T> vector;

    public Set_Vector() {
        this.vector = new Vector<>();
    }

    @Override
    public int size() {
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

    @Override
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
        Set_ResizableArray union = new Set_ResizableArray();
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
        Set_ResizableArray intersection = new Set_ResizableArray();

        for (int i = 0; i < this.size(); i++) {
            if (anotherSet.contains((Comparable) vector.get(i))) {
                intersection.add(vector.get(i));
            }
        }
        return intersection;
    }

    @Override
    public SetInterface difference(SetInterface anotherSet) {
        Set_ResizableArray difference = new Set_ResizableArray();

        for (int i = 0; i < this.size(); i++) {
            if (!anotherSet.contains((Comparable) vector.get(i))) {
                difference.add(vector.get(i));
            }
        }
        return difference;
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
    public T remove(int index) {
        if (this.isEmpty() 
                || index < 0 
                || index > vector.size() - 1) {
            return null;
        } else {
            Object result = vector.remove(index);
            return (T) result;
        }
    }

    @Override
    public T remove(T anEntry) {
        if (this.isEmpty()
                || anEntry == null) {
            throw new IllegalArgumentException();
        } else {
            T copy = anEntry;
            boolean result = vector.remove(anEntry);
            return copy;
        }
    }

    @Override
    public void clear() {
        vector.clear();
    }

    @Override
    public Iterator getIterator() {
        return vector.iterator();

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
        if (!(aThat instanceof Set_Vector)) {
            return false;
        }
        Set_Vector that = (Set_Vector) aThat;
        return Arrays.equals(this.toArray(), that.toArray()); //array!
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.vector);
        return hash;
    }

}

//    
//    // Displays all the elements of bag line by line.
//    @Override
//    public void display() {
//        displayArray(0, vector.size() - 1);
//    }
//
//    /**
//     * Does the work of recursively displaying the individual elements
//     *
//     * @param first
//     * @param last
//     */
//    private void displayArray(int first, int last) {
//        System.out.println(vector.get(first));
//        if (first < last) {
//            displayArray(first + 1, last);
//        }
//    }
