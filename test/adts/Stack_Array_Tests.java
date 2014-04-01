package adts;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Description: This class is a base of tests for derived Stack tests. A simple
 * GetStack factory pattern is included for easy obj creation.
 *
 * @author lunatunez
 */
public class Stack_Array_Tests extends Stack_BaseTests {
    @Override
    protected StackInterface GetStack() {
        return new Stack_Array<>();
    }

    @Override
    protected StackInterface GetStack(int capacity) {
        return new Stack_Array<>(capacity);
    }

    
    @Test
    public void Stack_noCapacity_sizeEqualsZero() {
        Stack_Array<String> testStack = (Stack_Array) GetStack();
        System.out.println(testStack.toString() + 
                ": newStack_noCapacity_sizeEqualsZero");
        Assert.assertEquals(0, testStack.getSize());
    }
    
    @Test
    public void Stack_zeroCapacity_sizeEqualsZero() {
        Stack_Array<String> testStack = (Stack_Array) GetStack(0);
        System.out.println(testStack.toString() + 
                ": newStack_zeroCapacity_sizeEqualsZero");
        Assert.assertEquals(0, testStack.getSize());
    }

    @Test
    public void Stack_negativeCapacity_isEmpty() {
        Stack_Array<String> testStack = (Stack_Array) GetStack(-1);
        System.out.println(testStack.toString() + 
                ": newStack_negativeCapacity_isEmpty");
        Assert.assertTrue(testStack.isEmpty());
    }
    
    @Override
    public String toString() {
        return "Stack_Array_Tests";
    }
}
