package adts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
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
        assertEquals(0, testDeque.getLength());
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
        // Check for correct casting here.
        Object result = testDeque.getFront();
        assertEquals(string, result);
    }

    @Test
    public void getFront_contents_resultMatches() {
        DequeInterface testDeque = GetDeque();
        String addedFirst = "ABC";
        String addedLast = "DEF";
        testDeque.addToFront(addedFirst);
        testDeque.addToFront(addedLast);
        Object result = testDeque.getFront();
        assertEquals(addedFirst, result);
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
    public void getBack_contents_resultMatches() {
        DequeInterface testDeque = GetDeque();
        String addedFirst = "ABC";
        String addedLast = "DEF";
        testDeque.addToFront(addedFirst);
        testDeque.addToFront(addedLast);
        Object result = testDeque.getBack();
        assertEquals(addedLast, result);
    }

    @Test
    public void getFront_emptyDeque_returnsNull() {
        DequeInterface testDeque = GetDeque();
        Object result = testDeque.getFront();
        assertNull(result);
    }

    @Test
    public void getLength_newDeque_returnsZero() {
        DequeInterface testDeque = GetDeque();
        assertEquals(0, testDeque.getLength());
    }

    // *************************************************************************
    // *** MUTATOR TESTS *******************************************************
    @Test
    void addToFront_validEntry_sizeIncrements() {
        DequeInterface testDeque = GetDeque();
        int oldSize = testDeque.getLength();
        String string = "ABCDE";
        testDeque.addToFront(string);
        int newSize = testDeque.getLength();
        assertEquals(oldSize + 1, newSize);

    }

    @Test
    void addToFront_validEntry_returnsTrue() {
        DequeInterface testDeque = GetDeque();
        String string = "ABCDE";
        boolean result = testDeque.addToFront(string);
        assertTrue(result);
    }

    @Test
    void addToFront_validEntry_isNotEmpty() {
        DequeInterface testDeque = GetDeque();
        String string = "ABCDE";
        testDeque.addToFront(string);
        assertFalse(testDeque.isEmpty());
    }

    @Test
    void addToFront_nullEntry_returnsFalse() {
        DequeInterface testDeque = GetDeque();
        boolean result = testDeque.addToFront(null);
        assertFalse(result);
    }

    @Test
    void addToFront_nullEntry_sameSize() {
        DequeInterface testDeque = GetDeque();
        int oldSize = testDeque.getLength();
        testDeque.addToFront(null);
        int newSize = testDeque.getLength();
        assertEquals(oldSize, newSize);
    }

    @Test
    void addToBack_validEntry_sizeIncrements() {
        DequeInterface testDeque = GetDeque();
        int oldSize = testDeque.getLength();
        String string = "ABCDE";
        testDeque.addToBack(string);
        int newSize = testDeque.getLength();
        assertEquals(oldSize + 1, newSize);
    }

    @Test
    void addToBack_validEntry_returnsTrue() {
        DequeInterface testDeque = GetDeque();
        String string = "ABCDE";
        boolean result = testDeque.addToBack(string);
        assertTrue(result);
    }

    @Test
    void addToBack_validEntry_isNotEmpty() {
        DequeInterface testDeque = GetDeque();
        String string = "ABCDE";
        testDeque.addToBack(string);
        assertFalse(testDeque.isEmpty());
    }

    @Test
    void addToBack_nullEntry_returnsFalse() {
        DequeInterface testDeque = GetDeque();
        boolean result = testDeque.addToBack(null);
        assertFalse(result);
    }

    @Test
    void addToBack_nullEntry_sameSize() {
        DequeInterface testDeque = GetDeque();
        int oldSize = testDeque.getLength();
        testDeque.addToBack(null);
        int newSize = testDeque.getLength();
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
        int oldSize = testDeque.getLength();
        testDeque.removeFront();
        int newSize = testDeque.getLength();
        assertEquals(oldSize, newSize);
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
        assertEquals(first, result);
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
        int oldSize = testDeque.getLength();
        testDeque.removeBack();
        int newSize = testDeque.getLength();
        assertEquals(oldSize - 1, newSize);
    }

    @Test
    public void removeBack_contents_returnsBack() {
        DequeInterface testDeque = GetDeque();
        String first = "ABC";
        String middle = "DEF";
        String last = "GHI";
        testDeque.addToFront(first);
        testDeque.addToFront(middle);
        testDeque.addToFront(last);

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
