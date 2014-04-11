package adts;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * File: Description:
 *
 * @author lunatunez
 */
public abstract class Deque_Base_Tests {

    /**
     *
     * @return a Deque extending the DequeInterface
     */
    protected abstract DequeInterface GetDeque();

    // *************************************************************************
    // *** STATIC TESTS ********************************************************
    @Test
    public void size_newDeque_sizeEqualsZero() {
        DequeInterface testDeque = GetDeque();
        assertEquals(0, testDeque.size());
    }

    @Test
    public void isEmpty_dequeIsNotEmpty_returnsFalse() {
        DequeInterface testDeque = GetDeque();
        String string1 = "ABCDE";
        String string2 = "DEFGH";
        testDeque.addToFront(string1);
        testDeque.addToFront(string2);
        assertFalse(testDeque.isEmpty());
    }

    @Test
    public void isEmpty_emptyDeque_returnsTrue() {
        DequeInterface testDeque = GetDeque();
        assertTrue(testDeque.isEmpty());
    }

    /**
     * Test of getFront method, adding and removing one valid entry.
     */
    @Test
    public void getFront_oneEntry_resultMatches() {
        DequeInterface testDeque = GetDeque();

        String string = "ABCDE";
        testDeque.addToFront(string);
        Object result = testDeque.getFront();
        assertEquals(string, result);
    }

    @Test
    public void getFront_contents_returnsFront() {
        DequeInterface testDeque = GetDeque();
        String string1 = "ABC";
        String string2 = "DEF";
        testDeque.addToFront(string1);
        testDeque.addToFront(string2);
        
        Object result = testDeque.getFront();
        assertEquals(string2, result);
    }

    @Test
    public void getBack_oneEntry_resultMatches() {
        DequeInterface testDeque = GetDeque();
        String string = "ABCDE";
        testDeque.addToFront(string);
        Object result = testDeque.getBack();
        assertEquals(string, result);
    }

    @Test
    public void getBack_contents_returnsBack() {
        DequeInterface testDeque = GetDeque();
        String string1 = "ABC";
        String string2 = "DEF";
        testDeque.addToBack(string1);
        testDeque.addToBack(string2);
        Object result = testDeque.getBack();
        assertEquals(string2, result);
    }

    @Test
    public void getFront_emptyDeque_returnsNull() {
        DequeInterface testDeque = GetDeque();
        Object result = testDeque.getFront();
        assertNull(result);
    }
    
    @Test
    public void equals_matchingDeque_returnsTrue() {
        DequeInterface testDeque = GetDeque();
        testDeque.addToBack("ABC");
        testDeque.addToBack("XYZ");
        DequeInterface matchingDeque = GetDeque();
        matchingDeque.addToBack("ABC");
        matchingDeque.addToBack("XYZ");
        assertEquals(testDeque, matchingDeque);
    }

    @Test
    public void equals_differentDeque_returnsFalse() {
        DequeInterface testDeque = GetDeque();
        testDeque.addToBack("ABC");
        testDeque.addToBack("XYZ");
        DequeInterface differentDeque = GetDeque();
        differentDeque.addToBack("123");
        differentDeque.addToBack("456");
        assertNotSame(testDeque, differentDeque);
    }

    
    // *************************************************************************
    // *** MUTATOR TESTS *******************************************************
    @Test
    public void addToFront_validEntry_sizeIncrements() {
        DequeInterface testDeque = GetDeque();
        int oldSize = testDeque.size();
        String string = "ABCDE";
        testDeque.addToFront(string);
        int newSize = testDeque.size();
        assertEquals(oldSize + 1, newSize);

    }

    @Test
    public void addToFront_validEntry_returnsTrue() {
        DequeInterface testDeque = GetDeque();
        String string = "ABCDE";
        boolean result = testDeque.addToFront(string);
        assertTrue(result);
    }

    @Test
    public void addToFront_validEntry_isNotEmpty() {
        DequeInterface testDeque = GetDeque();
        String string = "ABCDE";
        testDeque.addToFront(string);
        assertFalse(testDeque.isEmpty());
    }

    @Test
    public void addToFront_nullEntry_returnsFalse() {
        DequeInterface testDeque = GetDeque();
        boolean result = testDeque.addToFront(null);
        assertFalse(result);
    }

    @Test
    public void addToFront_nullEntry_sameSize() {
        DequeInterface testDeque = GetDeque();
        int oldSize = testDeque.size();
        testDeque.addToFront(null);
        int newSize = testDeque.size();
        assertEquals(oldSize, newSize);
    }

    @Test
    public void addToBack_validEntry_sizeIncrements() {
        DequeInterface testDeque = GetDeque();
        int oldSize = testDeque.size();
        String string = "ABCDE";
        testDeque.addToBack(string);
        int newSize = testDeque.size();
        assertEquals(oldSize + 1, newSize);
    }

    @Test
 public    void addToBack_validEntry_returnsTrue() {
        DequeInterface testDeque = GetDeque();
        String string = "ABCDE";
        boolean result = testDeque.addToBack(string);
        assertTrue(result);
    }

    @Test
    public void addToBack_validEntry_isNotEmpty() {
        DequeInterface testDeque = GetDeque();
        String string = "ABCDE";
        testDeque.addToBack(string);
        assertFalse(testDeque.isEmpty());
    }

    @Test
    public void addToBack_nullEntry_returnsFalse() {
        DequeInterface testDeque = GetDeque();
        boolean result = testDeque.addToBack(null);
        assertFalse(result);
    }

    @Test
    public void addToBack_nullEntry_sameSize() {
        DequeInterface testDeque = GetDeque();
        int oldSize = testDeque.size();
        testDeque.addToBack(null);
        int newSize = testDeque.size();
        assertEquals(oldSize, newSize);
    }

    @Test
    public void removeFront_emptyDeque_returnsNull() {
        DequeInterface testDeque = GetDeque();
        Object result = testDeque.removeFront();
        assertNull(result);
    }

    @Test
    public void removeFront_oneEntry_resultMatches() {
        DequeInterface testDeque = GetDeque();
        String string = "ABCDE";
        testDeque.addToFront(string);
        Object result = testDeque.removeFront();
        assertEquals(string, result);
    }

    @Test
    public void removeFront_validEntry_sizeDecrements() {
        DequeInterface testDeque = GetDeque();
        String string = "ABCDE";
        
        testDeque.addToFront(string);
        
        int oldSize = testDeque.size();
        
        testDeque.removeFront();
        
        int newSize = testDeque.size();
        
        assertEquals(oldSize - 1, newSize);
    }

    @Test
    public void removeFront_contents_returnsFront() {
        DequeInterface testDeque = GetDeque();
        String first = "ABC";
        String middle = "DEF";
        String last = "GHI";
        
        testDeque.addToFront(first);
        testDeque.addToFront(middle);
        testDeque.addToFront(last);

        Object result = testDeque.removeFront();
        assertEquals(last, result);
    }

    @Test
    public void removeBack_emptyDeque_returnsNull() {
        DequeInterface testDeque = GetDeque();
        Object result = testDeque.removeBack();
        assertNull(result);
    }

    @Test
    public void removeBack_oneEntry_resultMatches() {
        DequeInterface testDeque = GetDeque();
        String string = "ABCDE";
        testDeque.addToFront(string);
        Object result = testDeque.removeBack();
        assertEquals(string, result);
    }

    @Test
    public void removeBack_validEntry_sizeDecrements() {
        DequeInterface testDeque = GetDeque();
        String string = "ABCDE";
        testDeque.addToFront(string);
        int oldSize = testDeque.size();
        testDeque.removeBack();
        int newSize = testDeque.size();
        assertEquals(oldSize - 1, newSize);
    }

    @Test
    public void removeBack_contents_returnsBack() {
        DequeInterface testDeque = GetDeque();
        String first = "ABC";
        String middle = "DEF";
        String last = "GHI";
        testDeque.addToBack(first);
        testDeque.addToBack(middle);
        testDeque.addToBack(last);

        Object result = testDeque.removeBack();
        assertEquals(last, result);
    }

    /**
     * Test of clear method, using a deque w/ contents, isEmpty should return
     * true
     */
    @Test
    public void clear_contents_isEmpty() {
        DequeInterface testDeque = GetDeque();
        String string1 = "ABCDE";
        String string2 = "DEFGH";
        testDeque.addToFront(string1);
        testDeque.addToFront(string2);
        testDeque.clear();
        assertTrue(testDeque.isEmpty());
    }
}
