package datastructures;

/**
 * Represents a single Node which contains two references, one to the next Node
 * and one to the data this Node represents. Designated for use in a chain of
 * linked Nodes
 *
 * @author Erik Lunna
 */
class Node<T> {

    private T data;
    private Node<T> next;

    /**
     * This constructor takes a data value T and creates a new Node with a null
     * nextNode. Note: the constructor’s name is Node, not Node<T>.
     *
     * @param dataPortion
     */
    Node(T dataPortion) {
        this(dataPortion, null);
    }

    /**
     * This constructor takes a data value T and creates a new Node that
     * references the next Node in the chain.
     *
     * @param data
     * @param next
     */
    Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Access the data contained in this Node.
     *
     * @return the data T.
     */
    T getData() {
        return this.data;
    }

    /**
     * Access the next Node in the chain.
     *
     * @return the next Node.
     */
    Node<T> getNext() {
        return this.next;
    }

    /**
     * Sets the data in this Node.
     *
     * @param newData to set.
     */
    void setData(T newData) {
        this.data = newData;
    }

    /**
     * Sets the next Node this references.
     *
     * @param nextNode to reference.
     */
    void setNext(Node<T> nextNode) {
        this.next = nextNode;
    }
}
