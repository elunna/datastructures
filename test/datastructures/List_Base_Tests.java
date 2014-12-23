package datastructures;

import datastructures.ListInterface;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Abstract test driver class pattern for List
 *
 * @author Erik Lunna
 */
public abstract class List_Base_Tests {

    /**
     *
     * @return a List extending the ListInterface of initialized capacity
     */
    protected abstract ListInterface GetList(); // empty bag

    @Test
    public void size_emptyBag_equalsZero() {
        ListInterface list = GetList();

        int result = list.size();
        int expResult = 0;
        assertEquals(expResult, result);
    }

    @Test
    public void isEmpty_emptyList_returnsTrue() {
        ListInterface testList = GetList();

        boolean result = testList.isEmpty();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void isEmpty_ListIsNotEmpty_returnsFalse() {
        ListInterface testList = GetList();
        testList.add("ABC");

        boolean result = testList.isEmpty();
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void contains_nullEntry_returnFalse() {
        ListInterface testList = GetList();

        boolean result = testList.contains(null);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void contains_validElement_returnTrue() {
        ListInterface testList = GetList();
        String string1 = "ABC";
        testList.add(string1);

        boolean result = testList.contains(string1);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void contains_missingValue_returnFalse() {
        ListInterface testList = GetList();
        String string1 = "ABC";
        testList.add("DEF");

        boolean result = testList.contains(string1);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void get_emptyList_IllegalArgumentException() {
        ListInterface testList = GetList();
        Object result = testList.get(0);
    }

    @Test
    public void get_validIndex_returnsElement() {
        ListInterface testList = GetList();
        String string = "ABC";
        testList.add(string);

        Object result = testList.get(0);
        assertEquals(string, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void get_outOfBoundsIndex_throwsException() {
        ListInterface testList = GetList();
        int badIndex = testList.size() + 1;
        
        Object result = testList.get(badIndex);
    }

    @Test
    public void toArray_validList_sizeMatches() {
        ListInterface testList = GetList();
        int numberOfElements = 3;
        testList.add("A");
        testList.add("B");
        testList.add("C");
        Object[] testReturnArray = testList.toArray();

        int result = testReturnArray.length;
        assertEquals(numberOfElements, result);
    }

    @Test
    public void toArray_emptyList_returnEmptyArray() {
        ListInterface testList = GetList();
        Object[] testReturnArray = testList.toArray();

        int result = testReturnArray.length;
        int expResult = 0;
        assertEquals(expResult, result);
    }

    @Test
    public void toArray_validList_elementsMatch() {
        ListInterface testList = GetList();
        testList.add("A");
        testList.add("B");
        testList.add("C");
        Object[] resultingArray = testList.toArray();
        // the linked array will be in reverse order
        // however, order doesn't matter with this adt.

        boolean result = (resultingArray[0] == "A"
                && resultingArray[1] == "B"
                && resultingArray[2] == "C");
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void equals_matchingList_returnsTrue() {
        ListInterface testList = GetList();
        testList.add("ABC");
        testList.add("XYZ");
        ListInterface matchingList = GetList();

        matchingList.add("ABC");
        matchingList.add("XYZ");
        assertEquals(testList, matchingList);
    }

    @Test
    public void equals_differentList_returnsFalse() {
        ListInterface testList = GetList();
        testList.add("ABC");
        testList.add("XYZ");
        ListInterface differentList = GetList();
        differentList.add("123");
        differentList.add("456");
        assertNotSame(testList, differentList);
    }

    @Test
    public void add_validEntry_returnsTrue() {
        ListInterface testList = GetList();
        String string = "ABC";

        boolean result = testList.add(string);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void add_validEntry_sizeIncrements() {
        ListInterface testList = GetList();
        int oldSize = testList.size();
        String string = "ABC";
        testList.add(string);

        int result = testList.size();
        int expResult = oldSize + 1;
        assertEquals(expResult, result);
    }

    @Test
    public void add_null_returnsFalse() {
        ListInterface testList = GetList();
        String string = null;

        boolean result = testList.add(string);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void insert_validEntryValidIndex_returnsTrue() {
        ListInterface testList = GetList();
        String string = "ABC";
        int index = 0;
        boolean result = testList.insert(index, string);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void insert_validEntryValidIndex_sizeIncrements() {
        ListInterface testList = GetList();
        int oldSize = testList.size();
        String string = "ABC";
        int index = 0;
        testList.insert(index, string);

        int result = testList.size();
        int expResult = oldSize + 1;
        assertEquals(expResult, result);
    }

    @Test
    public void insert_negativeIndex_returnsFalse() {
        ListInterface testList = GetList();
        String string = "ABC";
        int index = -1;
        boolean result = testList.insert(index, string);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void insert_invalidIndex_returnsFalse() {
        ListInterface testList = GetList();
        int index = testList.size() + 1;
        String string = "ABC";

        boolean result = testList.insert(index, string);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void insert_nullEntry_returnsFalse() {
        ListInterface testList = GetList();
        String string = null;

        boolean result = testList.insert(0, string);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void remove_validIndex_returnsEntry() {
        ListInterface testList = GetList();
        String string1 = "ABC";
        testList.add(string1);
        int index = 0;
        Object result = testList.remove(index);
        Object expResult = string1;
        assertEquals(expResult, result);
    }

    @Test
    public void remove_validIndex_sizeDecrements() {
        ListInterface testList = GetList();
        String string1 = "ABC";
        testList.add(string1);

        int oldSize = testList.size();
        int index = 0;
        testList.remove(index);

        int result = testList.size();
        int expResult = oldSize - 1;
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void remove_emptyListPassedIndex_throwsException() {
        ListInterface testList = GetList();
        Object result = testList.remove(0);
        assertNull(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void remove_outOfBoundsIndex_throwsException() {
        ListInterface testList = GetList();
        int badIndex = ListInterface.DEFAULT_CAPACITY + 1;
        String string1 = "ABC";
        testList.add(string1);
        Object result = testList.remove(badIndex);
    }

    @Test(expected = IllegalArgumentException.class)
    public void remove_negativeIndex_throwsException() {
        ListInterface testList = GetList();
        String string1 = "ABC";
        testList.add(string1);
        int badIndex = -1;
        Object result = testList.remove(badIndex);
    }

    @Test
    public void replace_validIndexValidEntry_returnsTrue() {
        ListInterface testList = GetList();
        String oldValue = "ABC";
        testList.add(oldValue);
        String newValue = "XYZ";

        boolean result = testList.replace(0, newValue);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void replace_validIndexValidEntry_sameSize() {
        ListInterface testList = GetList();
        String oldValue = "ABC";
        testList.add(oldValue);
        String newValue = "XYZ";
        int oldSize = testList.size();
        testList.replace(0, newValue);

        int result = testList.size();
        assertEquals(oldSize, result);
    }

    @Test
    public void replace_validIndexValidEntry_oldValueGone() {
        ListInterface testList = GetList();
        String oldValue = "ABC";
        testList.add(oldValue);
        String newValue = "XYZ";
        testList.replace(0, newValue);

        boolean result = testList.contains(oldValue);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void replace_validIndexValidEntry_newValuePresent() {
        ListInterface testList = GetList();
        String oldValue = "ABC";
        testList.add(oldValue);
        String newValue = "XYZ";
        testList.replace(0, newValue);

        boolean result = testList.contains(newValue);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void replace_outOfBoundsIndex_returnsFalse() {
        ListInterface testList = GetList();
        int badIndex = ListInterface.DEFAULT_CAPACITY;
        String oldValue = "ABC";
        testList.add(oldValue);
        String newValue = "XYZ";

        boolean result = testList.replace(badIndex, newValue);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void replace_negativeIndex_returnsFalse() {
        ListInterface testList = GetList();
        String oldValue = "ABC";
        testList.add(oldValue);
        String newValue = "XYZ";

        boolean result = testList.replace(-1, newValue);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void replace_nullEntry_returnsFalse() {
        ListInterface testList = GetList();
        String oldValue = "ABC";
        testList.add(oldValue);
        String newValue = null;;

        boolean result = testList.replace(0, newValue);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void clear_contents_bagIsEmpty() {
        ListInterface testList = GetList();
        String string = "ABC";
        testList.add(string);
        testList.clear();

        boolean result = testList.isEmpty();
        boolean expResult = true;
        assertEquals(expResult, result);
    }
}