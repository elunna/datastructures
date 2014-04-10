package adts;

/**
 * File: Queue_Linked.
 * Description: This is a linked chain implementation using
 * nodes. The chain can grow to any size.
 *
 * @author lunatunez
 * @param <T>
 */
public class Queue_Linked<T> implements QueueInterface<T> {

    private Node<T> frontNode;
    private Node<T> backNode;

    // *************************************************************************
    // *** STATIC METHODS ******************************************************
    @Override
    public int size() {
        int length = 0;
        Node node = frontNode;
        if (node == null) {
            return length;
        } else {
            length++;
        }

        while (node.getNext() != null) {
            length++;
            node = node.getNext();
        }
        return length;
    }

//    @Override
//    public boolean isEmpty() {
//        return frontNode == null && backNode == null;
//    }
    /*
     * Sees whether this bag is empty.
     */
    @Override
    public boolean isEmpty() {
        boolean result;
        if (size() == 0) {
            assert frontNode == null && backNode == null;
            result = true;
        } else {
            assert frontNode != null : "numberOfEntries is not 0 but frontNode is null";
            assert backNode != null : "numberOfEntries is not 0 but backNode is null";
            result = false;
        }
        return result;
    }

    @Override
    public boolean isFull() {
        return false; // Linked Queue is never full.
    }

    @Override
    public T getFront() {
        T front = null;
        if (!isEmpty()) {
            front = frontNode.getData();
        }
        return front;
    }

    // *************************************************************************
    // *** MUTATOR METHODS ******************************************************
    @Override
    public boolean enqueue(Object newEntry) {
        if (newEntry == null) {
            return false;
        }
        Node newNode = new Node(newEntry, null);

        if (isEmpty()) {
            frontNode = newNode;
        } else {
            backNode.setNext(newNode);
        }
        backNode = newNode;
        return true;
    }

    @Override
    public T dequeue() {
        T front = null;
        if (!isEmpty()) {
            front = frontNode.getData();
            frontNode = frontNode.getNext();
            if (frontNode == null) {
                backNode = null;
            }
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
