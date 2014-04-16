package adts;

import java.util.Iterator;

/**
 * File: Description:
 *
 * @author lunatunez
 * @param <T>
 */
class DLChainIterator<T> implements Iterator {

    private NodeDL<T> currentNode;

    /**
     *
     * @param firstNode
     */
    public DLChainIterator(NodeDL<T> firstNode) {
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
        NodeDL result = currentNode;
        currentNode = currentNode.getNext();
        return result;
        
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
