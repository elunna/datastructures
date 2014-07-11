package adts;

/**
 *
 * @author lunatunez
 * @param <T>
 */
public class SortedList_Linked<T extends Comparable<? super T>>
        extends LinkedChainBase<T>
        implements SortedListInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    public SortedList_Linked() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        Node nodeBefore = getNodeBefore(newEntry);
        if (isEmpty() || (nodeBefore == null)) // add to beginning
        {
            newNode.setNext(firstNode);
            firstNode = newNode;
        } else {
            Node nodeAfter = nodeBefore.getNext();
            newNode.setNext(nodeAfter);
            nodeBefore.setNext(newNode);
        }
        numberOfEntries++;
        return true;
    }

    @Override
    public boolean remove(T anEntry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPosition(T anEntry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(T anEntry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Finds the node that is before the node that should or does contain a
     * given entry.
     *
     * @param anEntry the object to be located
     * @return either a reference to the node that is before the node that
     * contains or should contain anEntry, or null if no prior node exists (that
     * is, if anEntry belongs at the beginning of the list)
     */
    private Node getNodeBefore(T anEntry) {
        Node currentNode = firstNode;
        Node nodeBefore = null;
        while (currentNode != null
                && anEntry.compareTo(currentNode.getData()) > 0) {
            nodeBefore = currentNode;
            currentNode = currentNode.getNext();
        }
        return nodeBefore;
    }

    @Override
    public boolean insert(int index, T newEntry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean replace(int index, T newEntry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
