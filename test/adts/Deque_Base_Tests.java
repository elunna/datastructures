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
    // protected abstract Deque Interface GetDeque (int capacity);
    protected abstract DequeInterface GetDeque(); // empty Deque 

    // *************************************************************************
    // *** STATIC TESTS ********************************************************
    /**
     * Test of ieEmpty method, using a new empty deque, should return true
     */
    @Test
    public void isEmpty_newDeque_returnsTrue() {
        DequeInterface testDeque = GetDeque();
        assertTrue(testDeque.isEmpty());
    }

    /**
     * Test of isEmpty method, using a deque w/ contents, should return false
     */
    @Test
    public void isEmpty_dequeContents_returnsFalse() {
        DequeInterface testDeque = GetDeque();
        String string1 = "ABCDE";
        String string2 = "DEFGH";
        testDeque.addToFront(string1);
        testDeque.addToFront(string2);

        assertFalse(testDeque.isEmpty());
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
//        String result = (String) testDeque.getFront();

        assertEquals(string, result);
    }

    /**
     * Test of getFront method, on deque containing multiple entries. Should
     * return the first entry added.
     */
    @Test
    public void getFront_existingEntry_resultMatches() {
        DequeInterface testDeque = GetDeque();
        String addedFirst = "ABC";
        String addedLast = "DEF";
        testDeque.addToFront(addedFirst);
        testDeque.addToFront(addedLast);

        // Check for correct casting here.
        Object result = testDeque.getFront();
//        String result = (String) testDeque.getFront();
        assertEquals(addedFirst, result);
    }

    /**
     * Test of getFront method, adding and removing one valid entry.
     */
    @Test
    public void getBack_oneEntry_resultMatches() {
        DequeInterface testDeque = GetDeque();

        String string = "ABCDE";
        testDeque.addToFront(string);
        // Check for correct casting here.
        Object result = testDeque.getBack();

        assertEquals(string, result);
    }

    /**
     * Test of getFront method, on deque containing multiple entries. Should
     * return the first entry added.
     */
    @Test
    public void getBack_existingEntry_resultMatches() {
        DequeInterface testDeque = GetDeque();
        String addedFirst = "ABC";
        String addedLast = "DEF";
        testDeque.addToFront(addedFirst);
        testDeque.addToFront(addedLast);

        // Check for correct casting here.
//        String result = (String) testDeque.getBack();
        Object result = testDeque.getBack();

        assertEquals(addedLast, result);
    }

    /**
     * Test of getFront method, remove from empty removeFront, should return null.
     */
    @Test
    public void getFront_emptyDeque_returnsNull() {
        DequeInterface testDeque = GetDeque();

        // Check for correct casting here.
        Object result = testDeque.getFront();
        assertNull(result);
    }

    /**
     * Test of getLength method, of class DequeInterface.
     */
    @Test
    public void getLength_newDeque_returnsZero() {
        DequeInterface testDeque = GetDeque();
        assertEquals(0, testDeque.getLength());
    }

    // *************************************************************************
    // *** MUTATOR TESTS *******************************************************
    @Test
    void addToFront_toEmptyDeque_sizeEqualsOne() {
        DequeInterface testDeque = GetDeque();
        // Assume we are adding a valid entry
        String string = "ABCDE";
        testDeque.addToFront(string);
        assertEquals(0, testDeque.getLength());

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
    void addToFront_nullToBag_returnsFalse() {
        DequeInterface testDeque = GetDeque();
        boolean result = testDeque.addToFront(null);
        assertFalse(result);
    }

    @Test
    void addToFront_nullToEmptyBag_bagIsEmpty() {
        DequeInterface testDeque = GetDeque();
        testDeque.addToFront(null);
        assertTrue(testDeque.isEmpty());
    }

    @Test
    void addToBack_toEmptyDeque_sizeEqualsOne() {
        DequeInterface testDeque = GetDeque();
        // Assume we are adding a valid entry
        String string = "ABCDE";
        testDeque.addToBack(string);
        assertEquals(0, testDeque.getLength());
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
    void addToBack_nullToBag_returnsFalse() {
        DequeInterface testDeque = GetDeque();
        boolean result = testDeque.addToBack(null);
        assertFalse(result);
    }

    @Test
    void addToBack_nullToEmptyBag_bagIsEmpty() {
        DequeInterface testDeque = GetDeque();
        testDeque.addToBack(null);
        assertTrue(testDeque.isEmpty());
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
    public void removeFront_oneEntry_isEmpty() {
        DequeInterface testDeque = GetDeque();
        String string = "ABCDE";
        testDeque.addToFront(string);
        testDeque.removeFront();
        assertTrue(testDeque.isEmpty());
    }
    
    @Test
    public void removeFront_existingEntries_returnsFront() {
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
    public void removeBack_oneEntry_isEmpty() {
        DequeInterface testDeque = GetDeque();
        String string = "ABCDE";
        testDeque.addToFront(string);
        testDeque.removeBack();
        assertTrue(testDeque.isEmpty());
    }
    
    @Test
    public void removeBack_existingEntries_returnsBack() {
        DequeInterface testDeque = GetDeque();
        String first = "ABC";
        String middle = "DEF";
        String last = "GHI";
        testDeque.addToFront(first);
        testDeque.addToFront(middle);
        testDeque.addToFront(last);

        Object result = testDeque.removeBack();
        assertEquals(first, result);
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
