package adts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * File: Description:
 *
 * @author lunatunez
 * @param <T>
 */
public class List_ArrayList<T> implements ListInterface<T> {

    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<T> arrayList;

    public List_ArrayList() {
        this.arrayList = new ArrayList<>();
    }

    // *************************************************************************
    // *** STATIC METHODS ******************************************************
    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public T get(int index) {
        if (!isEmpty()) {
            return arrayList.get(index);
        } else {
            return null;
        }
    }

    @Override
    public boolean contains(T anEntry) {
        return arrayList.contains(anEntry);
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

    // *************************************************************************
    // *** MUTATOR METHODS ******************************************************
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
        // Preconditions: Valid index, valid entry
        // If the bag is empty, insert simply calls add.
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
    public T remove() {
        T temp = null;
        if (isEmpty()) {
            return temp;
        }
        temp = arrayList.remove(arrayList.size() - 1);
        return temp;

    }

    @Override
    public T remove(int index) {
        if (!isEmpty() && index >= 0 && index < arrayList.size()) {
            return arrayList.remove(index);
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
            return result;
        } else {
            arrayList.set(index, newEntry);
            result = true;
        }

        return result;
    }

    @Override
    public void clear() {
        arrayList.clear();
    }

}
