package adts;

/**
 * File:        Queue_Linked
 * Description: This is a linked chain implementation using nodes.
 * The chain can grow to any size.
 *
 * @author lunatunez
 * @param <T>
 */
public class Queue_Linked<T> implements QueueInterface<T> {

    Node<T> firstNode;
    Node<T> lastNode;

    @Override
    public void enqueue(Object newEntry) {
        if (newEntry == null) {
            return;
        }
        Node newNode = new Node(newEntry, null);

        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.setNext(newNode);
        }
        lastNode = newNode;
    }

    @Override
    public T dequeue() {
        T front = null;
        if (!isEmpty()) {
            front = firstNode.getData();
            firstNode = firstNode.getNext();
            if (firstNode == null) {
                lastNode = null;
            }
        }
        return front;
    }


    @Override
    public boolean isEmpty() {

        return firstNode == null
                && lastNode == null;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
     }

    @Override
    public int getLength() {
        int length = 0;
        Node node = firstNode;
        if (node == null) {
            return length;
        }
        else length++;
        
        while (node.getNext() != null) {
            length++;
            node = node.getNext();
        }
        return length;
    
    }

    @Override
    public T getFront() {
        T front = null;
        if (!isEmpty()) {
            front = firstNode.getData();
        }
        return front;
    }
}