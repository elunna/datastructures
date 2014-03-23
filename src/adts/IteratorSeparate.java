package adts;

// LISTING 15-2 An outline of the class SeparateIterator
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorSeparate<T> implements Iterator<T> {

    private ListInterface<T> list;
    private int nextPosition; // position of entry last returned by next()
    private boolean wasNextCalled; // needed by remove

    public IteratorSeparate(ListInterface<T> aList) {
        list = aList;
        nextPosition = 0;
        wasNextCalled = false;
    } // end constructor

    @Override
    public boolean hasNext() {
        return nextPosition < list.getLength();
    }

    @Override
    public T next() {
        if (hasNext()) {
            wasNextCalled = true;
            nextPosition++;
            return list.getEntry(nextPosition);
        } else {
            throw new NoSuchElementException("Illegal call to next(); "
                    + "iterator is after end of list.");
        }
    } // end next

    @Override
    public void remove() {
        if (wasNextCalled) {
            // nextPosition was incremented by the call to next(), so
            // it is the position number of the entry to be removed
            list.remove(nextPosition);
            nextPosition--; // a subsequent call to next() must be
            // unaffected by this removal
            wasNextCalled = false; // reset flag
        } else {
            throw new IllegalStateException("Illegal call to remove(); "
                    + "next() was not called.");
        }
    } 
}
