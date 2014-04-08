package adts;

import java.util.Vector;

/**
 * File: Description:
 *
 * @author lunatunez
 */
@SuppressWarnings("UseOfObsoleteCollectionType")
class Queue_Vector<T> implements QueueInterface {

    Vector<T> vector;

    public Queue_Vector() {
        this.vector = new Vector<>();
    }
    // *************************************************************************
    // *** STATIC METHODS ******************************************************

    @Override
    public int size() {
        return vector.size();
    }

    @Override
    public boolean isEmpty() {
        return vector.isEmpty();
//        return vector.size() == 0;
    }

    @Override
    public T getFront() {
        T front = null;
        if (vector.size() > 0) {
            //vector.get(0);
            front = vector.firstElement();
        }
        return front;
    }

    // *************************************************************************
    // *** MUTATOR METHODS ******************************************************
    @Override
    public void enqueue(Object newEntry) {
        if (newEntry != null) {
            vector.addElement((T) newEntry);
        }
    }

    @Override
    public T dequeue() {

        T front = null;
        if (vector.size() > 0) {
            front = vector.firstElement();
            vector.removeElementAt(0);
        }
        return front;
    }

    @Override
    public void clear() {
        // vector.removeAllElements();
        vector.clear();
    }
}
