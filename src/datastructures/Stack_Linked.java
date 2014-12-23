package datastructures;

import java.util.Arrays;
import java.util.Objects;

/**
 *  * A dynamic size Stack using a chain of linked Nodes with only a head
 * reference.
 *
 * @author Erik Lunna
 * @param <T>
 */
public class Stack_Linked<T> implements StackInterface<T> {

    private Node topNode;
    private int numberOfNodes;

    public Stack_Linked() {
        topNode = null;
    }

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
        } else {
            throw new IllegalStateException();
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

    @Override
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

    @Override
    public boolean equals(Object aThat) {
        if (this == aThat) {
            return true;
        }
        if (!(aThat instanceof Stack_Linked)) {
            return false;
        }
        Stack_Linked that = (Stack_Linked) aThat;
        return Arrays.equals(this.toArray(), that.toArray()); //array!
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.topNode);
        hash = 89 * hash + this.numberOfNodes;
        return hash;
    }
}

//     @Override
//    public void display() {
//        displayChain(topNode);
//    }
//
//    private void displayChain(Node nodeOne) {
//        if (nodeOne != null) {
//            System.out.println(nodeOne.getData()); // display first node
//            displayChain(nodeOne.getNext());
//        }
//    }
