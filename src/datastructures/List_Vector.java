package datastructures;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Vector;

/**
 * A dynamic size List ADT using a Vector implementation.
 *
 * @author Erik Lunna
 * @param <T>
 */
public class List_Vector<T> implements ListInterface<T> {

    @SuppressWarnings({"FieldMayBeFinal", "UseOfObsoleteCollectionType"})
    private Vector vector;

    public List_Vector() {
        this.vector = new Vector<>();
    }

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
    public int size() {
        return vector.size();
    }

    @Override
    public T get(int index) {
        if (index < 0
                || index > vector.size() - 1
                || isEmpty()) {
            throw new IllegalArgumentException();
        } else {

            return (T) vector.get(index);
        }
    }

    @Override
    public boolean contains(T anEntry) {
        return vector.contains(anEntry);
    }

    @Override
    public T remove(int index) {
        if (isEmpty()
                || index < 0
                || index > vector.size() - 1) {
            throw new IllegalArgumentException();
        } else {
            Object result = vector.get(index);
            vector.remove(index);
            return (T) result;
        }
    }

    @Override
    public boolean replace(int index, T newEntry) {
        if (index < 0
                || index > vector.size() - 1
                || newEntry == null) {
            return false;
        } else {
            vector.set(index, newEntry);
            return true;
        }
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int count(T anEntry) {
        int count = 0;
        for (int i = 0; i < vector.size(); i++) {
            if (anEntry == vector.get(i)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return vector.isEmpty();
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

    @Override
    public T remove(T entry) {
        if (isEmpty() || entry == null) {
            throw new IllegalArgumentException();
        }
        if (vector.remove(entry)) {
            return entry;
        } else {
            return null;
        }
    }

    private T remove() {
        if (isEmpty()) {
            return null;
        } else {
            Object result = vector.get(0);
            vector.remove(0);
            return (T) result;
        }
    }

}

// // Displays all the elements of bag line by line.
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
