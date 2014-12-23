package datastructures;

import java.util.Iterator;

/**
 * Describes the operations for an Iterator that will process a Doubly Linked
 * Chain of Nodes.
 *
 * @author lunatunez
 * @param <T>
 */
class DLChainIterator<T> implements Iterator {

    private NodeDL<T> currentNode;

    /**
     * This is the regular DLChainIterator constructor that takes the first
     * NodeDL in a chain to process.
     *
     * @param firstNode
     */
    public DLChainIterator(NodeDL<T> firstNode) {
        this.currentNode = firstNode;
    }

    /**
     * Determines if the iterator has more entries to process.
     *
     * @return true if there are more entries, false otherwise.
     */
    @Override
    public boolean hasNext() {
        if (currentNode.getNext() == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Return the next entry determined by the iterator if one exists.
     *
     * @return the next entry.
     */
    @Override
    public Object next() {
        NodeDL result = currentNode;
        currentNode = currentNode.getNext();
        return result;

    }

    /**
     * Remove: Not supported in this iterator.
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
