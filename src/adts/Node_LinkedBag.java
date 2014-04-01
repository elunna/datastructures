package adts;

/**
 *
 * @author Erik Lunna
 */
class Node_LinkedBag<T> {
    private T data;
    private Node_LinkedBag<T> next;
    
    // the constructor’s name is Node_LinkedBag, not Node_LinkedBag<T>
    Node_LinkedBag(T dataPortion) {
        this(dataPortion, null);
    }

    Node_LinkedBag(T dataPortion, Node_LinkedBag<T> nextNode) {
        data = dataPortion;
        next = nextNode;
    }

    T getData() {
        return data;
    } 

    void setData(T newData) {
        data = newData;
    }

    Node_LinkedBag<T> getNext() {
        return next;
    }

    void setNext(Node_LinkedBag<T> nextNode) {
        next = nextNode;
    }
}
