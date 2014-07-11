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
public class List_Linked<T> implements ListInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    public List_Linked() {
        //super.firstNode = null;
        this.numberOfEntries = 0;
    }

    /*
     * Gets the number of entries currently in this bag.
     */
    @Override
    public int size() {
        return numberOfEntries;
    }

    /*
     * Sees whether this bag is empty.
     */
    @Override
    public boolean isEmpty() {
        boolean result;
        if (numberOfEntries == 0) {
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
        if ((index >= 0) && (index <= numberOfEntries)) {
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
        while ((counter < numberOfEntries) && (currentNode != null)) {
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
        if (firstNode == null || index < 0 || index > numberOfEntries - 1) {
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
        if (!(aThat instanceof List_Linked)) {
            return false;
        }
        List_Linked that = (List_Linked) aThat;
        return Arrays.equals(this.toArray(), that.toArray()); //array!
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.firstNode);
        hash = 79 * hash + this.numberOfEntries;
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
            Node lastNode = getNodeAt(numberOfEntries - 1);
            lastNode.setNext(newNode);
        }
        numberOfEntries++;
        return true;
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
            firstNode = firstNode.getNext();
            numberOfEntries--;
        }
        return result;
    }

    /**
     *
     * @param index
     * @return
     */
    @Override
    public T remove(int index) {
        T result = null;
        if (isEmpty() || index < 0 || index >= numberOfEntries) {
            return result;
        } else if (index == 0) {
            result = remove();
        } else if ((index >= 1) && (index <= numberOfEntries)) {
            Node nodeBefore = getNodeAt(index);
            Node nodeToRemove = nodeBefore.getNext();
            Node nodeAfter = nodeToRemove.getNext();

            nodeBefore.setNext(nodeAfter);
            result = (T) nodeToRemove.getData();
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
     * @param newEntry
     * @return
     */
    @Override
    public boolean insert(int index, T newEntry) {
        boolean isSuccessful;

        if (index < 0
                || index > numberOfEntries) {
            // Index out of bounds error
            isSuccessful = false;
        } else if (isEmpty()) {
            // Adding to empty bag is identical to add(...).
            isSuccessful = this.add(newEntry);
        } else {
            // Adding add the beginning, or in between nodes.
            Node newNode = new Node(newEntry);
            if (index == 0) {   // beginning of chain
                newNode.setNext(firstNode);
                firstNode = newNode;
            } else {            // elsewhere in chain
                Node nodeBefore = getNodeAt(index - 1);
                Node nodeAfter = nodeBefore.getNext();
                newNode.setNext(nodeAfter);
                nodeBefore.setNext(newNode);
            }
            numberOfEntries++;
            isSuccessful = true;

        }

        return isSuccessful;
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
        } else if ((index >= 0) && (index < numberOfEntries)) {
            Node replacee = getNodeAt(index);
            replacee.setData(replacer);
            isSuccessful = true;
        } else {
            isSuccessful = false;
        }
        return isSuccessful;
    }


    /*
     * Removes all entries from this bag.
     */
    @Override
    public void clear() {
        numberOfEntries = 0;
        firstNode = null;
    }

}
