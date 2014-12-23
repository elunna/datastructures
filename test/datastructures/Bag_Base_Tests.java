package datastructures;

import datastructures.BagInterface;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Abstract test driver class pattern for Bag_Base
 *
 * @author Erik Lunna
 */
public abstract class Bag_Base_Tests {

    /**
     *
     * @return a Bag extending the BagInterface of initialized capacity
     */
    // protected abstract BagInterface GetBag(int capacity);
    protected abstract BagInterface GetBag(); // empty bag

    @Test
    public void size_newBag_equalsZero() {
        BagInterface testBag = GetBag();

        int result = testBag.size();
        int expResult = 0;
        assertEquals(expResult, result);
    }

    @Test
    public void isEmpty_emptyBag_returnsTrue() {
        BagInterface testBag = GetBag();

        boolean result = testBag.isEmpty();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    public void isEmpty_bagNotEmpty_returnsFalse() {
        BagInterface testBag = GetBag();
        testBag.add("ABC");

        boolean result = testBag.isEmpty();
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void contains_nullEntry_returnsFalse() {
        BagInterface testBag = GetBag();
        testBag.add("A");

        boolean result = testBag.contains(null);
    }

    @Test
    public void contains_validEntry_returnsTrue() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");

        boolean result = testBag.contains("A");
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void contains_missingValue_returnsFalse() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");

        boolean result = testBag.contains("D");
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void toArray_validBag_sizeMatches() {
        BagInterface testBag = GetBag();
        int numberOfElements = 3;
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        Object[] testReturnArray = testBag.toArray();

        int result = testReturnArray.length;
        int expResult = 3;
        assertEquals(expResult, result);
    }

    @Test
    public void toArray_validBag_elementsMatch() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        Object[] resultingArray = testBag.toArray();
        boolean elementsMatch
                = (resultingArray[0] == "A"
                && resultingArray[1] == "B"
                && resultingArray[2] == "C");
        assertTrue(elementsMatch);
    }

    @Test
    public void toArray_emptyBag_returnsEmptyArray() {
        BagInterface testBag = GetBag();
        Object[] testReturnArray = testBag.toArray();

        int result = testReturnArray.length;
        int expResult = 0;
        assertEquals(expResult, result);
    }

    @Test
    public void count_singleMatch_returnsOne() {
        BagInterface testBag = GetBag();
        String targetString = "A";
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");

        int result = testBag.count(targetString);
        int expResult = 1;
        assertEquals(expResult, result);
    }

    @Test
    public void count_noMatches_returnsZero() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        String targetString = "D";

        int result = testBag.count(targetString);
        int expResult = 0;
        assertEquals(expResult, result);
    }

    @Test
    public void count_emptyBag_returnsZero() {
        BagInterface testBag = GetBag();
        String string = "B";

        int result = testBag.count(string);
        int expResult = 0;
        assertEquals(expResult, result);
    }

    @Test
    public void equals_matchingBag_returnsTrue() {
        BagInterface testBag = GetBag();
        testBag.add("ABC");
        testBag.add("XYZ");

        BagInterface matchingBag = GetBag();
        matchingBag.add("ABC");
        matchingBag.add("XYZ");

        boolean result = testBag.equals(matchingBag);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void equals_differentBag_returnsFalse() {
        BagInterface testBag = GetBag();
        testBag.add("ABC");
        testBag.add("XYZ");
        BagInterface differentBag = GetBag();
        differentBag.add("123");
        differentBag.add("456");

        boolean result = testBag.equals(differentBag);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void add_validEntry_returnsTrue() {
        BagInterface testBag = GetBag();
        String string = "ABC";

        boolean result = testBag.add(string);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void add_validEntry_sizeIncrements() {
        BagInterface testBag = GetBag();
        int oldSize = testBag.size();
        String string = "ABC";
        testBag.add(string);

        int result = testBag.size();
        int expResult = oldSize + 1;
        assertEquals(expResult, result);
    }

    @Test
    public void add_validEntry_isNotEmpty() {
        BagInterface testBag = GetBag();
        String string1 = "ABCDE";
        testBag.add(string1);

        boolean result = testBag.isEmpty();
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void add_null_returnsFalse() {
        BagInterface testBag = GetBag();

        boolean result = testBag.add(null);
        boolean expResult = false;
        
        assertEquals(expResult, result);
    }

    @Test
    public void add_duplicateEntry_returnsTrue() {
        BagInterface testBag = GetBag();
        String string = "ABC";
        testBag.add(string);

        boolean result = testBag.add(string);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void remove_validContents_returnsEntry() {
        BagInterface testBag = GetBag();
        String first = "ABCDE";
        String last = "FGHIJ";
        testBag.add(first);
        testBag.add(last);

        Object result = testBag.remove();
        assertEquals(last, result);
    }

    @Test
    public void remove_validContents_sizeDecrements() {
        BagInterface testBag = GetBag();
        String string = "ABCDE";
        String string2 = "FGHIJ";
        testBag.add(string);
        testBag.add(string2);
        int oldSize = testBag.size();
        testBag.remove();

        int result = testBag.size();
        int expResult = oldSize - 1;
        assertEquals(expResult, result);
    }

    @Test
    public void remove_singleElement_isEmpty() {
        BagInterface testBag = GetBag();
        String string1 = "ABC";
        testBag.add(string1);
        testBag.remove();

        int result = testBag.size();
        int expResult = 0;
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalStateException.class)
    public void remove_emptyBag_IllegalStateException() {
        BagInterface testBag = GetBag();

        Object result = testBag.remove();
    }

    @Test
    public void remove_validEntry_returnsEntry() {
        BagInterface testBag = GetBag();
        String first = "ABCDE";
        String last = "FGHIJ";
        testBag.add(first);
        testBag.add(last);

        Object result = testBag.remove(first);
        Object expResult = first;
        assertEquals(expResult, result);
    }

    @Test
    public void remove_validEntry_sizeDecrements() {
        BagInterface testBag = GetBag();
        String string = "ABCDE";
        String string2 = "FGHIJ";
        testBag.add(string);
        testBag.add(string2);
        int oldSize = testBag.size();

        testBag.remove(string);

        int result = testBag.size();
        int expResult = oldSize - 1;
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalStateException.class)
    public void remove_validEntryEmptyBag_IllegalStateException() {
        BagInterface testBag = GetBag();
        String string = "ABCDE";
        testBag.remove(string);
    }

    @Test(expected = IllegalArgumentException.class)
    public void remove_nullEntry_throwsException() {
        BagInterface testBag = GetBag();
        String string = null;

        Object result = testBag.remove(string);
    }

    @Test
    public void clear_contents_bagIsEmpty() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.clear();

        boolean result = testBag.isEmpty();
        boolean expResult = true;
        assertEquals(expResult, result);
    }
}