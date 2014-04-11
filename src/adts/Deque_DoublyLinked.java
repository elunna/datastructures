package adts;

import java.util.Arrays;
import java.util.Objects;

/**
 * File: Description: Doubly linked chain. The first and last nodes contain one
 * null reference, First node has no previous node and last node has no node
 * following it.
 *
 * @author lunatunez
 * @param <T>
 */
public class Deque_DoublyLinked<T> implements DequeInterface<T> {

    private NodeDL<T> frontNode;
    private NodeDL<T> backNode;

    /**
     *
     */
    public Deque_DoublyLinked() {
        this.frontNode = null;
        this.backNode = null;
    }

    // *************************************************************************
    // *** STATIC METHODS ******************************************************
    @Override
    public int size() {
        NodeDL currentNode = frontNode;

        if (isEmpty()) {                    // Empty chain
            return 0;

        } else if (frontNode == backNode) { // Single Node
            return 1;

        } else {                            // Multiple Nodes
            int length = 2;
            while (currentNode.getNext() != backNode) {
                currentNode = currentNode.getNext();
                length++;
            }
            return length;
        }
    }

    @Override
    public boolean isEmpty() {
        return frontNode == null;
    }

    @Override
    public T getFront() {
        T front = null;
        if (!isEmpty()) {
            front = frontNode.getData();
        }
        return front;
    }

    @Override
    public T getBack() {
        T back = null;
        if (!isEmpty()) {
            back = backNode.getData();
        }
        return back;

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
        T[] result = (T[]) new Object[size()]; // unchecked cast
        int index = size()- 1;

        NodeDL currentNode = backNode.getNext();
        while ((index < size()) && (currentNode != null)) {
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
        if (!(aThat instanceof Deque_DoublyLinked)) {
            return false;
        }
        Deque_DoublyLinked that = (Deque_DoublyLinked) aThat;
        return Arrays.equals(this.toArray(), that.toArray()); //array!
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.frontNode);
        hash = 97 * hash + Objects.hashCode(this.backNode);
        return hash;
    }


    
    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
    @Override
    public boolean addToFront(T newEntry) {
        if (newEntry == null) {
            return false;
        }

        NodeDL<T> newNode;
        newNode = new NodeDL(null, newEntry, frontNode);
        if (isEmpty()) {
            backNode = newNode;
        } else {
            frontNode.setPrev(newNode);
        }
        frontNode = newNode;
        return true;
    }

    @Override
    public boolean addToBack(T newEntry) {
        if (newEntry == null) {
            return false;
        }
        NodeDL<T> newNode = new NodeDL(backNode, newEntry, null);
        if (isEmpty()) {
            frontNode = newNode;
        } else {
            backNode.setNext(newNode);
        }
        backNode = newNode;
        return true;
    }

    @Override
    public T removeFront() {
        T front = null;
        
        if (!isEmpty()) {
            front = frontNode.getData();
            frontNode = frontNode.getNext();
            if (frontNode == null) {
                backNode = null;
            } else {
                frontNode.setPrev(null);
            }
        }
        return front;
    }

    @Override
    public T removeBack() {
        T back = null;
        if (!isEmpty()) {
            back = backNode.getData();
            backNode = backNode.getPrev();
            if (backNode == null) {
                frontNode = null;
            } else {
                backNode.setNext(null);
            }
        }
        return back;
    }

    @Override
    public void clear() {
        while (!isEmpty()){
            removeFront();
        }
    }
}
