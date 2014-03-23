package adts;
import java.util.Arrays;

/**
 * A class of stacks whose entries are stored in an array.
 *
 * @author Erik Lunna
 */
public class Stack_Array<T> implements StackInterface<T> {
    private T[] stack;      // array of stack entries
    private int topIndex;   // index of top entry
    private static final int DEFAULT_INITIAL_CAPACITY = 50;

    public Stack_Array() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    /**
     *
     * @param initialCapacity
     */
    public Stack_Array(int initialCapacity) {
        // the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
    }

    @Override
    public void push(T newEntry) {
        ensureCapacity();
        topIndex++;
        stack[topIndex] = newEntry;
    }
    private void ensureCapacity() {
        // if array is full,
        if (topIndex == stack.length - 1) {
            // double size of array
            stack = Arrays.copyOf(stack, 2 * stack.length);
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
        if ( !isEmpty() ) {
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

    @Override
    public void clear() {
        while(!isEmpty()) {
            pop();
        } 
    }
    
    /**
     * The method clear could simply set topIndex to -1, 
     * because the stack methods would behave correctly as 
     * though the stack were empty. However, the objects 
     * that were in the stack would remain allocated. 
     * Just as pop sets stack[topIndex] to null, clear 
     * should set to null each array location that was 
     * used for the stack. Alternatively, clear could call 
     * pop repeatedly until the stack is empty.
     * 
     * We leave the implementation of clear as an exercise.
     */
}