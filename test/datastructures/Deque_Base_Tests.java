package datastructures;

import datastructures.DequeInterface;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Abstract test driver class pattern for Deque_Base class.
 *
 * @author Erik Lunna
 */
public abstract class Deque_Base_Tests {

    /**
     *
     * @return a Deque extending the DequeInterface
     */
    protected abstract DequeInterface GetDeque();

    @Test
    public void size_newDeque_sizeEqualsZero() {
        DequeInterface testDeque = GetDeque();

        int result = testDeque.size();
        int expResult = 0;
        assertEquals(expResult, result);
    }

    @Test
    public void isEmpty_emptyDeque_returnsTrue() {
        DequeInterface testDeque = GetDeque();

        boolean result = testDeque.isEmpty();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void isEmpty_dequeIsNotEmpty_returnsFalse() {
        DequeInterface testDeque = GetDeque();
        String string1 = "ABCDE";
        String string2 = "DEFGH";
        testDeque.pushFront(string1);
        testDeque.pushFront(string2);

        boolean result = testDeque.isEmpty();
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void peekFront_oneEntry_resultMatches() {
        DequeInterface testDeque = GetDeque();

        String string = "ABCDE";
        testDeque.pushFront(string);

        boolean result = string == testDeque.peekFront();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void peekFront_contents_returnsFront() {
        DequeInterface testDeque = GetDeque();
        String string1 = "ABC";
        String string2 = "DEF";
        testDeque.pushFront(string1);
        testDeque.pushFront(string2);

        boolean result = string2 == testDeque.peekFront();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void peekBack_oneEntry_resultMatches() {
        DequeInterface testDeque = GetDeque();
        String string = "ABCDE";
        testDeque.pushFront(string);

        boolean result = string == testDeque.peekBack();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void peekBack_contents_returnsBack() {
        DequeInterface testDeque = GetDeque();
        String string1 = "ABC";
        String string2 = "DEF";
        testDeque.pushBack(string1);
        testDeque.pushBack(string2);

        boolean result = string2 == testDeque.peekBack();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void peekFront_emptyDeque_returnsNull() {
        DequeInterface testDeque = GetDeque();

        boolean result = testDeque.peekFront() == null;
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void equals_matchingDeque_returnsTrue() {
        DequeInterface testDeque = GetDeque();
        testDeque.pushBack("ABC");
        testDeque.pushBack("XYZ");

        DequeInterface matchingDeque = GetDeque();
        matchingDeque.pushBack("ABC");
        matchingDeque.pushBack("XYZ");

        assertEquals(testDeque, matchingDeque);
    }

    @Test
    public void equals_differentDeque_returnsFalse() {
        DequeInterface testDeque = GetDeque();
        testDeque.pushBack("ABC");
        testDeque.pushBack("XYZ");

        DequeInterface differentDeque = GetDeque();
        differentDeque.pushBack("123");
        differentDeque.pushBack("456");

        assertNotSame(testDeque, differentDeque);
    }

    @Test
    public void pushFront_validEntry_sizeIncrements() {
        DequeInterface testDeque = GetDeque();
        int oldSize = testDeque.size();
        String string = "ABCDE";
        testDeque.pushFront(string);

        int result = testDeque.size();
        int expResult = oldSize + 1;
        assertEquals(expResult, result);
    }

    @Test
    public void pushFront_validEntry_returnsTrue() {
        DequeInterface testDeque = GetDeque();
        String string = "ABCDE";

        boolean result = testDeque.pushFront(string);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void pushFront_nullEntry_returnsFalse() {
        DequeInterface testDeque = GetDeque();

        boolean result = testDeque.pushFront(null);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void pushBack_validEntry_sizeIncrements() {
        DequeInterface testDeque = GetDeque();
        int oldSize = testDeque.size();
        String string = "ABCDE";
        testDeque.pushBack(string);

        int result = testDeque.size();
        int expResult = oldSize + 1;
        assertEquals(expResult, result);
    }

    @Test
    public void pushBack_validEntry_returnsTrue() {
        DequeInterface testDeque = GetDeque();
        String string = "ABCDE";

        boolean result = testDeque.pushBack(string);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void pushBack_nullEntry_returnsFalse() {
        DequeInterface testDeque = GetDeque();

        boolean result = testDeque.pushBack(null);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void popFront_emptyDeque_returnsNull() {
        DequeInterface testDeque = GetDeque();

        boolean result = testDeque.popFront() == null;
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void popFront_oneEntry_resultMatches() {
        DequeInterface testDeque = GetDeque();
        String string = "ABCDE";
        testDeque.pushFront(string);

        boolean result = string == testDeque.popFront();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void popFront_validEntry_sizeDecrements() {
        DequeInterface testDeque = GetDeque();
        String string = "ABCDE";

        testDeque.pushFront(string);
        int oldSize = testDeque.size();
        testDeque.popFront();

        int result = testDeque.size();
        int expResult = oldSize - 1;
        assertEquals(expResult, result);
    }

    @Test
    public void popFront_contents_returnsFront() {
        DequeInterface testDeque = GetDeque();
        String first = "ABC";
        String middle = "DEF";
        String last = "GHI";

        testDeque.pushFront(first);
        testDeque.pushFront(middle);
        testDeque.pushFront(last);

        boolean result = last == testDeque.popFront();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void popBack_emptyDeque_returnsNull() {
        DequeInterface testDeque = GetDeque();

        boolean result = testDeque.popBack() == null;
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void popBack_oneEntry_resultMatches() {
        DequeInterface testDeque = GetDeque();
        String string = "ABCDE";
        testDeque.pushFront(string);

        boolean result = string == testDeque.popBack();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void popBack_validEntry_sizeDecrements() {
        DequeInterface testDeque = GetDeque();
        String string = "ABCDE";
        testDeque.pushFront(string);
        int oldSize = testDeque.size();
        testDeque.popBack();

        int result = testDeque.size();
        int expResult = oldSize - 1;
        assertEquals(expResult, result);
    }

    @Test
    public void popBack_contents_returnsBack() {
        DequeInterface testDeque = GetDeque();
        String first = "ABC";
        String middle = "DEF";
        String last = "GHI";
        testDeque.pushBack(first);
        testDeque.pushBack(middle);
        testDeque.pushBack(last);

        boolean result = last == testDeque.popBack();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void clear_contents_isEmpty() {
        DequeInterface testDeque = GetDeque();
        String string1 = "ABCDE";
        String string2 = "DEFGH";
        testDeque.pushFront(string1);
        testDeque.pushFront(string2);
        testDeque.clear();

        boolean result = testDeque.isEmpty();
        boolean expResult = true;
        assertEquals(expResult, result);
    }
}
