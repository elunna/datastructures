package datastructures;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Abstract test driver class pattern for Set_Base.
 *
 * @author Erik Lunna
 */
public abstract class Set_Base_Tests {

    /**
     *
     * @return a Set extending the SetInterface of initialized capacity
     */
    // protected abstract SetInterface GetSet(int capacity);
    protected abstract SetInterface GetSet(); // empty set

    @Test
    public void size_emptySet_returnsZero() {
        SetInterface testSet = GetSet();

        int result = testSet.size();
        int expResult = 0;
        assertEquals(expResult, result);
    }

    @Test
    public void isEmpty_emptySet_returnsTrue() {
        SetInterface testSet = GetSet();

        boolean result = testSet.isEmpty();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void contains_nullEntry_returnFalse() {
        SetInterface testSet = GetSet();
        testSet.add("testSet");
        Object o = null;

        boolean result = testSet.contains(o);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void contains_validElement_returnTrue() {
        SetInterface testSet = GetSet();
        String testString = "testSet";
        testSet.add(testString);

        boolean result = testSet.contains(testString);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void contains_missingValue_returnFalse() {
        SetInterface testSet = GetSet();
        String goodString = "testSet";
        String missing = "missing string";
        testSet.add(goodString);

        boolean result = testSet.contains(missing);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void toArray_validSet_sizeMatches() {
        SetInterface testSet = GetSet();
        String testString = "testSet";
        testSet.add(testString);
        Object[] testArray = testSet.toArray();

        int result = testArray.length;
        int expResult = testSet.size();
        assertEquals(expResult, result);
    }

    @Test
    public void toArray_emptySet_returnEmptyArray() {
        SetInterface testSet = GetSet();
        Object[] testArray = testSet.toArray();

        int result = testArray.length;
        int expResult = 0;
        assertEquals(expResult, result);
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

        boolean result = union.contains("A");
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void union_validSets_containsSet2() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        set2.add("B");
        SetInterface union = set1.union(set2);

        boolean result = union.contains("B");
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void union_sameValues_sizeEquals1() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        set2.add("A");
        SetInterface union = set1.union(set2);

        int result = union.size();
        int expResult = 1;
        assertEquals(expResult, result);
    }

    @Test
    public void union_differentValues_sizeEquals2() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        set2.add("B");
        SetInterface union = set1.union(set2);

        int result = union.size();
        int expResult = 2;
        assertEquals(expResult, result);
    }

    public void union_emptySet_sizeEqualsOne() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        SetInterface union = set1.union(set2);

        int result = union.size();
        int expResult = 1;
        assertEquals(expResult, result);
    }

    // union_differentDataTypes_throwsException
    @Test
    public void intersection_differentValues_EmptySet() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        set2.add("B");
        SetInterface intersection = set1.intersection(set2);

        boolean result = intersection.isEmpty();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void intersection_sameValues_size1() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        set2.add("A");
        SetInterface intersection = set1.intersection(set2);

        int result = intersection.size();
        int expResult = 1;
        assertEquals(expResult, result);
    }

    @Test
    public void intersection_emptySet_emptyUnion() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        SetInterface intersection = set1.intersection(set2);

        boolean result = intersection.isEmpty();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void difference_differentValues_containsSet1() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        set2.add("B");
        SetInterface difference = set1.difference(set2);

        boolean result = difference.contains("A");
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void difference_differentValues_set2NotPresent() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        set2.add("B");
        SetInterface difference = set1.difference(set2);

        boolean result = difference.contains("B");
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void difference_differentValues_sizeEqualsOne() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        set2.add("B");
        SetInterface difference = set1.difference(set2);

        int result = difference.size();
        int expResult = 1;
        assertEquals(expResult, result);
    }

    @Test
    public void difference_sameValues_emptySet() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        set2.add("A");
        SetInterface difference = set1.difference(set2);

        boolean result = difference.isEmpty();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void difference_sameValues_valueNotPresent() {
        SetInterface set1 = GetSet();
        SetInterface set2 = GetSet();
        set1.add("A");
        set2.add("A");
        SetInterface difference = set1.difference(set2);

        boolean result = difference.contains("A");
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void add_validEntry_sizeEqualsOne() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);

        int result = testSet.size();
        int expResult = 1;
        assertEquals(expResult, result);
    }

    @Test
    public void add_validEntry_returnsTrue() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";

        boolean result = testSet.add(string1);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void add_validEntry_isNotEmpty() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);

        boolean result = testSet.isEmpty();
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void add_nullToSet_returnsFalse() {
        SetInterface testSet = GetSet();

        boolean result = testSet.add(null);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void add_duplicateEntry_returnsFalse() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);

        boolean result = testSet.add(string1);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void remove_validIndex_returnsEntry() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);

        Object result = testSet.remove(0);
        boolean expResult = false;
        assertEquals(string1, result);
    }

    @Test
    public void remove_validIndex_sizeDecrements() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        int oldSize = testSet.size();
        testSet.remove(0);

        int result = testSet.size();
        int expResult = oldSize - 1;
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void remove_outOfBoundsIndex_throwsException() {
        SetInterface testSet = GetSet();
        int badIndex = SetInterface.DEFAULT_CAPACITY + 1;
        String string1 = "ABC";
        testSet.add(string1);
        Object result = testSet.remove(badIndex);
    }

    @Test(expected = IllegalArgumentException.class)
    public void remove_negativeIndex_throwsException() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        int index = -1;
        Object result = testSet.remove(index);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeEntry_nullEntry_throwsException() {
        SetInterface testSet = GetSet();
        Object o = null;
        testSet.remove(o);
    }

    @Test
    public void removeEntry_validIndex_sizeDecrements() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        int oldSize = testSet.size();
        testSet.remove(string1);

        int result = testSet.size();
        int expResult = oldSize - 1;
        assertEquals(expResult, result);
    }

    @Test
    public void clear_contents_isEmpty() {
        SetInterface testSet = GetSet();
        String string1 = "ABC";
        testSet.add(string1);
        testSet.clear();

        boolean result = testSet.isEmpty();
        boolean expResult = true;
        assertEquals(expResult, result);
    }
}
