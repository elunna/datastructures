package datastructures;

import java.util.Iterator;

/**
 * Describes the operations for an Iterator that will process a Linked Chain of
 * Nodes.
 *
 * @author lunatunez
 * @param <T>
 */
class ChainIterator<T> implements Iterator {

    private Node<T> currentNode;

    /**
     * This is the regular ChainIterator constructor that takes the first Node
     * in a chain of Nodes to process.
     *
     * @param firstNode
     */
    public ChainIterator(Node<T> firstNode) {
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
        Node result = currentNode;
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
