package adts;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Vector;

/**
 * A class of stacks whose entries are stored in a vector.
 *
 * @author Frank M. Carrano
 * @param <T>
 */
public class Stack_Vector<T> implements StackInterface<T> {

    @SuppressWarnings("FieldMayBeFinal")
    private Vector<T> stack; // last element is the top entry in stack

    public Stack_Vector() {
        stack = new Vector<>();
    }
// *************************************************************************
    // *** STATIC METHODS ******************************************************

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public T peek() {
        T top = null;
        if (!isEmpty()) {
            top = stack.lastElement();
        }
        return top;
    }

    @Override
    public T peek2() {
        if (stack.size() < 2) {
            return null;
        } else {
            return (T) stack.get(stack.size() - 2);
        }
    }

    @Override
    public T[] toArray() {
        return (T[]) stack.toArray();
    }

    @Override
    public boolean equals(Object aThat) {
        if (this == aThat) {
            return true;
        }
        if (!(aThat instanceof Stack_Vector)) {
            return false;
        }
        Stack_Vector that = (Stack_Vector) aThat;
        return Arrays.equals(this.toArray(), that.toArray()); //array!
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.stack);
        return hash;
    }

    
    // Displays all the elements of bag line by line.
    @Override
    public void display() {
        displayArray(0, stack.size() - 1);
    }

    /**
     * Does the work of recursively displaying the individual elements
     *
     * @param first
     * @param last
     */
    private void displayArray(int first, int last) {
        System.out.println(stack.get(first));
        if (first < last) {
            displayArray(first + 1, last);
        }
    }

    @Override
    public Iterator getIterator() {
        return stack.iterator();

    }
    // *************************************************************************
    // *** MUTATOR METHODS ******************************************************
    @Override
    public boolean push(T newEntry) {
        if (newEntry != null) {
            return stack.add(newEntry);
        }
        return false;
    }

    @Override
    public T pop() {
        T top = null;
        if (!isEmpty()) {
            top = stack.remove(stack.size() - 1);
        }
        return top;
    }

    @Override
    public void clear() {
        stack.clear();
    }
}
