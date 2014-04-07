package adts;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * File: Description: Abstract test driver class pattern.
 *
 * @author lunatunez
 */
public abstract class Bag_Base_Tests {

    /**
     *
     * @return a Bag extending the BagInterface of initialized capacity
     */
    // protected abstract BagInterface GetBag(int capacity);
    protected abstract BagInterface GetBag(); // empty bag

    // *************************************************************************
    // *** STATIC TESTS ********************************************************
    @Test
    public void size_emptyBag_equalsZero() {
        BagInterface testBag = GetBag();
        assertEquals(0, testBag.size());
    }

    @Test
    public void isEmpty_emptyBag_returnsTrue() {
        BagInterface testBag = GetBag();
        assertTrue(testBag.isEmpty());
    }

    public void isEmpty_bagNotEmpty_returnsFalse() {
        BagInterface testBag = GetBag();
        testBag.add("ABC");
        assertFalse(testBag.isEmpty());
    }

    @Test
    public void contains_emptyBag_returnsFalse() {
        BagInterface testBag = GetBag();
        assertFalse(testBag.contains("A"));
    }

    @Test
    public void contains_nullEntry_returnsFalse() {
        // This should return false, since you can't search for 'nothing'
        BagInterface testBag = GetBag();
        testBag.add("A");
        assertFalse(testBag.contains(null));
    }

    @Test
    public void contains_validEntry_returnsTrue() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        assertTrue(testBag.contains("A"));
    }

    @Test
    public void contains_missingValue_returnsFalse() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        assertFalse(testBag.contains("D"));
    }

    @Test
    public void toArray_validBag_sizeMatches() {
        BagInterface testBag = GetBag();
        int numberOfElements = 3;
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        Object[] testReturnArray = testBag.toArray();
        assertEquals(numberOfElements, testReturnArray.length);
    }

    @Test
    public void toArray_emptyBag_returnsEmptyArray() {
        BagInterface testBag = GetBag();
        Object[] testReturnArray = testBag.toArray();
        assertEquals(0, testReturnArray.length);
    }

    @Test
    public void toArray_validBag_elementsMatch() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        Object[] resultingArray = testBag.toArray();
        boolean elementsMatch = (resultingArray[0] == "A"
                && resultingArray[1] == "B"
                && resultingArray[2] == "C");
        assertTrue(elementsMatch);
    }

    @Test
    public void getFrequencyOf_singleMatch_returnsOne() {
        BagInterface testBag = GetBag();
        String targetString = "A";
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        int count = testBag.getFrequencyOf(targetString);
        assertEquals(1, count);
    }

    @Test
    public void getFrequencyOf_noMatches_returnsZero() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        String targetString = "D";
        int count = testBag.getFrequencyOf(targetString);
        assertEquals(0, count);
    }

    @Test
    public void getFrequencyOf_twoMatches_returnsTwo() {
        BagInterface testBag = GetBag();
        String string = "B";
        testBag.add("A");
        testBag.add(string);
        testBag.add(string);
        int count = testBag.getFrequencyOf(string);
        assertEquals(2, count);
    }

    @Test
    public void getFrequencyOf_emptyBag_returnsZero() {
        BagInterface testBag = GetBag();
        String string = "B";
        int count = testBag.getFrequencyOf(string);
        assertEquals(0, count);
    }

    // *************************************************************************
    // *** MUTATOR TESTS *******************************************************
    @Test
    public void add_validEntry_returnsTrue() {
        BagInterface testBag = GetBag();
        String string = "ABC";
        boolean success = testBag.add(string);
        assertTrue(success);
    }

    @Test
    public void add_validEntry_sizeIncrements() {
        BagInterface testBag = GetBag();
        int oldSize = testBag.size();
        String string = "ABC";
        testBag.add(string);
        int newSize = testBag.size();
        assertEquals(oldSize + 1, newSize);
    }

    @Test
    public void add_validEntryEmptyBag_sizeEqualsOne() {
        BagInterface testBag = GetBag();
        String string1 = "ABCDE";
        testBag.add(string1);
        assertEquals(1, testBag.size());
    }

    @Test
    public void add_validEntry_isNotEmpty() {
        BagInterface testBag = GetBag();
        String string1 = "ABCDE";
        testBag.add(string1);
        assertFalse(testBag.isEmpty());
    }

    @Test
    public void add_null_returnsFalse() {
        BagInterface testBag = GetBag();
        boolean success = testBag.add(null);
        assertFalse(success);
    }

    @Test
    public void add_null_sameSize() {
        BagInterface testBag = GetBag();
        int oldSize = testBag.size();
        String string = null;
        testBag.add(string);
        int newSize = testBag.size();
        assertEquals(oldSize, newSize);
    }

    @Test
    public void add_duplicateEntry_returnsTrue() {
        BagInterface testBag = GetBag();
        String string = "ABC";
        testBag.add(string);
        boolean success = testBag.add(string);
        assertTrue(success);
    }

    // Test remove()
    @Test
    public void remove_validContents_returnsEntry() {
        BagInterface testBag = GetBag();
        String string = "ABCDE";
        String string2 = "FGHIJ";
        testBag.add(string);
        testBag.add(string2);
        Object result = testBag.remove();
        assertEquals(string, result);
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
        int newSize = testBag.size();
        assertEquals(oldSize - 1, newSize);
    }

    @Test
    public void remove_singleElement_isEmpty() {
        BagInterface testBag = GetBag();
        String string1 = "ABC";
        testBag.add(string1);
        testBag.remove();
        assertEquals(0, testBag.size());
    }

    @Test
    public void remove_emptyBag_isEmpty() {
        BagInterface testBag = GetBag();
        testBag.remove();
        assertTrue(testBag.isEmpty());
    }

    @Test
    public void remove_emptyBag_returnsNull() {
        BagInterface testBag = GetBag();
        Object result = testBag.remove();
        assertNull(result);
    }

    // remove(T anEntry)
    @Test
    public void remove_validEntry_returnsEntry() {
        BagInterface testBag = GetBag();
        String string = "ABCDE";
        String string2 = "FGHIJ";
        testBag.add(string);
        testBag.add(string2);
        Object result = testBag.remove(string);
        assertEquals(string, result);
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
        int newSize = testBag.size();
        assertEquals(oldSize - 1, newSize);
    }

    @Test
    public void remove_validEntryOneElement_isEmpty() {
        BagInterface testBag = GetBag();
        String string = "ABCDE";
        testBag.add(string);
        testBag.remove(string);

        assertTrue(testBag.isEmpty());

    }

    @Test
    public void remove_validEntryEmptyBag_returnsNull() {
        BagInterface testBag = GetBag();
        String string = "ABCDE";
        Object result = testBag.remove(string);
        assertNull(result);
    }

    @Test
    public void remove_nullEntry_returnsNull() {
        BagInterface testBag = GetBag();
        String string = null;
        Object result = testBag.remove(string);
        assertNull(result);

    }

    @Test
    public void remove_nullEntry_sameSize() {
        BagInterface testBag = GetBag();
        String string = "ABC";
        testBag.add(string);
        int oldSize = testBag.size();
        String nullString = null;
        testBag.remove(nullString);
        int newSize = testBag.size();
        assertEquals(oldSize, newSize);
    }

    // remove(int index)
    @Test
    public void remove_validIndex_returnsEntry() {
        BagInterface testBag = GetBag();
        String string1 = "ABC";
        testBag.add(string1);
        Object result = testBag.remove(0);
        assertEquals(string1, result);
    }

    @Test
    public void remove_validIndex_sizeDecrements() {
        BagInterface testBag = GetBag();
        String string1 = "ABC";
        testBag.add(string1);
        int oldSize = testBag.size();
        testBag.remove(0);
        int newSize = testBag.size();
        assertEquals(oldSize - 1, newSize);

    }

    @Test
    public void remove_validIndexSingleElement_isEmpty() {
        BagInterface testBag = GetBag();
        String string1 = "ABC";
        testBag.add(string1);
        testBag.remove(0);
        assertTrue(testBag.isEmpty());

    }

    @Test
    public void remove_emptyBagPassedIndex_returnsNull() {
        BagInterface testBag = GetBag();
        Object result = testBag.remove(0);
        assertNull(result);

    }

    @Test
    public void remove_outOfBoundsIndex_returnNull() {
        BagInterface testBag = GetBag();
        int badIndex = BagInterface.DEFAULT_CAPACITY + 1;
        String string1 = "ABC";
        testBag.add(string1);
        Object result = testBag.remove(badIndex);
        assertNull(result);
    }

    @Test
    public void remove_outOfBoundsIndex_sameSize() {
        BagInterface testBag = GetBag();
        int badIndex = BagInterface.DEFAULT_CAPACITY + 1;
        String string1 = "ABC";
        testBag.add(string1);
        int oldSize = testBag.size();
        testBag.remove(badIndex);
        int newSize = testBag.size();
        assertEquals(oldSize, newSize);
    }

    @Test
    public void remove_negativeIndex_returnNull() {
        BagInterface testBag = GetBag();
        String string1 = "ABC";
        testBag.add(string1);
        Object result = testBag.remove(-1);
        assertNull(result);
    }

    @Test
    public void remove_negativeIndex_sameSize() {
        BagInterface testBag = GetBag();
        String string1 = "ABC";
        testBag.add(string1);
        int oldSize = testBag.size();
        testBag.remove(-1);
        int newSize = testBag.size();
        assertEquals(oldSize, newSize);
    }

    @Test
    public void clear_contents_bagIsEmpty() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.clear();
        assertTrue(testBag.isEmpty());
    }

    @Test
    public void clear_contents_sizeEqualsZero() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.clear();
        assertEquals(0, testBag.size());
    }
}
