package adts;

import java.util.Arrays;

/**
 * A class of stacks whose entries are stored in an array.
 *
 * @author Erik Lunna
 * @param <T>
 */
public class Stack_Array<T> implements StackInterface<T> {

    private T[] stack;      // array of stack entries
    private int topIndex;   // index of top entry

    public Stack_Array() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    /**
     *
     * @param capacity
     */
    public Stack_Array(int capacity) {
        // the cast is safe because the new array contains null entries

        if (capacity <= 0) {
            throw new IllegalArgumentException("Bad constructor arg");
        }

        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[capacity];
        stack = tempStack;
        topIndex = -1;  // -1 = empty
    }

    @Override
    public boolean push(T newEntry) {
        boolean success = false;
        if (newEntry != null) {
            ensureCapacity();
            topIndex++;
            stack[topIndex] = newEntry;
            success = true;
        }
        return success;
    }

    private void ensureCapacity() {
        // if array is full
        if (topIndex == stack.length - 1) {
            // double size of array
            stack = Arrays.copyOf(stack, 2 * stack.length);
        } else if (stack.length == 0) {
            // If user specified zero capacity
            stack = Arrays.copyOf(stack, 1);
        }
    }

    @Override
    public T peek() {
        T top = null;
        if (!isEmpty()) {
            top = stack[topIndex];
        }
        return top;
    }

    @Override
    public T pop() {
        T top = null;
        if (!isEmpty()) {
            top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
        }
        return top;
    }

    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }

    /**
     * clear the contents of the stack
     */
    @Override
    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }

    /**
     *
     * @ the size (or height) of the stack.
     */
    @Override
    public int size() {
        return topIndex + 1;
    }

    @Override
    public T peek2() {
        if (size() > 1) {
            return stack[topIndex - 1];
        } else {
            return null;
        }
    }
}
