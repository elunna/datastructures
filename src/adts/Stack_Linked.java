package adts;

/**
 * @author Erik Lunna<eslunna@gmail.com>
 * Date: 10/22/13 Purpose:
 * @param <T>
 */
public class Stack_Linked<T> implements StackInterface<T> {
    private Node topNode;
    private int numberOfNodes;

    public Stack_Linked() {
        topNode = null;
    }

    // *************************************************************************
    // *** STATIC METHODS ******************************************************
    @Override
    public int size() {
        return numberOfNodes;
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public T peek() {
        T top = null;
        if (topNode != null) {
            top = (T) topNode.getData();
        }
        return top;
    }

    @Override
    public T peek2() {
        if (numberOfNodes < 2) {
            return null;
        } else {
            return (T) topNode.getNext().getData();
        }
    }

    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
    @Override
    public boolean push(T newEntry) {
        if (newEntry != null) {
            Node newNode = new Node((T) newEntry, topNode);
            topNode = newNode;
            numberOfNodes++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T pop() {
        T top = peek();
        if (topNode != null) {
            topNode = topNode.getNext();
        }
        numberOfNodes--;
        return top;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            pop();
        }
        topNode = null;
    }

    /**
     * Sees whether this bag is full.
     *
     * @return Linked chain is never full, always returns false.
     */
    public boolean isFull() {
        return false;
    }

    /*
     * Tests whether this bag contains a given entry.
     */
    public boolean contains(T anEntry) {
        if (anEntry == null) {
            return false;
        }
        boolean found = false;
        Node currentNode = topNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData())) {
                found = true;
            } else {
                currentNode = currentNode.getNext();
            }
        }
        return found;
    }

    /*
     * Retrieves all entries that are in this bag.
     */
    public T[] toArray() {
        // the cast is safe because the new array contains null entries
        @SuppressWarnings(value = "unchecked")
        T[] result = (T[]) new Object[numberOfNodes]; // unchecked cast
        int index = numberOfNodes - 1;
        Node currentNode = topNode;
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
        Node currentNode = topNode;
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
    public T remove() {
        T result = null;
        if (topNode != null && !isEmpty()) {
            result = (T) topNode.getData();
            topNode = topNode.getNext(); // remove first node from chain
            numberOfNodes--;
        }
        return result;
    }

}
