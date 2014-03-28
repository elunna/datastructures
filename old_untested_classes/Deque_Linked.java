package adts;

/**
 * A class that implements a deque of objects by using a chain of doubly linked
 * nodes.
 *
 * @param <T>
 */
public class Deque_Linked<T> implements DequeInterface<T> {

    private DLNode firstNode; // references node for front of deque
    private DLNode lastNode; // references node for back of deque

    public Deque_Linked() {
        firstNode = null;
        lastNode = null;
    } // end default constructor

    
    @Override
    public void addToBack(T newEntry) { 
	DLNode newNode = new DLNode(lastNode, newEntry, null); 
	if (isEmpty()) {
		firstNode = newNode; 
        }
	else {
		lastNode.setNextNode(newNode);
        }
	lastNode = newNode; 
} // end addToBack
    
    @Override
    public void addToFront(T newEntry)
    {
    DLNode newNode = new DLNode(null, newEntry, firstNode);
    if (isEmpty())
        lastNode = newNode;
    else {
        firstNode.setPreviousNode(newNode);
    }
    firstNode = newNode;
    
    }

    @Override
    public T removeFront() {
        T front = null;
        if (!isEmpty()) {
            front = firstNode.getData();
            firstNode = firstNode.getNextNode();
            if (firstNode == null) {
                lastNode = null;
            }
        }
        return front;
    }

    @Override
    public T removeBack() {
        T back = null;
        if (!isEmpty()) {
            back = lastNode.getData();
            lastNode = lastNode.getPreviousNode();
            if (lastNode == null) {
                firstNode = null;
            } else {
                lastNode.setNextNode(null);
            }
        }
        return back;
    }

    
    @Override
    public T getFront() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T getBack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
    private class DLNode {
        private T data; // deque entry
        private DLNode next; // link to next node
        private DLNode previous; // link to previous node

        public DLNode(DLNode previous, T data, DLNode next) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

        /**
         * @return the data
         */
        public T getData() {
            return data;
        }

        /**
         * @param data the data to set
         */
        public void setData(T data) {
            this.data = data;
        }

        /**
         * @return the next DLNode
         */
        public DLNode getNextNode() {
            return next;
        }

        /**
         * @param next the next to set
         */
        public void setNextNode(DLNode next) {
            this.next = next;
        }

        /**
         * @return the previous DLNode
         */
        public DLNode getPreviousNode() {
            return previous;
        }

        /**
         * @param previous the previous DLNode to set
         */
        public void setPreviousNode(DLNode previous) {
            this.previous = previous;
        }
    }
}
