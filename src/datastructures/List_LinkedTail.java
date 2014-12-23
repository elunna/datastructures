package datastructures;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * A dynamic size List implementation using a chain of linked Nodes that uses a
 * tail reference.
 *
 * @author Erik Lunna
 * @param <T>
 */
public class List_LinkedTail<T> implements ListInterface<T> {

    private Node firstNode;
    private Node lastNode;
    private int numberOfNodes;

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
        // Preconditions: Must have valid index and non-null newEntry.
        if (index < 0
                || index > numberOfNodes
                || newEntry == null) {
            return false;
        }

        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;                        // Add to empty list
            lastNode = newNode;
        } else if (index == 0) {
            newNode.setNext(firstNode);                 // Add to beginning     
            firstNode = newNode;
        } else if (index == numberOfNodes) {
            lastNode.setNext(newNode);                  // Add to end
            lastNode = newNode;
        } else {
            Node nodeBefore = getNodeAt(index - 1);     // Add inbetween nodes
            Node nodeAfter = nodeBefore.getNext();
            newNode.setNext(nodeAfter);
            nodeBefore.setNext(newNode);
        }
        numberOfNodes++;
        return true;
    }

    @Override
    public int size() {
        return numberOfNodes;
    }

    @Override
    public boolean isFull() {
        return false;
    }

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
    public T get(int index) {
        if (isEmpty()
                || index < 0
                || index >= numberOfNodes) {
            throw new IllegalArgumentException();
        }
        T result;
        result = (T) getNodeAt(index).getData();
        return result;
    }

    @Override
    public int count(T anEntry) {
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
    public boolean replace(int index, T entry) {
        boolean isSuccessful;
        if (isEmpty() || entry == null) {
            isSuccessful = false;
        } else if ((index >= 0) && (index < numberOfNodes)) {
            Node replacee = getNodeAt(index);
            replacee.setData(entry);
            isSuccessful = true;
        } else {
            isSuccessful = false;
        }
        return isSuccessful;
    }

    private T remove() {
        return this.remove(numberOfNodes - 1);
    }

    @Override
    public T remove(int index) {
        if (index < 0
                || index > numberOfNodes - 1
                || isEmpty()) {
            throw new IllegalArgumentException();
        }

        T result;

        assert !isEmpty();
        // Case 1: Remove first Node
        if (index == 0) {
            result = (T) firstNode.getData();
            firstNode = firstNode.getNext();
            if (numberOfNodes == 1) {
                lastNode = null;
            }

        } // Case 2: Remove a Node other than 1st.
        else {
            Node nodeBefore = getNodeAt(index - 1);
            Node nodeToRemove = nodeBefore.getNext();
            Node nodeAfter = nodeToRemove.getNext();
            nodeBefore.setNext(nodeAfter);
            result = (T) nodeToRemove.getData();
            if (index == numberOfNodes) {
                lastNode = nodeBefore;
            }
        }
        numberOfNodes--;

        return result;
    }

    @Override
    public T remove(T entry) {
        if (entry == null) {
            throw new IllegalArgumentException();
        }
        Node removeThis = getReferenceTo(entry);
        if (removeThis != null) {
            T copy = (T) removeThis.getData();
            removeThis.setData(firstNode.getData());
            remove();
            return copy;
        } else {
            return null;
        }
    }

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
    public final void clear() {
        firstNode = null;
        lastNode = null;
        numberOfNodes = 0;
    }

    @Override
    public Iterator getIterator() {
        return new ChainIterator(firstNode);
    }

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
}

//    @Override
//    public void display() {
//        displayChain(firstNode);
//    }
//
//    private void displayChain(Node nodeOne) {
//        if (nodeOne != null) {
//            System.out.println(nodeOne.getData()); // display first node
//            displayChain(nodeOne.getNext());
//        }
//    }
