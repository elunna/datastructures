package datastructures;

/**
 *
 * Represents a single Node which contains three references, one to the next
 * Node, one to the previous, and one to the data this Node represents.
 * Designated for use in a chain of linked Nodes
 *
 * @author Erik Lunna
 * @param <T>
 */
class NodeDL<T> {

    private NodeDL<T> prev;
    private T data;
    private NodeDL<T> next;

    /**
     * Constructor that creates a new NodeDL with data, but does not reference
     * any other NodeDLs yet.
     *
     * @param data to set.
     */
    NodeDL(T dataPortion) {
        this(null, dataPortion, null);
    }

    /**
     * Constructor that creates a new NodeDL with references to data, a previous
     * Node, and the next NodeDL in the Chain
     *
     * @param previousNode
     * @param dataPortion
     * @param nextNode
     */
    NodeDL(NodeDL<T> previousNode, T dataPortion, NodeDL<T> nextNode) {
        this.prev = previousNode;
        this.data = dataPortion;
        this.next = nextNode;
    }

    /**
     * Access the data contained in this NodeDL.
     *
     * @return the data T.
     */
    T getData() {
        return data;
    }

    /**
     * Access the next NodeDL in the chain.
     *
     * @return the next Node.
     */
    NodeDL<T> getNext() {
        return next;
    }

    /**
     * Access the previous NodeDL in the chain.
     *
     * @return the previous Node.
     */
    NodeDL<T> getPrev() {
        return prev;
    }

    /**
     * Sets the data in this NodeDL.
     *
     * @param newData to set.
     */
    void setData(T newData) {
        data = newData;
    }

    /**
     * Sets the next NodeDL this references.
     *
     * @param nextNode to reference.
     */
    void setNext(NodeDL<T> nextNode) {
        next = nextNode;
    }

    /**
     * Sets the previous NodeDL this references.
     *
     * @param nextNode to reference.
     */
    void setPrev(NodeDL<T> prevNode) {
        prev = prevNode;
    }

}
