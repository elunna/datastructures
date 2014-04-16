package adts;

import java.util.Iterator;

/**
 * File: Description:
 *
 * @author lunatunez
 * @param <T>
 */
public class ArrayIterator<T> implements Iterator {

    T[] list;
    int position = 0;

    public ArrayIterator(T[] list) {
        this.list = list;
    }

    @Override
    public Object next() {
        T arrayEntry = list[position];
        position = position + 1;
        return arrayEntry;
    }

    @Override
    public boolean hasNext() {
        if (position >= list.length || list[position] == null) {
            return false;
        } else {
            return true;
        }
    }

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
