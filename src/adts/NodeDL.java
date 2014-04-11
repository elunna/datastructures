package adts;

/**
 * File: Description:
 *
 * @author lunatunez
 * @param <T>
 */
class NodeDL<T> {

    private NodeDL<T> prev;
    private T data;
    private NodeDL<T> next;

    /**
     *
     * @param data
     * @param prev
     * @param next
     */
    NodeDL(T dataPortion) {
        this(null, dataPortion, null);
    }

    NodeDL(NodeDL<T> previousNode, T dataPortion, NodeDL<T> nextNode) {
        this.prev = previousNode;
        this.data = dataPortion;
        this.next = nextNode;
    }

    // *************************************************************************
    // *** STATIC METHODS ******************************************************
    T getData() {
        return data;
    }

    /**
     *
     * @return
     */
    NodeDL<T> getNext() {
        return next;
    }

    /**
     *
     * @return
     */
    NodeDL<T> getPrev() {
        return prev;
    }

    // *************************************************************************
    // *** MUTATOR METHODS ******************************************************
    void setData(T newData) {
        data = newData;
    }

    /**
     *
     * @param nextNode
     */
    void setNext(NodeDL<T> nextNode) {
        next = nextNode;
    }

    /**
     *
     * @param prevNode
     */
    void setPrev(NodeDL<T> prevNode) {
        prev = prevNode;
    }

}
