package adts;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * File: Description:
 *
 * @author lunatunez
 * @param <T>
 */
public abstract class LinkedChainBase<T> implements ListInterface<T> {

    private Node firstNode;
    private int numberOfNodes;

    public LinkedChainBase() {
        clear();
    }
//  protected methods getNodeAt, getFirstNode, addFirstNode,
// addAfterNode, removeFirstNode, and removeAfterNode go

    // *************************************************************************
    // *** STATIC METHODS *****************************************************
    
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
    @Override
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

    @Override
    public boolean equals(Object aThat) {
        if (this == aThat) {
            return true;
        }
        if (!(aThat instanceof Bag_Linked)) {
            return false;
        }
        Bag_Linked that = (Bag_Linked) aThat;
        return Arrays.equals(this.toArray(), that.toArray()); //array!
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.firstNode);
        hash = 37 * hash + this.numberOfNodes;
        return hash;
    }

    @Override
    public void display() {
        displayChain(firstNode);
    }

    private void displayChain(Node nodeOne) {
        if (nodeOne != null) {
            System.out.println(nodeOne.getData()); // display first node
            displayChain(nodeOne.getNext());
        }
    }

    @Override
    public Iterator getIterator() {
        return new ChainIterator(firstNode);
    }

    
    /**
     * Returns a reference to the node at the given index. (Future revision:
     * make this return a clone. To avoid exporting a private type.)
     *
     * @param index An integer, index >= 0, index less than numberOfEntries
     * @return The reference to the node if it
     */
    protected Node getNodeAt(int index) {
        if (firstNode == null || index < 0 || index > numberOfNodes - 1) {
            return null;
        }
        Node currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    /**
     * Locate the reference to a particular item. Set the beginning ref to the
     * first node, then traverse with a while loop until we find the value or
     * return null.
     *
     * @param entry
     * @return
     */
    protected Node getReferenceTo(T entry) {
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

    
    protected Node getFirstNode() {
        return firstNode;
    }
    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
    /*
     * Adds a new entry at the beginning/front of the chain:
     * OutOfMemoryError possible.
     */
    @Override
    public boolean add(T newEntry) {
        if (newEntry == null) {
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

    /**
     * Remove one occurrence of an entry. Needs to locate the reference then
     * delete. Uses getReferenceTo(), remove()
     *
     * @param entry
     * @return
     */
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


    /*
     * Removes all entries from this bag.
     */
    @Override
    public final void clear() {
        numberOfNodes = 0;
        firstNode = null;
    }
    
    
//    protected void addFirstNode(Node node) {
//        firstNode = node;
//    }
//    protected void addAfterNode(Node node) {
//    }
//    
//    protected Node removeFirstNode() {
//        
//    }
//    
//    protected void removeAfterNode() {
//        
//    }
    
    
    
}
