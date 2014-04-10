package adts;

/**
 * File: A circular linked chain queue. Contains only one external reference to
 * the chain; lastNode lastNode contains a reference to the first Node. If
 * lastNode.getNext = null, the bag is empty. If lastNode.getNext = lastNode,the
 * bag is size 1.
 *
 * @author lunatunez
 */
class Queue_CircularLinked<T> implements QueueInterface {

    private Node<T> backNode;
    private int numberOfNodes;

    public Queue_CircularLinked() {
        backNode = new Node(null, null);
    }

    // *************************************************************************
//     *** STATIC METHODS ******************************************************
    @Override
    public int size() {
        Node curentNode = backNode.getNext();

        if (backNode.getNext() == null) {               // Empty chain
            return 0;

        } else if (backNode.getNext() == backNode) {    // Single Node
            return 1;

        } else {                                        // Multiple Nodes
            int length = 2;
            Node node = backNode.getNext();

            while (node.getNext() != backNode) {
                node = node.getNext();
                length++;
            }
            return length;
        }
    }

    @Override
    public boolean isFull() {
        return false; // Linked Queue is never full.
    }

    @Override
    public T getFront() {
        T front = null;
        if (!isEmpty()) {
            front = backNode.getNext().getData();
        }
        return front;
    }

//    @Override
//    public boolean isEmpty() {
//        return backNode.getData() == null;
//    }

    /*
     * Sees whether this bag is empty.
     */
    @Override
    public boolean isEmpty() {
        boolean result;
        if (size() == 0) {
            assert backNode.getNext() == null;
            result = true;
        } else {
            assert backNode.getNext() != null : "backNode.getNext() isn't null, but the size is 0.";
            result = false;
        }
        return result;
    }

    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
    @Override
    public boolean enqueue(Object newEntry) {
        if (newEntry == null) {
            return false;
        } else if (isEmpty()) { // chain is empty
            backNode.setData((T) newEntry);
            backNode.setNext(backNode);
        } else {
            // Create a new Node, that references the front.
            Node newNode = new Node(newEntry, backNode.getNext());
            // Set the lastNode's reference to the newNode.
            backNode.setNext(newNode);
            // Reset lastNode to the newNode.
            backNode = newNode;
        }
        return true;
    }

    /**
     * Removes the front entry from the queue and returns it.
     *
     * @return
     */
    @Override
    public T dequeue() {
        T front = null;
        if (isEmpty()) {                    // Empty chain
            return null;
        }

        Node frontNode = backNode.getNext();
        if (frontNode == backNode) {        // Only 1 Node left
            backNode.setData(null);
            backNode.setNext(null);

        } else {                            // Multiple Nodes left
            front = (T) frontNode.getData();

            Node nextInLine = frontNode.getNext();
            backNode.setNext(nextInLine);
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
