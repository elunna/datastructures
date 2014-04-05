package adts;

/**
 * File:
 * <p>
 * Description:
 *
 * @author lunatunez
 */
public class Queue_2PartCircular<T> implements QueueInterface<T> {

    private Node queueNode;
    private Node freeNode;

    public Queue_2PartCircular() {
        freeNode = new Node(null, null);
        freeNode.setNext(freeNode);
        queueNode = freeNode;
    }

    @Override
    public void enqueue(T newEntry) {
        if (newEntry != null) {
            freeNode.setData(newEntry);
            if (isChainFull()) {
                Node newNode = new Node(null, freeNode.getNext());
                freeNode.setNext(newNode);
            }
            freeNode = freeNode.getNext();
        }
    }

    @Override
    public T dequeue() {
        T front = null;
        if (!isEmpty()) {
            front = (T) queueNode.getData();
            queueNode.setData(null);
            queueNode = queueNode.getNext();
        }
        return front;
    }

    @Override
    public T getFront() {
        T front = null;
        if (!isEmpty()) {
            front = (T) queueNode.getData();
        }
        return front;

    }

    @Override
    public boolean isEmpty() {
        return queueNode == freeNode;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    @Override
    public int getLength() {
        int count = 0;
        if (isEmpty()) {
            return count;
        } else {
            count++;
            Node scanner = queueNode;
            while (scanner.getNext() != freeNode) {
                count++;
                scanner = scanner.getNext();
            }
            return count;

        }
    }

    private boolean isChainFull() {
        return queueNode == freeNode.getNext();

    }
}
