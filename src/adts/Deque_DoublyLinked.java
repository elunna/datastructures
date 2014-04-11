package adts;

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
