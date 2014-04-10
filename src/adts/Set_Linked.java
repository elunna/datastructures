package adts;

/**
 * File: Description:
 *
 * @author lunatunez
 * @param <T>
 */
public class Set_Linked<T> implements SetInterface<T> {

    private Node firstNode;
    private int numberOfNodes;

    public Set_Linked() {
        firstNode = null;
        this.numberOfNodes = 0;
    }
    // *************************************************************************
    // *** STATIC METHODS ******************************************************

    @Override
    public int cardinality() {
        return size();
    }

    @Override
    public boolean isElement(T anEntry) {
        return contains(anEntry);
    }

    @Override
    public T[] enumerate() {
        return toArray();
    }

    /**
     * Locate the reference to a particular item. Set the beginning ref to the
     * first node, then traverse with a while loop until we find the value or
     * return null.
     *
     * @param entry
     * @return
     */
    private Node getReferenceTo(T entry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (entry.equals(currentNode.getData())) {
                found = true;
            } else {
                currentNode = currentNode.getNext();
            }
        }
        return currentNode;
    }

    /**
     * Returns a reference to the node at the given index. (Future revision:
     * make this return a clone. To avoid exporting a private type.)
     *
     * @param index An integer, index >= 0, index less than numberOfEntries
     * @return The reference to the node if it
     */
    private Node getNodeAt(int index) {
        if (firstNode == null || index < 0 || index >= numberOfNodes) {
            return null;
        }
        Node currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return new Node(currentNode.getData(), currentNode.getNext());
    }

    public T getMin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
            firstNode = newNode;
            numberOfNodes++;
            return true;
        }
    }

    
    /**
     *
     * @param index
     * @return
     */
    @Override
    public T remove(int index) {
        T result = null;
        if (isEmpty() || index < 0 || index >= numberOfNodes) {
            return result;
        } else if (index == 0) {
            result = remove();
        } else if ((index >= 1) && (index <= numberOfNodes)) {
            Node nodeBefore = getNodeAt(index);
            Node nodeToRemove = nodeBefore.getNext();
            Node nodeAfter = nodeToRemove.getNext();

            nodeBefore.setNext(nodeAfter);
            result = (T) nodeToRemove.getData();
            numberOfNodes--;
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
        if (entry == null) {
            return false;
        }
        Node removeThis = getReferenceTo(entry);
        if (removeThis != null) {
            removeThis.setData(firstNode.getData());
            remove();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the number of entries currently in this bag.
     *
     * @return
     */
    @Override
    public int size() {
        return numberOfNodes;
    }

    /**
     * Sees whether this bag is empty.
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        boolean result;
        if (numberOfNodes == 0) {
            assert firstNode == null;
            result = true;
        } else {
            // extra precaution?
            assert firstNode != null : "numberOfEntries is not 0 but firstNode is null";
            result = false;
        }
        return result;
    }

    /**
     * Sees whether this bag is full.
     *
     * @return Linked chain is never full, always returns false.
     */
    @Override
    public boolean isFull() {
        return false;
    }

    /**
     * Tests whether this bag contains a given entry.
     *
     * @param anEntry
     * @return
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

    /**
     * Retrieves all entries that are in this bag.
     *
     * @return
     */
    @Override
    public T[] toArray() {
        // the cast is safe because the new array contains null entries
        @SuppressWarnings(value = "unchecked")
        T[] result = (T[]) new Object[numberOfNodes]; // unchecked cast
        int index = numberOfNodes - 1;
        Node currentNode = firstNode;
        while ((index < numberOfNodes) && (currentNode != null)) {
            result[index] = (T) currentNode.getData();
            index--;
            currentNode = currentNode.getNext();
        }
        return result;
    }

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry the entry to be counted
     * @return the number of times anEntry appears in the bag
     */
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        int counter = 0;
        Node currentNode = firstNode;
        while ((counter < numberOfNodes) && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData())) {
                frequency++;
            }
            counter++;
            currentNode = currentNode.getNext();
        }
        return frequency;
    }

    /**
     * Remove the first node from the chain.
     *
     * @return The node (if it exists) or null if it doesn't.
     */
    @Override
    public T remove() {
        T result = null;
        if (firstNode != null && !isEmpty()) {
            result = (T) firstNode.getData();
            firstNode = firstNode.getNext(); // remove first node from chain
            numberOfNodes--;
        }
        return result;
    }


    /*
     * Removes all entries from this bag.
     */
    @Override
    public void clear() {
        numberOfNodes = 0;
        firstNode = null;
    }

}
