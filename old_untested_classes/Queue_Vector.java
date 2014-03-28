package adts;

import java.util.Vector;

/**
 * An outline of a vector-based implementation of the ADT queue import
 * java.util.Vector; A class that implements a queue of objects by using a
 * vector.
 */
public class Queue_Vector<T> implements QueueInterface<T> {

    private Vector<T> queue;
	// queue’s front entry is first in the vector 

    public Queue_Vector() {
        // vector doubles in size if necessary 
        queue = new Vector<>();
    } // end default constructor 

    public Queue_Vector(int initialCapacity) {
        queue = new Vector<>(initialCapacity);
    } // end constructor 

    @Override
    public void enqueue(T newEntry) {
        queue.add(newEntry);
    }

    @Override
    public T getFront() {
        T front = null;
        if (!isEmpty()) {
            front = queue.get(0);
        }
        return front;
    }

    @Override
    public T dequeue() {
        T front = null;
        if (!isEmpty()) {
            front = queue.remove(0);
        }
        return front;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public int getLength() {
        return queue.size();
    }
}
