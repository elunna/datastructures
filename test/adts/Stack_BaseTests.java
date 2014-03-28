package adts;

import junit.framework.Assert;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;

/**
 * File: Description:
 *
 * @author lunatunez
 */
public abstract class Stack_BaseTests {
    protected abstract StackInterface GetStack();
    protected abstract StackInterface GetStack(int capacity);

    /**
     * Test of isEmpty method, using new empty stack
     */
    @Test
    public void isEmpty_onNewStack_returnsTrue() {
        StackInterface testStack = GetStack();
        System.out.println(testStack.toString()
                + ": isEmpty_onNewStack_returnsTrue");
        assertTrue(testStack.isEmpty());
    }

    /**
     * Test of push method, using valid element, of class Stack_Array.
     */
    @Test
    public void push_toEmptyStack_sizeEqualsOne() {
        Stack_Array<String> testStack = (Stack_Array) GetStack();
        System.out.println(testStack.toString()
                + ": push_toEmptyStack_sizeEqualsOne");
    }

    @Test
    public void push_toEmptyStack_isNotEmpty() {
        StackInterface testStack = GetStack();
        System.out.println(testStack.toString()
                + ": push_toEmptyStack_isNotEmpty");
        String string1 = "ABCDE";
        testStack.push(string1);
        Assert.assertTrue(!testStack.isEmpty());
    }

    @Test
    public void push_sizeEqualsOne_sizeEqualsTwo() {
        StackInterface testStack = GetStack();
        System.out.println(testStack.toString()
                + ": push_sizeEqualsOne_sizeEqualsTwo");
        String string1 = "ABCDE";
        String string2 = "DEFGH";
        testStack.push(string1);
        testStack.push(string2);
        Assert.assertEquals(2, testStack.getSize());
    }

    @Test
    public void push_nullEntry_stackIsEmpty() {
        StackInterface testStack = GetStack();
        System.out.println(testStack.toString()
                + ": push_nullEntry_stackIsEmpty");
        testStack.push(null);
        Assert.assertTrue(testStack.isEmpty());
    }

    @Test
    public void push_nullEntry_sizeEqualsZero() {
        StackInterface testStack = GetStack();
        System.out.println(testStack.toString()
                + ": push_nullEntry_sizeEqualsZero");
        testStack.push(null);
        Assert.assertEquals(0, testStack.getSize());
    }

    @Test
    public void pop_oneEntry_sizeEqualsZero() {
        StackInterface testStack = GetStack();
        System.out.println(testStack.toString()
                + ": pop_oneEntry_sizeEqualsZero");
        String string1 = "ABCDE";
        testStack.push(string1);
        testStack.pop();
        Assert.assertEquals(0, testStack.getSize());
    }

    @Test
    public void pop_oneEntry_isEmpty() {
        StackInterface testStack = GetStack();
        System.out.println(testStack.toString()
                + ": pop_oneEntry_isEmpty");
        String string1 = "ABCDE";
        testStack.push(string1);
        testStack.pop();
        Assert.assertTrue(testStack.isEmpty());
    }

    @Test
    public void pop_emptyStack_returnsNull() {
        StackInterface testStack = GetStack();
        System.out.println(testStack.toString()
                + ": pop_emptyStack_returnsNull");
        Object result = testStack.pop();
        Assert.assertNull(result);

    }

    @Test
    public void peek_emptyStack_returnsNull() {
        StackInterface testStack = GetStack();
        System.out.println(testStack.toString()
                + ": pop_emptyStack_returnsNull");
        Object result = testStack.peek();
        Assert.assertNull(result);
    }

    @Test
    public void peek_stackWithContents_matchesObject() {
        StackInterface testStack = GetStack();
        System.out.println(testStack.toString()
                + ": push_sizeEqualsOne_sizeEqualsTwo");
        String firstString = "ABCDE";
        String lastString = "DEFGH";
        testStack.push(firstString);
        testStack.push(lastString);
        Object result = testStack.peek();
        Assert.assertEquals(lastString, result);
    }

    @Test
    public void clear_contents_stackIsEmpty() {
        StackInterface testStack = GetStack();
        System.out.println(testStack.toString()
                + ": clear_contents_isEmpty");
        testStack.push("A");
        testStack.push("B");
        testStack.push("C");
        testStack.clear();
        Assert.assertTrue(testStack.isEmpty());
    }

    @Test
    public void clear_contents_sizeEqualsZero() {
        StackInterface testStack = GetStack();
        System.out.println(testStack.toString()
                + ": clear_contents_sizeEqualsZero");
        testStack.push("A");
        testStack.push("B");
        testStack.push("C");
        testStack.clear();
        Assert.assertEquals(0, testStack.getSize());
    }
}
