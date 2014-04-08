package adts;

import junit.framework.Assert;
import static junit.framework.Assert.assertEquals;
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
    public void size_emptyStack_returnsZero() {
        StackInterface testStack = GetStack();
        assertEquals(0, testStack.size());
    }

    
    @Test
    public void isEmpty_emptyStack_returnsTrue() {
        StackInterface testStack = GetStack();
        Assert.assertTrue(testStack.isEmpty());
    }

    @Test
    public void isEmpty_stackNotEmpty_returnsFalse() {
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
    public void peek2_singleEntry_returnsNull() {
        StackInterface testStack = GetStack();
         String firstString = "ABCDE";
        testStack.push(firstString);
        Object result = testStack.peek2();
        Assert.assertNull(result);
    }

    @Test
    public void peek2_emptyStack_returnsNull() {
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
    public void push_validEntry_returnsTrue() {
        StackInterface testStack = GetStack();
        String string1 = "ABCDE";
        boolean result = testStack.push(string1);
        Assert.assertTrue(result);
    }
    
    @Test
    public void push_validEntry_sizeIncrements() {
        StackInterface testStack = GetStack();
        String string1 = "ABCDE";
        int oldSize = testStack.size();
        testStack.push(string1);
        int newSize = testStack.size();
        Assert.assertEquals(oldSize + 1, newSize);
    }

    @Test
    public void push_validEntryEmptyStack_sizeEqualsOne() {
        StackInterface testStack = GetStack();
        String string1 = "ABCDE";
        testStack.push(string1);
        Assert.assertEquals(1, testStack.size());
    }

    
    @Test
    public void push_validEntry_isNotEmpty() {
        StackInterface testStack = GetStack();
        String string1 = "ABCDE";
        testStack.push(string1);
        Assert.assertFalse(testStack.isEmpty());
    }
    
    
    @Test
    public void push_nullEntry_returnsFalse() {
        StackInterface testStack = GetStack();
        boolean result = testStack.push(null);
        Assert.assertFalse(result);
    }

    @Test
    public void push_nullEntry_sameSize() {
        StackInterface testStack = GetStack();
        int oldSize = testStack.size();
        testStack.push(null);
        int newSize = testStack.size();
        Assert.assertEquals(oldSize, newSize);
    }
    
    @Test
    public void push_duplicateEntry_returnsTrue() {
        StackInterface testStack = GetStack();
        String string = "ABC";
        testStack.push(string);
        boolean result = testStack.push(string);
        assertTrue(result);
        
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
        int newSize = testStack.size();
        Assert.assertEquals(oldSize - 1, newSize);
    }

    
    @Test
    public void pop_singleValidEntry_isEmpty() {
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
        testStack.clear();
        Assert.assertTrue(testStack.isEmpty());
    }

    @Test
    public void clear_contents_sizeEqualsZero() {
        StackInterface testStack = GetStack();
        testStack.push("A");
        testStack.push("B");
        testStack.clear();
        Assert.assertEquals(0, testStack.size());
    }
}