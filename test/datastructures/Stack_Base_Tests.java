package datastructures;

import junit.framework.Assert;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import org.junit.Test;

/**
 * Abstract test driver class pattern for Stack_Base.
 *
 * @author Erik Lunna
 */
public abstract class Stack_Base_Tests {

    /**
     * Factory only returns a default empty stack. Array stack accepts a
     * capacity parameter.
     *
     * @return
     */
    protected abstract StackInterface GetStack();

    @Test
    public void size_newStack_returnsZero() {
        StackInterface testStack = GetStack();

        int result = testStack.size();
        int expResult = 0;
        assertEquals(expResult, result);
    }

    @Test
    public void isEmpty_size0_returnsTrue() {
        StackInterface testStack = GetStack();

        boolean result = testStack.isEmpty();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void isEmpty_stackNotEmpty_returnsFalse() {
        StackInterface testStack = GetStack();
        String string1 = "ABCDE";
        testStack.push(string1);

        boolean result = testStack.isEmpty();
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void peek_emptyStack_returnsNull() {
        StackInterface testStack = GetStack();

        Object result = testStack.peek();
        Object expResult = null;
        assertEquals(expResult, result);
    }

    @Test
    public void peek_contents_matchesTop() {
        StackInterface testStack = GetStack();
        String firstString = "ABCDE";
        String lastString = "DEFGH";
        testStack.push(firstString);
        testStack.push(lastString);

        Object result = testStack.peek();
        Assert.assertEquals(lastString, result);
    }

    @Test
    public void equals_matchingStack_returnsTrue() {
        StackInterface testStack = GetStack();
        testStack.push("ABC");
        testStack.push("XYZ");
        StackInterface matchingStack = GetStack();
        matchingStack.push("ABC");
        matchingStack.push("XYZ");
        assertEquals(testStack, matchingStack);

    }

    @Test
    public void equals_differentStack_returnsFalse() {
        StackInterface testStack = GetStack();
        testStack.push("ABC");
        testStack.push("XYZ");
        StackInterface differentStack = GetStack();
        differentStack.push("123");
        differentStack.push("456");
        assertNotSame(testStack, differentStack);
    }

    @Test
    public void push_validEntry_returnsTrue() {
        StackInterface testStack = GetStack();
        String string1 = "ABCDE";

        boolean result = testStack.push(string1);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void push_validEntry_sizeIncrements() {
        StackInterface testStack = GetStack();
        String string1 = "ABCDE";
        int oldSize = testStack.size();
        testStack.push(string1);

        int result = testStack.size();
        int expResult = oldSize + 1;
        assertEquals(expResult, result);
    }

    @Test
    public void push_validEntryEmptyStack_sizeEqualsOne() {
        StackInterface testStack = GetStack();
        String string1 = "ABCDE";
        testStack.push(string1);

        int result = testStack.size();
        int expResult = 1;
        assertEquals(expResult, result);
    }

    @Test
    public void push_validEntry_isNotEmpty() {
        StackInterface testStack = GetStack();
        String string1 = "ABCDE";
        testStack.push(string1);

        boolean result = testStack.isEmpty();
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void push_nullEntry_returnsFalse() {
        StackInterface testStack = GetStack();

        boolean result = testStack.push(null);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void push_nullEntry_sameSize() {
        StackInterface testStack = GetStack();
        int oldSize = testStack.size();
        testStack.push(null);

        int result = testStack.size();
        int expResult = oldSize;
        assertEquals(expResult, result);
    }

    @Test
    public void push_duplicateEntry_returnsTrue() {
        StackInterface testStack = GetStack();
        String string = "ABC";
        testStack.push(string);

        boolean result = testStack.push(string);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void pop_validContents_returnsEntry() {
        StackInterface testStack = GetStack();
        String string1 = "ABCDE";
        testStack.push(string1);

        Object result = testStack.pop();
        Assert.assertEquals(string1, result);
    }

    @Test
    public void pop_validContents_sizeDecrements() {
        StackInterface testStack = GetStack();
        String string1 = "ABCDE";
        testStack.push(string1);
        int oldSize = testStack.size();
        testStack.pop();

        int result = testStack.size();
        int expResult = oldSize - 1;
        assertEquals(expResult, result);
    }

    @Test
    public void pop_singleValidEntry_isEmpty() {
        StackInterface testStack = GetStack();
        String string1 = "ABCDE";
        testStack.push(string1);
        testStack.pop();

        boolean result = testStack.isEmpty();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalStateException.class)
    public void pop_emptyStack_throwsException() {
        StackInterface testStack = GetStack();
        Object result = testStack.pop();
    }

    @Test
    public void clear_contents_stackIsEmpty() {
        StackInterface testStack = GetStack();
        testStack.push("A");
        testStack.push("B");
        testStack.clear();

        boolean result = testStack.isEmpty();
        boolean expResult = true;
        assertEquals(expResult, result);
    }
}
