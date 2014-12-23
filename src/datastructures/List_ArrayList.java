package datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * A dynamic size List ADT using an ArrayList implementation.
 *
 * @author Erik Lunna
 * @param <T>
 */
public class List_ArrayList<T> implements ListInterface<T> {

    public static final int DEFAULT_CAPACITY = 10;
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<T> arrayList;

    public List_ArrayList() {
        this.arrayList = new ArrayList<>();
    }

    @Override
    public boolean add(T newEntry) {
        if (newEntry != null) {
            return arrayList.add(newEntry);
        } else {
            return false;
        }
    }

    @Override
    public boolean insert(int index, T newEntry) {
        if (index < 0
                || index > arrayList.size()
                || newEntry == null) {
            return false;
        } else if (isEmpty()) {
            return arrayList.add(newEntry);
        } else {
            arrayList.add(index, newEntry);
            return true;
        }
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public T get(int index) {
        if (isEmpty()
                || index < 0
                || index >= arrayList.size()) {
            throw new IllegalArgumentException();
        } else {

            return arrayList.get(index);
        }
    }

    @Override
    public boolean contains(T anEntry) {
        return arrayList.contains(anEntry);
    }

    @Override
    public T remove(int index) {
        if (isEmpty()
                || index < 0
                || index > arrayList.size() - 1) {
            throw new IllegalArgumentException();
        } else {
            return arrayList.remove(index);
        }
    }

    @Override
    public T remove(T anEntry) {
        if (isEmpty() || anEntry == null) {
            throw new IllegalArgumentException();
        }
        if (arrayList.remove(anEntry)) {
            return anEntry;
        } else {
            return null;
        }
    }

    @Override
    public boolean replace(int index, T newEntry) {
        boolean result = false;
        if (isEmpty()
                || index < 0
                || index > arrayList.size() - 1
                || newEntry == null) {
            return false;
        } else {
            arrayList.set(index, newEntry);
            return true;
        }
    }

    @Override
    public int count(T anEntry) {
        int count = 0;
        for (T arrayList1 : arrayList) {
            if (anEntry == arrayList1) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public void clear() {
        arrayList.clear();
    }

    @Override
    public Iterator getIterator() {
        return arrayList.iterator();

    }

    @Override
    public T[] toArray() {
        return (T[]) arrayList.toArray();
    }

    @Override
    public boolean equals(Object aThat) {
        if (this == aThat) {
            return true;
        }
        if (!(aThat instanceof List_ArrayList)) {
            return false;
        }
        List_ArrayList that = (List_ArrayList) aThat;
        return Arrays.equals(this.toArray(), that.toArray()); //array!
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.arrayList);
        return hash;
    }

    /**
     * Removes the last entry from this bag, if possible.
     *
     * @return either the removed entry, if the removal was successful, or null
     * otherwise
     */
    private T remove() {
        T temp = null;
        if (isEmpty()) {
            return temp;
        }
        temp = arrayList.remove(arrayList.size() - 1);
        return temp;
    }
}

//    // Displays all the elements of bag line by line.
//    @Override
//    public void display() {
//        displayArray(0, arrayList.size() - 1);
//    }
//    /**
//     * Does the work of recursively displaying the individual elements
//     *
//     * @param first
//     * @param last
//     */
//    private void displayArray(int first, int last) {
//        System.out.println(arrayList.get(first));
//        if (first < last) {
//            displayArray(first + 1, last);
//        }
//    }
