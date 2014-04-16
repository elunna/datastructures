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
public class List_LinkedTail<T> implements ListInterface<T> {

    private Node firstNode;
    private Node lastNode;
    private int numberOfNodes;
    
    // *************************************************************************
    // *** STATIC METHODS *****************************************************

    @Override
    public int size() {
        return numberOfNodes;
    }

    /*
     * Sees whether this bag is empty.
     */
    @Override
    public boolean isEmpty() {
        boolean result;
        if (numberOfNodes == 0) {
            assert firstNode == null && lastNode == null;
            result = true;
        } else {
            // extra precaution?
            assert firstNode != null : "numberOfEntries is not 0 but firstNode is null";
            assert lastNode != null : "numberOfEntries is not 0 but lastNode is null";
            
            result = false;
        }
        return result;
    }
    @Override
    public boolean isFull() {
        return false;
    }

    /**
     *
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
     *
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        T result = null;
        if (isEmpty()) {
            return null;
        }
        if ((index >= 0) && (index <= numberOfNodes)) {
            assert !isEmpty();
            result = (T) getNodeAt(index).getData();
        }
        return result;
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
        int index = 0;
        Node currentNode = firstNode;

        while ((index < numberOfNodes) && (currentNode != null)) {
            result[index] = (T) currentNode.getData();
            index++;
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
        if (firstNode == null || index < 0 || index > numberOfNodes - 1) {
            return null;
        }
        Node currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }
@Override
    public boolean equals(Object aThat) { 
        if (this == aThat) {
            return true;
        }
        if (!(aThat instanceof List_LinkedTail)) {
            return false;
        }
        List_LinkedTail that = (List_LinkedTail) aThat;
        return Arrays.equals(this.toArray(), that.toArray()); //array!
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.firstNode);
        hash = 59 * hash + Objects.hashCode(this.lastNode);
        hash = 59 * hash + this.numberOfNodes;
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

    
    
    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
    @Override
    public boolean add(T newEntry) {
        if (newEntry == null) {
            return false;
        }
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.setNext(newNode);
        }
        lastNode = newNode;
        numberOfNodes++;
        return true;
    }

    @Override
    public boolean insert(int index, T newEntry) {
        boolean isSuccessful = true;
        // Preconditions: Must have valid index and non-null newEntry.
        if (    index >= 0 && 
                index <= numberOfNodes && 
                newEntry != null) {
            Node newNode = new Node(newEntry);
            if (isEmpty()) {                          // Add to empty list
                firstNode = newNode;
                lastNode = newNode;
            } else if (index == 0) {            // Add to beginning     
                newNode.setNext(firstNode);
                firstNode = newNode;
            } else if (index == numberOfNodes) {// Add to end
                lastNode.setNext(newNode);
                lastNode = newNode;
            } else {                                  // Add inbetween nodes
                Node nodeBefore = getNodeAt(index - 1);
                Node nodeAfter = nodeBefore.getNext();
                newNode.setNext(nodeAfter);
                nodeBefore.setNext(newNode);
            }
            numberOfNodes++;
        } else {
            isSuccessful = false;
        }
        return isSuccessful;
    }

    @Override
    public T remove() {
        return this.remove(numberOfNodes - 1);
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;
        if ((givenPosition >= 0) && (givenPosition < numberOfNodes)) {
            assert !isEmpty();
            if (givenPosition == 0) {// Case 1: Remove first Node
                result = (T) firstNode.getData();
                firstNode = firstNode.getNext();
                if (numberOfNodes == 1) {
                    lastNode = null;
                }
            } else {                // Case 2: Remove a Node other than 1st.
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeToRemove = nodeBefore.getNext();
                Node nodeAfter = nodeToRemove.getNext();
                nodeBefore.setNext(nodeAfter);
                result = (T) nodeToRemove.getData();
                if (givenPosition == numberOfNodes) {
                    lastNode = nodeBefore;
                }
            }
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


    /**
     *
     * @param index
     * @param replacer
     * @return
     */
    @Override
    public boolean replace(int index, T replacer) {
        boolean isSuccessful;
        if (isEmpty() || replacer == null) {
            isSuccessful = false;
        } else if ((index >= 0) && (index < numberOfNodes)) {
            Node replacee = getNodeAt(index);
            replacee.setData(replacer);
            isSuccessful = true;
        } else {
            isSuccessful = false;
        }
        return isSuccessful;
    }


    @Override
    public final void clear() {
        firstNode = null;
        lastNode = null;
        numberOfNodes = 0;
    } // end clear

}
