package adts;

import java.util.Arrays;
import java.util.Objects;

/**
 * File:
 *
 * Description:
 *
 * @author lunatunez
 * @param <T>
 */
public class Queue_2PartCircular<T> implements QueueInterface<T> {

    private Node queueNode;     // Also represents the front
    private Node freeNode;      // The Node before freeNode is the back.
    private int numberOfNodes;

    public Queue_2PartCircular() {
        freeNode = new Node(null, null);
        freeNode.setNext(freeNode);
        queueNode = freeNode;
    }

    // *************************************************************************
    // *** STATIC METHODS ******************************************************
    @Override
    public int size() {
        return numberOfNodes;

    }

    /**
     * Sees whether this bag is empty.
     *
     * @return
     */
//    @Override
//    public boolean isEmpty() {
//        return queueNode == freeNode;
//    }
    @Override
    public boolean isEmpty() {
        boolean result;
        if (size() == 0) {
            assert queueNode == freeNode;
            result = true;
        } else {
            // extra precaution?
            assert queueNode != freeNode : "size() is not 0 but frontNode doesn't equals queueNode";
            result = false;
        }
        return result;
    }

    @Override
    public T getFront() {
        T front = null;
        if (!isEmpty()) {
            front = (T) queueNode.getData();
        }
        return front;
    }

    @Override
    public boolean isFull() {
        return false; // Linked Queue is never full.
    }

    private boolean isChainFull() {
        return queueNode == freeNode.getNext();
    }

    /**
     * Retrieves all entries that are in this queue.
     *
     * @return
     */
    @Override
    public T[] toArray() {
        // the cast is safe because the new array contains null entries
        @SuppressWarnings(value = "unchecked")
        T[] result = (T[]) new Object[numberOfNodes]; // unchecked cast
        int index;
        if (isEmpty()) {
            return result;
        }
        index = numberOfNodes - 1;

        Node currentNode = queueNode;
        while (index < numberOfNodes
                && currentNode.getNext() != freeNode) {
            result[index] = (T) currentNode.getData();
            index--;
            currentNode = currentNode.getNext();
        }
        return result;
    }

    @Override
    public boolean equals(Object aThat) {
        if (this == aThat) {
            return true;
        }
        if (!(aThat instanceof Queue_2PartCircular)) {
            return false;
        }
        Queue_2PartCircular that = (Queue_2PartCircular) aThat;
        return Arrays.equals(this.toArray(), that.toArray()); //array!
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.queueNode);
        hash = 41 * hash + Objects.hashCode(this.freeNode);
        hash = 41 * hash + this.numberOfNodes;
        return hash;
    }

    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
    @Override
    public boolean enqueue(T newEntry) {
        boolean success = false;
        if (newEntry != null) {

            freeNode.setData(newEntry);

            if (isChainFull()) {
                // Allocate a new node
                Node newNode = new Node(null, freeNode.getNext());
                freeNode.setNext(newNode);
            }
            // Add newEntry to the back
            freeNode = freeNode.getNext();
            numberOfNodes++;
            success = true;
        }
        return success;

    }

    @Override
    public T dequeue() {
        T front = null;
        if (!isEmpty()) {
            front = (T) queueNode.getData();
            queueNode.setData(null);
            queueNode = queueNode.getNext();
            numberOfNodes--;
        }
        return front;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }

}
