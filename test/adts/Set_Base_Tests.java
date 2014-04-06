package adts;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * File: Description:
 *
 * @author lunatunez
 */
public abstract class Set_Base_Tests {

    /**
     *
     * @return a List extending the ListInterface of initialized capacity
     */
    // protected abstract SetInterface GetSet(int capacity);
    protected abstract SetInterface GetSet(); // empty set

    // *************************************************************************
    // *** STATIC TESTS ********************************************************
    @Test
    public void size_emptySet_returnsZero() {
        SetInterface testSet = GetSet();
        assertEquals(0, testSet.size());
    }

    @Test
    public void isFull_fullSet_returnsTrue() {
        SetInterface testSet = GetSet();
        // add a bunch of items here
        // Reason for using loop: Make sure we fill the bag.
        for (int i = 0; i < SetInterface.DEFAULT_CAPACITY; i++) {
            testSet.add("testSet");
        }
        assertTrue(testSet.isFull());
    }

    @Test
    public void isFull_emptySet_returnsFalse() {
        SetInterface testSet = GetSet();
        // default set is empty.
        assertFalse(testSet.isFull());
    }

    @Test
    public void isFull_setIsNotFull_returnsFalse() {
        SetInterface testSet = GetSet();
        testSet.add("testSet");
        assertFalse(testSet.isFull());
    }

    @Test
    public void isEmpty_emptySet_returnsTrue() {
        SetInterface testSet = GetSet();
        assertTrue(testSet.isEmpty());
    }

    @Test
    public void isEmpty_emptySet_sizeEqualsZero() {
        SetInterface testSet = GetSet();
        assertEquals(0, testSet.size());
    }

    @Test
    public void isEmpty_setIsNotEmpty_returnsFalse() {
        SetInterface testSet = GetSet();
        testSet.add("testSet");
        assertFalse(testSet.isEmpty());
    }

    @Test
    public void contains_emptySet_returnFalse() {
        SetInterface testSet = GetSet();
        // Use new empty set.
        assertFalse(testSet.contains("testEntry"));
    }

    @Test
    public void contains_nullEntry_returnFalse() {
        SetInterface testSet = GetSet();
        testSet.add("testSet");
        assertFalse(testSet.contains(null));
    }

    @Test
    public void contains_validElement_returnTrue() {
        SetInterface testSet = GetSet();
        String testString = "testSet";
        testSet.add(testString);
        assertTrue(testSet.contains(testString));

    }

    @Test
    public void contains_missingValue_returnFalse() {
        SetInterface testSet = GetSet();
        String testString2 = "testSet";
        String testString1 = "Not looking for this one.";
        testSet.add(testString2);   // add so the set is not empty.
        assertFalse(testSet.contains(testString2));
    }

    @Test
    void getMin_emptySet_returnNull() {
        SetInterface testSet = GetSet();
        Object result = testSet.getMin();
        assertNull(result);
    }

    @Test
    void getMin_singleEntry_returnEntry() {
        SetInterface testSet = GetSet();
        Object result = testSet.getMin();
        Object entry = testSet.remove();
        assertEquals(result, entry);
    }

    @Test
    void getMin_multipleEntries_returnMin() {
        SetInterface testSet = GetSet();

    }

    @Test
    void getMax_emptySet_returnNull() {
        SetInterface testSet = GetSet();
        Object result = testSet.getMax();
        assertNull(result);
    }

    @Test
    void getMax_singleEntry_returnEntry() {
        SetInterface testSet = GetSet();
        Object result = testSet.getMax();
        Object entry = testSet.remove();
        assertEquals(result, entry);

    }

    @Test
    void getMax_multipleEntries_returnMax() {
        SetInterface testSet = GetSet();

    }

    @Test
    void toArray_validSet_sizeMatches() {
        SetInterface testSet = GetSet();
        String testString = "testSet";
        testSet.add(testString);
        Object[] testArray = testSet.toArray();
        assertTrue(testSet.size() == testArray.length);
    }

    @Test
    void toArray_emptySet_returnEmptyArray() {
        SetInterface testSet = GetSet();
        Object[] testArray = testSet.toArray();
        assertEquals(0, testArray.length);
    }

    @Test
    void toArray_validSet_elementsMatche() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        String string2 = "DEF";
        testSet.add(string1);
        testSet.add(string2);
        Object[] testArray = testSet.toArray();
        // Is there a better way to check this
        // with one assert?
        assertEquals(string1, testArray[0]);
        assertEquals(string2, testArray[1]);

    }

    // *************************************************************************
    // *** MUTATOR TESTS *******************************************************
    
    @Test
    void add_validEntry_sizeEqualsOne() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        assertEquals(1, testSet.size());
    }

    @Test
    void add_validEntry_returnsTrue() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        boolean result = testSet.add(string1);
        assertTrue(result);
    }

    @Test
    void add_validEntry_isNotEmpty() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        assertFalse(testSet.isEmpty());

    }

    @Test
    void add_nullToBag_returnsFalse() {
        SetInterface testSet = GetSet();
        boolean result = testSet.add(null);
        assertFalse(result);
    }

    @Test
    void add_nullToEmptyBag_bagIsEmpty() {
        SetInterface testSet = GetSet();
        testSet.add(null);
        assertTrue(testSet.isEmpty());
    }

    @Test
    void add_nullToEmptyBag_sizeEqualsZero() {
        SetInterface testSet = GetSet();
        testSet.add(null);
        assertEquals(0, testSet.size());
    }

    @Test
    void add_duplicateEntry_returnsFalse() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        boolean result = testSet.add(string1); // Attempt adding a duplicate
        assertFalse(result);
    }

    @Test
    void remove_oneEntry_sizeIsZero() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        testSet.remove();
        assertEquals(0, testSet.size());
    }

    @Test
    void remove_oneEntry_isEmpty() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        testSet.remove();
        assertTrue(testSet.isEmpty());
    }

    @Test
    void remove_emptyBag_isEmpty() {
        SetInterface testSet = GetSet();
        testSet.remove();
        assertTrue(testSet.isEmpty());
    }

    @Test
    void remove_emptyBag_sizeIsZero() {
        SetInterface testSet = GetSet();
        testSet.remove();
        assertEquals(0, testSet.size());
    }

    @Test
    void remove_emptyBag_returnsNull() {
        SetInterface testSet = GetSet();
        Object result = testSet.remove();
        assertNull(result);
    }

    @Test
    void removeEntry_nullEntry_returnNull() {
        SetInterface testSet = GetSet();
        // String string1 = "ABC";
        Object result = testSet.remove(null);
        assertNull(result);
    }

    @Test
    void removeEntry_nullEntry_sizeDoesNotChange() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        int correctSize = testSet.size();
        testSet.remove(null);
        int result = testSet.size();
        assertEquals(correctSize, result);
    }

    @Test
    void removeEntry_emptyBag_sizeIsZero() {
        SetInterface testSet = GetSet();
        testSet.remove("ABC");
        assertEquals(0, testSet.size());
    }

    @Test
    void removeEntry_emptyBag_isEmpty() {
        SetInterface testSet = GetSet();
        testSet.remove("ABC");
        assertTrue(testSet.isEmpty());
    }

    @Test
    void removeEntry_emptyBag_returnsNull() {
        SetInterface testSet = GetSet();
        Object result = testSet.remove("ABC");
        assertNull(result);
    }

    @Test
    void clear_contents_bagIsEmpty() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        testSet.clear();
        assertTrue(testSet.isEmpty());
    }

    @Test
    void clear_contents_sizeIsZero() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        testSet.clear();
        assertEquals(0, testSet.size());
    }

}
