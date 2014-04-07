package adts;

/**
 * @author Erik Lunna<eslunna@gmail.com>
 * Date: 10/22/13 Purpose:
 * @param <T>
 */
public class Stack_Linked<T> implements StackInterface<T> {

    private Node topNode;
    private int size;

    public Stack_Linked() {
        topNode = null;
    }

    @Override
    public boolean push(T newEntry) {
        if (newEntry != null) {
            Node newNode = new Node( (T)newEntry, topNode);
            topNode = newNode;
            size++;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public T pop() {
        T top = peek();
        if (topNode != null) {
            topNode = topNode.getNext();
        }
        size--;
        return top;
    }

    @Override
    public T peek() {
        T top = null;
        if (topNode != null) {
            top = (T) topNode.getData();
        }
        return top;
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            pop();
        }
        topNode = null;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public T peek2() {
        if (size < 2) {
            return null;
        }
        else {
            return (T) topNode.getNext().getData();
        }
    }

}
