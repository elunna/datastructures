
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
    } // end constructor

    Node(T dataPortion, Node<T> nextNode) {
        data = dataPortion;
        next = nextNode;
    } // end constructor

    T getData() {
        return data;
    } 

    void setData(T newData) {
        data = newData;
    }

    Node<T> getNextNode() {
        return next;
    }

    void setNextNode(Node<T> nextNode) {
        next = nextNode;
    }
}
