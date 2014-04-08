package adts;

/**
 * File: A circular linked chain queue. Contains only one external reference to
 * the chain; lastNode lastNode contains a reference to the first Node. If
 * lastNode.getNext = null, the bag is empty. If lastNode.getNext = lastNode,
 * the bag is size 1.
 *
 * @author lunatunez
 */
class Queue_CircularLinked<T> implements QueueInterface {

    private Node<T> lastNode;

    public Queue_CircularLinked() {
        lastNode = new Node(null, null);
    }

    // *************************************************************************
    // *** STATIC METHODS ******************************************************
    @Override
    public int size() {
        if (lastNode.getNext() == null) {
            return 0;
        } else if (lastNode.getNext() == lastNode) {
            return 1;
        } else {
            int length = 2;
            Node node = lastNode.getNext();

            while (node.getNext() != lastNode) {
                node = node.getNext();
                length++;
            }
            return length;
        }
    }

    @Override
    public T getFront() {
        T front = null;
        if (!isEmpty()) {
            front = lastNode.getNext().getData();
        }
        return front;
    }

    @Override
    public boolean isEmpty() {

        return lastNode.getData() == null;
    }

    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
    @Override
    public void enqueue(Object newEntry) {
        if (newEntry == null) {
        } else if (lastNode.getNext() == null) { // chain is empty
            lastNode.setData((T) newEntry);
            lastNode.setNext(lastNode);
        } else {
            // Create a new Node, that references the front.
            Node newNode = new Node(newEntry, lastNode.getNext());
            // Set the lastNode's reference to the newNode.
            lastNode.setNext(newNode);
            // Reset lastNode to the newNode.
            lastNode = newNode;
        }
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
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }
}
