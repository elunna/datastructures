package datastructures;

import java.util.Iterator;

/**
 *
 * @author Erik Lunna
 * @param <T>
 */
public class ArrayIterator<T> implements Iterator {

    T[] list;
    int position = 0;

    /**
     * This is the regular ArrayIterator constructor that takes an array of
     * objects to process.
     *
     * @param array
     */
    public ArrayIterator(T[] array) {
        this.list = array;
    }

    /**
     * Return the next entry determined by the iterator if one exists.
     *
     * @return the next entry.
     */
    @Override
    public Object next() {
        T arrayEntry = list[position];
        position = position + 1;
        return arrayEntry;
    }

    /**
     * Determines if the iterator has more entries to process.
     *
     * @return true if there are more entries, false otherwise.
     */
    @Override
    public boolean hasNext() {
        return !(position >= list.length || list[position] == null);
    }

    /**
     * Removes the entry at the current position. note: May want to implement a
     * return T functionality.
     */
    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException(
                    "You can't remove an item until "
                    + "you've done at least one next()");
        }
        if (list[position - 1] != null) {
            for (int i = position - 1; i < (list.length - 1); i++) {
                list[i] = list[i + 1];
            }
            list[list.length - 1] = null;
        }
    }
}
