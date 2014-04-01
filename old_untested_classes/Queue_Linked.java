package adts;

public class Queue_Linked<T> implements QueueInterface< T> {
    // references node at front of queue
    private Node firstNode;
    // references node at back of queue
    private Node lastNode;

    public Queue_Linked() {
        firstNode = null;
        lastNode = null;
    } // end default constructor

    @Override
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.next = newNode;
        }
        lastNode = newNode;
    }

    @Override
    public T dequeue() {
        T front = null;
        if (!isEmpty()) {
            front = firstNode.data;
            firstNode = firstNode.next;
            if (firstNode == null) {
                lastNode = null;
            }
        } 
        return front;
    }

    @Override
    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    }

    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
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
    public int getLength() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class Node {
        private T data;     // entry in queue
        private Node next;  // link to next node

        private Node(T dataPortion) {
            this(dataPortion, null);
        }

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }
   }
}