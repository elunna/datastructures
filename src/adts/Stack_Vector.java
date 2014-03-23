package adts;

import java.util.Vector;

/**
 * A class of stacks whose entries are stored in a vector.
 *
 * @author Frank M. Carrano
 * @param <T>
 */
public class Stack_Vector<T> implements StackInterface<T> {
    private Vector<T> stack; // last element is the top entry in stack
    private static final int DEFAULT_INITIAL_CAPACITY = 50;

    public Stack_Vector() {
        this(DEFAULT_INITIAL_CAPACITY);
    } // end default constructor

    public Stack_Vector(int initialCapacity) {
        stack = new Vector<>(initialCapacity);
        // size doubles as needed
    }

    @Override
    public void push(T newEntry) {
        stack.add(newEntry);
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
    public T pop() {
        T top = null;
        if (!isEmpty()) {
            top = stack.remove(stack.size() - 1);
        }
        return top;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    @Override
    public void clear() {
        stack.clear();
    }
}