package adts;

import static junit.framework.Assert.assertEquals;
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
     * @return a Set extending the SetInterface of initialized capacity
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
        boolean result = testSet.contains("testEntry");
        assertFalse(result);
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
        String goodString = "testSet";
        String missing = "missing string";
        testSet.add(goodString);
        assertFalse(testSet.contains(missing));
    }

    @Test
    public void toArray_validSet_sizeMatches() {
        SetInterface testSet = GetSet();
        String testString = "testSet";
        testSet.add(testString);
        Object[] testArray = testSet.toArray();
        assertTrue(testSet.size() == testArray.length);
    }

    @Test
    public void toArray_emptySet_returnEmptyArray() {
        SetInterface testSet = GetSet();
        Object[] testArray = testSet.toArray();
        assertEquals(0, testArray.length);
    }

    @Test
    public void toArray_validSet_elementsMatch() {
        SetInterface testSet = GetSet();
        testSet.add("A");
        testSet.add("B");
        testSet.add("C");
        Object[] resultingArray = testSet.toArray();
        boolean elementsMatch = (resultingArray[0] == "A"
                && resultingArray[1] == "B"
                && resultingArray[2] == "C");
        assertTrue(elementsMatch);
    }
//
//    
//    @Test
//    public void getMin_emptySet_returnNull() {
//        SetInterface testSet = GetSet();
//        Object result = testSet.getMin();
//        assertNull(result);
//    }
//
//    @Test
//    public void getMin_singleEntry_returnEntry() {
//        SetInterface testSet = GetSet();
//        Object result = testSet.getMin();
//        Object entry = testSet.remove();
//        assertEquals(result, entry);
//    }
//
//    @Test
//    public void getMin_multipleEntries_returnMin() {
//        SetInterface testSet = GetSet();
//    }
//
//    @Test
//    public void getMax_emptySet_returnNull() {
//        SetInterface testSet = GetSet();
//        Object result = testSet.getMax();
//        assertNull(result);
//    }
//
//    @Test
//    public void getMax_singleEntry_returnEntry() {
//        SetInterface testSet = GetSet();
//        Object result = testSet.getMax();
//        Object entry = testSet.remove();
//        assertEquals(result, entry);
//    }
//
//    @Test
//    public void getMax_multipleEntries_returnMax() {
//        SetInterface testSet = GetSet();
//    }
//
//    

    @Test
    public void equals_matchingSet_returnsTrue() {
        SetInterface testSet = GetSet();
        testSet.add("ABC");
        testSet.add("XYZ");
        SetInterface matchingSet = GetSet();
        matchingSet.add("ABC");
        matchingSet.add("XYZ");
        assertEquals(testSet, matchingSet);
    }

    @Test
    public void equals_differentSet_returnsFalse() {
        SetInterface testSet = GetSet();
        testSet.add("ABC");
        testSet.add("XYZ");
        SetInterface differentSet = GetSet();
        differentSet.add("123");
        differentSet.add("456");
        assertNotSame(testSet, differentSet);
    }

    @Test
    public void union_validSets_containsSet1() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        set2.add("B");
        SetInterface union = set1.union(set2);
        assertTrue(union.contains("A"));
    }

    @Test
    public void union_validSets_containsSet2() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        set2.add("B");
        SetInterface union = set1.union(set2);
        assertTrue(union.contains("B"));
    }

    @Test
    public void union_sameValues_sizeEqualsOne() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        set2.add("A");
        SetInterface union = set1.union(set2);
        assertEquals(1, union.size());
    }

    @Test
    public void union_differentValues_sizeEqualsOne() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        set2.add("B");
        SetInterface union = set1.union(set2);
        assertEquals(2, union.size());
    }

    public void union_emptySet_sizeEqualsOne() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        SetInterface union = set1.union(set2);
        assertEquals(1, union.size());
    }

    // union_differentDataTypes_throwsException
    @Test
    public void intersection_differentValues_EmptySet() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        set2.add("B");
        SetInterface intersection = set1.intersection(set2);
        assertTrue(intersection.isEmpty());
    }

    @Test
    public void intersection_sameValues_size1() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        set2.add("A");
        SetInterface intersection = set1.intersection(set2);
        assertEquals(1, intersection.size());
    }

    @Test
    public void intersection_emptySet_emptyUnion() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        SetInterface intersection = set1.intersection(set2);
        assertTrue(intersection.isEmpty());
    }

    @Test
    public void difference_differentValues_containsSet1() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        set2.add("B");
        SetInterface difference = set1.difference(set2);
        assertTrue(difference.contains("A"));
    }

    @Test
    public void difference_differentValues_set2NotPresent() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        set2.add("B");
        SetInterface difference = set1.difference(set2);
        assertFalse(difference.contains("B"));

    }

    @Test
    public void difference_differentValues_sizeEqualsOne() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        set2.add("B");
        SetInterface difference = set1.difference(set2);
        assertEquals(1, difference.size());

    }

    @Test
    public void difference_sameValues_emptySet() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        set2.add("A");
        SetInterface difference = set1.difference(set2);
        assertTrue(difference.isEmpty());

    }

    @Test
    public void difference_sameValues_valueNotPresent() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        set2.add("A");
        SetInterface difference = set1.difference(set2);
        assertFalse(difference.contains("A"));
    }

    // intersection_differentDataTypes_throwsException
    // *************************************************************************
    // *** MUTATOR TESTS *******************************************************
    @Test
    public void add_validEntry_sizeEqualsOne() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        assertEquals(1, testSet.size());
    }

    @Test
    public void add_validEntry_returnsTrue() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        boolean result = testSet.add(string1);
        assertTrue(result);
    }

    @Test
    public void add_validEntry_isNotEmpty() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        assertFalse(testSet.isEmpty());

    }

    @Test
    public void add_nullToSet_returnsFalse() {
        SetInterface testSet = GetSet();
        boolean result = testSet.add(null);
        assertFalse(result);
    }

    @Test
    public void add_nullToEmptySet_setIsEmpty() {
        SetInterface testSet = GetSet();
        testSet.add(null);
        assertTrue(testSet.isEmpty());
    }

    @Test
    public void add_nullToEmptySet_sizeEqualsZero() {
        SetInterface testSet = GetSet();
        testSet.add(null);
        assertEquals(0, testSet.size());
    }

    @Test
    public void add_duplicateEntry_returnsFalse() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        boolean result = testSet.add(string1); // Attempt adding a duplicate
        assertFalse(result);
    }

    @Test
    public void remove_oneEntry_sizeIsZero() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        testSet.remove();
        assertEquals(0, testSet.size());
    }

    @Test
    public void remove_oneEntry_isEmpty() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        testSet.remove();
        assertTrue(testSet.isEmpty());
    }

    @Test
    public void remove_emptySet_isEmpty() {
        SetInterface testSet = GetSet();
        testSet.remove();
        assertTrue(testSet.isEmpty());
    }

    @Test
    public void remove_emptySet_sizeIsZero() {
        SetInterface testSet = GetSet();
        testSet.remove();
        assertEquals(0, testSet.size());
    }

    @Test
    public void remove_emptySet_returnsNull() {
        SetInterface testSet = GetSet();
        Object result = testSet.remove();
        assertNull(result);
    }

    // remove(int index)
    @Test
    public void remove_validIndex_returnsEntry() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        Object result = testSet.remove(0);
        assertEquals(string1, result);
    }

    @Test
    public void remove_validIndex_sizeDecrements() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        int oldSize = testSet.size();
        testSet.remove(0);
        int newSize = testSet.size();
        assertEquals(oldSize - 1, newSize);

    }

    @Test
    public void remove_validIndexSizeOne_isEmpty() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        testSet.remove(0);
        assertTrue(testSet.isEmpty());
    }

    @Test
    public void remove_emptySetPassedIndex_returnsNull() {
        SetInterface testSet = GetSet();
        Object result = testSet.remove(0);
        assertNull(result);

    }

    @Test
    public void remove_outOfBoundsIndex_returnNull() {
        SetInterface testSet = GetSet();
        int badIndex = SetInterface.DEFAULT_CAPACITY + 1;
        String string1 = "ABC";
        testSet.add(string1);
        Object result = testSet.remove(badIndex);
        assertNull(result);
    }

    @Test
    public void remove_outOfBoundsIndex_sameSize() {
        SetInterface testSet = GetSet();
        int badIndex = SetInterface.DEFAULT_CAPACITY + 1;
        String string1 = "ABC";
        testSet.add(string1);
        int oldSize = testSet.size();
        testSet.remove(badIndex);
        int newSize = testSet.size();
        assertEquals(oldSize, newSize);
    }

    @Test
    public void remove_negativeIndex_returnNull() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        Object result = testSet.remove(-1);
        assertNull(result);
    }

    @Test
    public void remove_negativeIndex_sameSize() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        int oldSize = testSet.size();
        testSet.remove(-1);
        int newSize = testSet.size();
        assertEquals(oldSize, newSize);
    }

    @Test
    public void removeEntry_nullEntry_returnsFalse() {
        SetInterface testSet = GetSet();
        // String string1 = "ABC";
        boolean result = testSet.remove(null);
        assertFalse(result);
    }

    @Test
    public void removeEntry_nullEntry_sizeDoesNotChange() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        int correctSize = testSet.size();
        testSet.remove(null);
        int result = testSet.size();
        assertEquals(correctSize, result);
    }

    @Test
    public void removeEntry_emptySet_sizeIsZero() {
        SetInterface testSet = GetSet();
        testSet.remove("ABC");
        assertEquals(0, testSet.size());
    }

    @Test
    public void removeEntry_emptySet_isEmpty() {
        SetInterface testSet = GetSet();
        testSet.remove("ABC");
        assertTrue(testSet.isEmpty());
    }

    @Test
    public void removeEntry_emptySet_returnsFalse() {
        SetInterface testSet = GetSet();
        boolean result = testSet.remove("ABC");
        assertFalse(result);
    }

    @Test
    public void clear_contents_setIsEmpty() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        testSet.clear();
        assertTrue(testSet.isEmpty());
    }

    @Test
    public void clear_contents_sizeIsZero() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        testSet.clear();
        assertEquals(0, testSet.size());
    }
}
