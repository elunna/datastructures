package adts;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Vector;

/**
 * File: Description:
 *
 * @author lunatunez
 */
@SuppressWarnings("UseOfObsoleteCollectionType")
class Queue_Vector<T> implements QueueInterface<T> {

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

    @Override
    public T[] toArray() {
        return (T[]) vector.toArray();
    }

    @Override
    public boolean equals(Object aThat) {
        if (this == aThat) {
            return true;
        }
        if (!(aThat instanceof Queue_Vector)) {
            return false;
        }
        Queue_Vector that = (Queue_Vector) aThat;
        return Arrays.equals(this.toArray(), that.toArray()); //array!
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.vector);
        return hash;
    }

    // Displays all the elements of bag line by line.
    @Override
    public void display() {
        displayArray(0, vector.size() - 1);
    }

    /**
     * Does the work of recursively displaying the individual elements
     *
     * @param first
     * @param last
     */
    private void displayArray(int first, int last) {
        System.out.println(vector.get(first));
        if (first < last) {
            displayArray(first + 1, last);
        }
    }

    @Override
    public Iterator getIterator() {
        return vector.iterator();

    }
    // *************************************************************************
    // *** MUTATOR METHODS ******************************************************
    @Override
    public boolean enqueue(Object newEntry) {
        if (newEntry != null) {
            vector.addElement((T) newEntry);
            return true;
        }
        return false;
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

    @Override
    public boolean isFull() {
        return false; // Linked Queue is never full.

    }
}
