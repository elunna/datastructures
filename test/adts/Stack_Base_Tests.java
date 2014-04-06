package adts;

import junit.framework.Assert;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;

/**
 * File: Description:
 *
 * @author lunatunez
 */
public abstract class Stack_Base_Tests {

    /**
     * Factory only returns a default empty stack. Array stack accepts a
     * capacity parameter.
     *
     * @return
     */
    protected abstract StackInterface GetStack();

    // *************************************************************************
    // *** STATIC TESTS ********************************************************
    /**
     * Test of isEmpty method, using new empty stack
     */
    @Test
    public void isEmpty_onNewStack_returnsTrue() {
        StackInterface testStack = GetStack();
        assertTrue(testStack.isEmpty());
    }

    @Test
    public void isEmpty_nonEmptyStack_returnsFalse() {
        StackInterface testStack = GetStack();
        String string1 = "ABCDE";
        testStack.push(string1);
        Assert.assertFalse(testStack.isEmpty());
    }

    @Test
    public void peek_emptyStack_returnsNull() {
        StackInterface testStack = GetStack();
        Object result = testStack.peek();
        Assert.assertNull(result);
    }

    @Test
    public void peek_contents_matchesLast() {
        StackInterface testStack = GetStack();
        String firstString = "ABCDE";
        String lastString = "DEFGH";
        testStack.push(firstString);
        testStack.push(lastString);
        Object result = testStack.peek();
        Assert.assertEquals(lastString, result);
    }

    @Test
    public void peek2_contents_matches2ndLast() {
        StackInterface testStack = GetStack();
        String firstString = "ABCDE";
        String lastString = "DEFGH";
        testStack.push(firstString);
        testStack.push(lastString);
        Object result = testStack.peek2();
        Assert.assertEquals(firstString, result);
    }

    @Test
    public void peek2_singleEntry_returnNull() {
        StackInterface testStack = GetStack();
         String firstString = "ABCDE";
        testStack.push(firstString);
        Object result = testStack.peek2();
        Assert.assertNull(result);
    }

    @Test
    public void peek2_emptyStack_returnNull() {
        StackInterface testStack = GetStack();
        Object result = testStack.peek2();
        Assert.assertNull(result);
    }

    // *************************************************************************
    // *** MUTATOR TESTS *******************************************************
    /**
     * Test of push method, using valid element, of class Stack_Array.
     */
    @Test
    public void push_toEmptyStack_sizeEqualsOne() {
        StackInterface testStack = GetStack();
        String string1 = "ABCDE";
        testStack.push(string1);
        Assert.assertEquals(1, testStack.getSize());
    }

    @Test
    public void push_sizeEqualsOne_sizeEqualsTwo() {
        StackInterface testStack = GetStack();
        String string1 = "ABCDE";
        String string2 = "DEFGH";
        testStack.push(string1);
        testStack.push(string2);
        Assert.assertEquals(2, testStack.getSize());
    }

    @Test
    public void push_nullEntry_stackIsEmpty() {
        StackInterface testStack = GetStack();
        testStack.push(null);
        Assert.assertTrue(testStack.isEmpty());
    }

    @Test
    public void push_nullEntry_sizeEqualsZero() {
        StackInterface testStack = GetStack();
        testStack.push(null);
        Assert.assertEquals(0, testStack.getSize());
    }

    @Test
    public void pop_oneEntry_sizeEqualsZero() {
        StackInterface testStack = GetStack();
        String string1 = "ABCDE";
        testStack.push(string1);
        testStack.pop();
        Assert.assertEquals(0, testStack.getSize());
    }

    @Test
    public void pop_oneEntry_isEmpty() {
        StackInterface testStack = GetStack();
        String string1 = "ABCDE";
        testStack.push(string1);
        testStack.pop();
        Assert.assertTrue(testStack.isEmpty());
    }

    @Test
    public void pop_emptyStack_returnsNull() {
        StackInterface testStack = GetStack();
        Object result = testStack.pop();
        Assert.assertNull(result);
    }

    @Test
    public void clear_contents_stackIsEmpty() {
        StackInterface testStack = GetStack();
        testStack.push("A");
        testStack.push("B");
        testStack.push("C");
        testStack.clear();
        Assert.assertTrue(testStack.isEmpty());
    }

    @Test
    public void clear_contents_sizeEqualsZero() {
        StackInterface testStack = GetStack();
        testStack.push("A");
        testStack.push("B");
        testStack.push("C");
        testStack.clear();
        Assert.assertEquals(0, testStack.getSize());
    }
}
