package adts;

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
