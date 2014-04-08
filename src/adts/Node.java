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

    // *************************************************************************
    // *** STATIC METHODS ******************************************************
    T getData() {
        return data;
    }

    Node<T> getNext() {
        return next;
    }

    // *************************************************************************
    // *** MUTATOR METHODS ******************************************************
    void setData(T newData) {
        data = newData;
    }

    void setNext(Node<T> nextNode) {
        next = nextNode;
    }
}
