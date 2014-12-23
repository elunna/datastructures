package datastructures;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * A dynamic size Set using a chain of linked Nodes with only a head reference.
 *
 * @author Erik Lunna
 * @param <T>
 */
public class Set_Linked<T> implements SetInterface<T> {

    private Node firstNode;
    private int numberOfNodes;

    public Set_Linked() {
        firstNode = null;
        this.numberOfNodes = 0;
    }

    @Override
    public int size() {
        return numberOfNodes;
    }

    @Override
    public boolean isEmpty() {
        boolean result;
        if (numberOfNodes == 0) {
            assert firstNode == null;
            result = true;
        } else {
            // extra precaution
            assert firstNode != null : "numberOfEntries is not 0 but firstNode is null";
            result = false;
        }
        return result;
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

    @Override
    public boolean add(T newEntry) {
        if (newEntry == null 
                || this.contains(newEntry)) {
            return false;
        } else {
            Node newNode = new Node(newEntry);
            newNode.setNext(firstNode);
            firstNode = newNode;
            numberOfNodes++;
            return true;
        }
    }

    @Override
    public T remove(int index) {
        T result = null;
        if (isEmpty()
                || index < 0
                || index > numberOfNodes - 1) {
            throw new IllegalArgumentException();
        } else if (index == 0) {
            result = remove();
        } else {
            Node nodeBefore = getNodeAt(index);
            Node nodeToRemove = nodeBefore.getNext();
            Node nodeAfter = nodeToRemove.getNext();

            nodeBefore.setNext(nodeAfter);
            result = (T) nodeToRemove.getData();
            numberOfNodes--;
        }
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
    public void clear() {
        numberOfNodes = 0;
        firstNode = null;
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
        int index = numberOfNodes - 1;
        Node currentNode = firstNode;
        while ((index < numberOfNodes) && (currentNode != null)) {
            result[index] = (T) currentNode.getData();
            index--;
            currentNode = currentNode.getNext();
        }
        return result;
    }

    @Override
    public boolean equals(Object aThat) {
        if (this == aThat) {
            return true;
        }
        if (!(aThat instanceof Set_Linked)) {
            return false;
        }
        Set_Linked that = (Set_Linked) aThat;
        return Arrays.equals(this.toArray(), that.toArray()); //array!
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.firstNode);
        hash = 83 * hash + this.numberOfNodes;
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
        if (firstNode == null || index < 0 || index >= numberOfNodes) {
            return null;
        }
        Node currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return new Node(currentNode.getData(), currentNode.getNext());
    }

    /**
     * Remove the first node from the chain.
     *
     * @return The node (if it exists) or null if it doesn't.
     */
    private T remove() {
        T result = null;
        if (firstNode != null && !isEmpty()) {
            result = (T) firstNode.getData();
            firstNode = firstNode.getNext(); // remove first node from chain
            numberOfNodes--;
        }
        return result;
    }
}

//
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
