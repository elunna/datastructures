package adts;

/**
 * File: Description:
 *
 * @author lunatunez
 * @param <T>
 */
public class Set_Linked<T extends Comparable<? super T>>
        implements SetInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    public Set_Linked() {
        this.firstNode = null;
        this.numberOfEntries = 0;
    }
    // *************************************************************************
    // *** STATIC METHODS ******************************************************

    @Override
    public int size() {
        return numberOfEntries;
    }

    @Override
    public int cardinality() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    /*
     * Tests whether this bag contains a given entry.
     */
    @Override
    public boolean contains(T anEntry) {
        if (anEntry == null) {
            return false;
        }
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData())) {
                found = true;
            } else {
                currentNode = currentNode.getNext();
            }
        }
        return found;
    }

    @Override
    public boolean isElement(T anEntry) {
        return this.contains(anEntry);
    }
    /*
     * Retrieves all entries that are in this bag.
     */

    @Override
    public T[] toArray() {
        // the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; // unchecked cast

        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = (T) currentNode.getData();
            index++;
            currentNode = currentNode.getNext();
        }
        return result;
    }

    @Override
    public T[] enumerate() {
        return this.toArray();
    }

    /**
     * Locate the reference to a particular item. Set the beginning ref to the
     * first node, then traverse with a while loop until we find the value or
     * return null.
     */
    private Node getReferenceTo(T entry) {
        boolean found = false;
        Node currentNode = firstNode;

        // while loop to traverse the list
        while (!found && (currentNode != null)) {
            if (entry.equals(currentNode.getData())) {
                found = true;
            } else {
                currentNode = currentNode.getNext();
            }
        }
        return currentNode;
    }

    @Override
    public T getMin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T getMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SetInterface union(SetInterface anotherSet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SetInterface intersection(SetInterface anotherSet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SetInterface difference(SetInterface anotherSet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
    @Override
    public boolean add(T newEntry) {
        if (newEntry == null || this.contains(newEntry)) {
            return false;
        } else {
            Node newNode = new Node(newEntry);
            newNode.setNext(firstNode);
            // make new node reference rest of chain 
            // (firstNode is null if chain is empty)        
            firstNode = newNode;
            // new node is at beginning of chain
            numberOfEntries++;
            return true;
        }

    }

    /*
     * Removes one unspecified entry
     * It is always the node pointed to by the variable firstNode.
     */
    @Override
    public T remove() {
        T result = null;

        if (firstNode != null) {
            result = (T) firstNode.getData();
            firstNode = firstNode.getNext();
            numberOfEntries--;
        }
        return result;
    }

    /**
     * Remove one occurrence of an entry. Needs to locate the reference then
     * delete. Uses getReferenceTo(), remove()
     *
     * @param entry
     * @return
     */
    @Override
    public boolean remove(T entry) {
        Node removeThis = getReferenceTo(entry);

        if (removeThis != null) {
            removeThis.setData(firstNode.getData());
            remove();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        numberOfEntries = 0;
        firstNode = null;
    }
}
