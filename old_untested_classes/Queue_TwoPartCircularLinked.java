package adts;

/**
 * outline 2-part circular linked implementation of the ADT queue
 *
 * @author Erik Lunna A class that implements a queue of objects by using a
 * two-part circular chain of linked nodes
 * @author Frank M. Carrano
 */
public class Queue_TwoPartCircularLinked<T> implements QueueInterface<T> {
    // references first node in queue 
    private Node firstNode;
    
    // references node after back of queue 
    private Node freeNode;

    public Queue_TwoPartCircularLinked() {
        freeNode = new Node(null, null);
        freeNode.next = freeNode;
        firstNode = freeNode;
    }

    @Override
    public void enqueue(T newEntry) {
        freeNode.data = newEntry;
        if (isChainFull()) {
            // allocate a new node 
            // insert it after the node that freeNode references
            Node newNode = new Node(null, freeNode.next);
            freeNode.next = newNode;
        }
        freeNode = freeNode.next;
    }

    @Override
    public T getFront() {
        T front = null;
        if (!isEmpty()) {
            front = firstNode.data;
        }
        return front;
    }

    @Override
    public T dequeue() {
        T front = null;
        if (!isEmpty()) {
            front = firstNode.data;
            firstNode.data = null;
            firstNode = firstNode.next;
        }
        return front;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == freeNode;
    }

    private boolean isChainFull() {
        return firstNode == freeNode.next;
    } 

    @Override
    public void clear() {
        firstNode = freeNode; // ??
        // unless you set the data portions of these nodes
        // to null, the objects in the queue are not deallocated.
    
    }

    @Override
    public int getLength() {
        return -1;
    }
    
    private class Node {
        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        private T data; // queue entry 
        private Node next; // link to next node 
    }
}