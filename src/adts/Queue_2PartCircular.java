package adts;

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

    private boolean isChainFull() {
        return queueNode == freeNode.getNext();

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

    @Override
    public boolean isFull() {
        return false; // Linked Queue is never full.
    }
}
