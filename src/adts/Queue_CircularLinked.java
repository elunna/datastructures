package adts;

/**
 * File: A circular linked chain queue. Contains only one external reference to
 * the chain; lastNode lastNode contains a reference to the first Node. If
 * lastNode.getNext = null, the bag is empty. If lastNode.getNext = lastNode,
 * the bag is size 1.
 *
 * Description:
 *
 * @author lunatunez
 */
class Queue_CircularLinked<T> implements QueueInterface {

    private Node<T> lastNode;

    public Queue_CircularLinked() {
        lastNode.setData(null);
        lastNode.setNext(null);
    }

    @Override
    public void enqueue(Object newEntry) {
        if (newEntry == null) {
            return;
        }
        
        Node newNode = new Node(newEntry, lastNode.getNext() );
        
        lastNode.setNext(newNode);
        
    }

    @Override
    public T dequeue() {
        T front = null;

        if (!isEmpty()) {
            front = lastNode.getNext().getData();

            Node nextInLine = lastNode.getNext().getNext();
            lastNode.setNext(nextInLine);
        }
        return front;
    }

    @Override
    public boolean isEmpty() {

        return lastNode.getNext() == null;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    @Override
    public int getLength() {
        if (lastNode.getNext() == null) {
            return 0;
        } else if (lastNode.getNext() == lastNode) {
            return 1;
        }
        int length = 2; // Length must be at least 2.
        Node node = lastNode.getNext();

        while (node.getNext() != lastNode) {
            node = node.getNext();
            length++;
        }
        return length;

    }

    @Override
    public T getFront() {
        T front = null;
        if (!isEmpty()) {
            front = lastNode.getNext().getData();
        }
        return front;
    }

}
