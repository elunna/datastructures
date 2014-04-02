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

    @Override
    public void enqueue(Object newEntry) {
        vector.addElement((T) newEntry);
        
    }

    @Override
    public Object dequeue() {
        T front = vector.get(0);
        vector.removeElementAt(0);
        return front;
    }

    @Override
    public Object getFront() {
        T front = null;
        if (vector.size() > 0) {
            vector.removeElementAt(0);
        }
        return front;
    }

    @Override
    public boolean isEmpty() {
        return vector.isEmpty();
    }

    @Override
    public void clear() {
        vector.removeAllElements();
        // or
        // vector.clear();     
    }

    @Override
    public int getLength() {
        return vector.size();
    }
}
