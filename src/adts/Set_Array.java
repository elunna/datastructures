package adts;

import adts.SetInterface;

/**
 * File: Description:
 *
 * @author lunatunez
 */
class Set_Array<T> implements SetInterface<T> {

    private final T[] array;
    private int numberOfEntries;

    public Set_Array() {
        this(DEFAULT_CAPACITY);
    }

    public Set_Array(int capacity) throws IllegalArgumentException {
        numberOfEntries = 0;
        if (capacity <= 0) {
            throw new IllegalArgumentException("Bad constructor arg");
        }
        @SuppressWarnings("unchecked")
        T[] tempSet = (T[]) new Object[capacity]; // unchecked cast
        array = tempSet;
    }

}
