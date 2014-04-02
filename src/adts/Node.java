package adts;

/**
 *
 * @author Erik Lunna
 */
class Node<T> {
    private T data;
    private Node<T> next;
    
    // the constructor’s name is Node, not Node<T>
    Node(T dataPortion) {
        this(dataPortion, null);
    }

    Node(T dataPortion, Node<T> nextNode) {
        data = dataPortion;
        next = nextNode;
    }

    T getData() {
        return data;
    } 

    void setData(T newData) {
        data = newData;
    }

    Node<T> getNext() {
        return next;
    }

    void setNext(Node<T> nextNode) {
        next = nextNode;
    }
}
