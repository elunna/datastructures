package adts;

import java.util.Iterator;

/**
 * File: Description:
 *
 * @author lunatunez
 * @param <T>
 */
class ChainIterator<T> implements Iterator {

    private Node<T> currentNode;

    /**
     *
     * @param firstNode
     */
    public ChainIterator(Node<T> firstNode) {
        this.currentNode = firstNode;
    }

    @Override
    public boolean hasNext() {
        if (currentNode.getNext() == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        Node result = currentNode;
        currentNode = currentNode.getNext();
        return result;
        
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
