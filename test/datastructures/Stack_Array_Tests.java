package datastructures;

import datastructures.Stack_Array;
import datastructures.StackInterface;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Tests for Stack_Array.
 *
 * @author Erik Lunna
 */
public class Stack_Array_Tests extends Stack_Base_Tests {

    @Override
    protected StackInterface GetStack() {
        return new Stack_Array<>();
    }

    protected StackInterface GetStack(int capacity) {
        return new Stack_Array<>(capacity);
    }

    @Test
    public void Stack_noCapacity_sizeEqualsZero() {
        Stack_Array<String> testStack = (Stack_Array) GetStack();
        Assert.assertEquals(0, testStack.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void newStack_zeroCapacity_throwException() {
        Stack_Array<String> testStack = (Stack_Array) GetStack(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newStack_negativeCapacity_throwException() {
        Stack_Array<String> testStack = (Stack_Array) GetStack(-1);
    }

    @Override
    public String toString() {
        return "Stack_Array_Tests";
    }
}
