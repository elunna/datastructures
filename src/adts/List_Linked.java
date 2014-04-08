package adts;

/**
 * File: Description:
 *
 * @author lunatunez
 */
public class List_Linked<T> implements ListInterface<T> {

    Node firstNode;
    int numberOfEntries;

    public List_Linked() {
        this.firstNode = null;
        this.numberOfEntries = 0;
    }

    private Node getNodeAt(int givenPosition) {
//        assert (firstNode != null)
//                && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
        Node currentNode = firstNode;
        // traverse the chain to locate the desired node
        for (int counter = 1; counter < givenPosition; counter++) {
            currentNode = currentNode.getNext();
        }
        // assert currentNode != null;
        return currentNode;
    }
    // *************************************************************************
    // *** STATIC METHODS ******************************************************

    @Override
    public int size() {
        
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        boolean result;
        if (numberOfEntries == 0) {
            assert firstNode == null;
            result = true;
        } else {
            // assert firstNode != null; // extra precaution?
            assert firstNode != null : "numberOfEntries is not 0 but firstNode is null";
            result = false;
        }
        return result;
    }

    /**
     *
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        T result = null; 
        
        if ((index >= 1) && (index <= numberOfEntries)) {
            assert !isEmpty();
            result = (T) getNodeAt(index).getData();
        }
        return result;
    }

    @Override
    public boolean contains(T anEntry) {
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
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];

        int index = 0;
        Node currentNode = firstNode;

        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = (T) currentNode.getData();
            currentNode = currentNode.getNext();
            index++;
        }

        return result;
    }

    public T[] toArray2() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];

        // this uses a different while loop - analyze
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            currentNode = getNodeAt(index + 1);
            result[index] = (T) currentNode.getData();
            index++;
        }
        return result;
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
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.setNext(newNode);
        }
        numberOfEntries++;
        return true;
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
        if ((index >= 1) && (index <= numberOfEntries + 1)) {
            Node newNode = new Node(newEntry);
            if (index == 1) {
                newNode.setNext(firstNode);
                firstNode = newNode;
            } else {
                Node nodeBefore = getNodeAt(index - 1);
                Node nodeAfter = nodeBefore.getNext();
                newNode.setNext(nodeAfter);
                nodeBefore.setNext(newNode);
            }
            numberOfEntries++;
            isSuccessful = true;

        } else {
            isSuccessful = false;
        }
        return isSuccessful;
    }

    @Override
    public T remove() {
       T result = null;
       if (size() > 0) {
           result = (T) firstNode.getData();
            firstNode = firstNode.getNext();
            numberOfEntries--;
       }
       return result;
        
    }

    @Override
    public T remove(int index) {
        T result = null;
        if ((index >= 1) && (index <= numberOfEntries)) {
            assert !isEmpty();
            if (index == 1) {
                result = (T) firstNode.getData();
                firstNode = firstNode.getNext();
            } else {
                Node nodeBefore = getNodeAt(index - 1);
                Node nodeToRemove = nodeBefore.getNext();
                Node nodeAfter = nodeToRemove.getNext();
                nodeBefore.setNext(nodeAfter);

                result = (T) nodeToRemove.getData();
            }
            numberOfEntries--;
        }
        return result;
    }

    @Override
    public boolean replace(int index, T newEntry) {
        boolean isSuccessful = true;

        if ((index >= 1) && (index <= numberOfEntries)) {
            assert !isEmpty();
            Node desiredNode = getNodeAt(index);
            desiredNode.setData(newEntry);
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

}
