package adts;

/**
 * @author Erik Lunna<eslunna@gmail.com>
 * Date: 10/22/13 Purpose:
 * @param <T>
 */
public class Stack_Linked<T> implements StackInterface<T> {
    public Node topNode;
    
    Stack_Linked() {
        topNode = null;
    }

    @Override
    public void push(T newEntry) {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
    }

    @Override
    public T pop() {
        T top = peek();
        if (topNode != null) {
            topNode = topNode.next;
        }
        return top;
    }

    @Override
    public T peek() {
        T top = null;
        if (topNode != null) {
            top = topNode.data;
        }
        return top;
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void clear() {
        topNode = null;
    }

    private class Node {
        private T data;     // reference to entry in bag
        private Node next;  // reference to next node

        private Node(T dataPortion) {
            this(dataPortion, null);
        }

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }
    }
}
