package adts;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Description: This class is a base of tests for derived Stack tests. A simple
 * GetStack factory pattern is included for easy obj creation.
 *
 * @author lunatunez
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

    // If an array stack is passed a zero capacity argument,
    // throw an exception.
    @Test(expected = IllegalArgumentException.class)
    public void newStack_zeroCapacity_throwException() {
        Stack_Array<String> testStack = (Stack_Array) GetStack(0);
    }

    // If a array stack is passed a negative capacity argument,
    // throw an exception.
    @Test(expected = IllegalArgumentException.class)
    public void newStack_negativeCapacity_throwException() {
        Stack_Array<String> testStack = (Stack_Array) GetStack(-1);
    }
    
//    @Test
//    public void Stack_zeroCapacity_throwsException() {
//        Stack_Array<String> testStack = (Stack_Array) GetStack(0);
//        Assert.assertEquals(0, testStack.size());
//    }
//
//    @Test
//    public void Stack_negativeCapacity_isEmpty() {
//        Stack_Array<String> testStack = (Stack_Array) GetStack(-1);
//        Assert.assertTrue(testStack.isEmpty());
//    }

    @Override
    public String toString() {
        return "Stack_Array_Tests";
    }
}
