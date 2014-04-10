package adts;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * File: Description: Abstract test driver class pattern.
 *
 * @author lunatunez
 */
public abstract class List_Base_Tests {

    /**
     *
     * @return a List extending the ListInterface of initialized capacity
     */
    protected abstract ListInterface GetList(); // empty bag

    // *************************************************************************
    // *** STATIC TESTS ********************************************************
    @Test
    public void size_emptyBag_equalsZero() {
        ListInterface testList = GetList();
        assertEquals(0, testList.size());
    }

    @Test
    public void isEmpty_emptyList_returnsTrue() {
        ListInterface testList = GetList();
        assertTrue(testList.isEmpty());
    }

    @Test
    public void isEmpty_ListIsNotEmpty_returnsFalse() {
        ListInterface testList = GetList();
        testList.add("ABC");
        assertFalse(testList.isEmpty());
    }

    @Test
    public void contains_emptyList_returnFalse() {
        ListInterface testList = GetList();
        boolean result = testList.contains("ABC");
        assertFalse(result);
    }

    @Test
    public void contains_nullEntry_returnFalse() {
        ListInterface testList = GetList();
        boolean result = testList.contains(null);
        assertFalse(result);
    }

    @Test
    public void contains_validElement_returnTrue() {
        ListInterface testList = GetList();
        String string1 = "ABC";
        testList.add(string1);
        boolean result = testList.contains(string1);
        assertTrue(result);
    }

    @Test
    public void contains_missingValue_returnFalse() {
        ListInterface testList = GetList();
        String string1 = "ABC";
        testList.add("DEF");
        boolean result = testList.contains(string1);
        assertFalse(result);
    }

    @Test
    public void get_emptyList_returnsNull() {
        ListInterface testList = GetList();
        Object result = testList.get(0);
        assertNull(result);
    }

    @Test
    public void get_validIndex_returnsElement() {
        ListInterface testList = GetList();
        String string = "ABC";
        testList.add(string);
        Object result = testList.get(0);
        assertEquals(string, result);
    }

    @Test
    public void get_outOfBoundsIndex_returnsNull() {
        ListInterface testList = GetList();
        int badIndex = ListInterface.DEFAULT_CAPACITY + 1;
        Object result = testList.get(badIndex);
        assertNull(result);
    }

    @Test
    public void toArray_validList_sizeMatches() {
        ListInterface testList = GetList();
        int numberOfElements = 3;
        testList.add("A");
        testList.add("B");
        testList.add("C");
        Object[] testReturnArray = testList.toArray();
        assertEquals(numberOfElements, testReturnArray.length);
    }

    @Test
    public void toArray_emptyList_returnEmptyArray() {
        ListInterface testList = GetList();
        Object[] testReturnArray = testList.toArray();
        assertEquals(0, testReturnArray.length);
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
        
        boolean elementsMatch = (resultingArray[0] == "A"
                && resultingArray[1] == "B"
                && resultingArray[2] == "C");
        assertTrue(elementsMatch);
    }

    // *************************************************************************
    // *** MUTATOR TESTS *******************************************************
    @Test
    public void add_validEntry_returnsTrue() {
        ListInterface testList = GetList();
        String string = "ABC";
        boolean result = testList.add(string);
        assertTrue(result);
    }

    @Test
    public void add_validEntry_sizeIncrements() {
        ListInterface testList = GetList();
        int oldSize = testList.size();
        String string = "ABC";
        testList.add(string);
        int newSize = testList.size();
        assertEquals(oldSize + 1, newSize);
    }

    @Test
    public void add_validEntryEmptyList_sizeEqualsOne() {
        ListInterface testList = GetList();
        String string = "ABC";
        testList.add(string);
        assertEquals(1, testList.size());
    }

    @Test
    public void add_validEntry_isNotEmpty() {
        ListInterface testList = GetList();
        String string = "ABC";
        testList.add(string);
        assertFalse(testList.isEmpty());
    }

    @Test
    public void add_null_returnsFalse() {
        ListInterface testList = GetList();
        String string = null;
        boolean result = testList.add(string);
        assertFalse(result);
    }

    @Test
    public void add_null_sameSize() {
        ListInterface testList = GetList();
        int oldSize = testList.size();
        String string = null;
        testList.add(string);
        assertEquals(oldSize, testList.size());
    }

    // good cases
    @Test
    public void insert_toEmptyList_sizeEqualsOne() {
        ListInterface testList = GetList();
        String string = "ABC";
        testList.insert(0, string);
        assertEquals(1, testList.size());
    }

    @Test
    public void insert_validEntryValidIndex_returnsTrue() {
        ListInterface testList = GetList();
        String string = "ABC";
        boolean result = testList.insert(0, string);
        assertTrue(result);
    }

    @Test
    public void insert_validEntryValidIndex_sizeIncrements() {
        ListInterface testList = GetList();
        int oldSize = testList.size();
        String string = "ABC";
        testList.insert(0, string);
        int newSize = testList.size();
        assertEquals(oldSize + 1, newSize);
    }

    // bad cases
    @Test
    public void insert_negativeIndex_returnsFalse() {
        ListInterface testList = GetList();
        String string = "ABC";
        boolean result = testList.insert(-1, string);
        assertFalse(result);
    }

    @Test
    public void insert_negativeIndex_sameSize() {
        ListInterface testList = GetList();
        int oldSize = testList.size();
        String string = "ABC";
        testList.insert(-1, string);
        int newSize = testList.size();
        assertEquals(oldSize, newSize);
    }

    @Test
    public void insert_invalidIndex_returnsFalse() {
        ListInterface testList = GetList();
        int badIndex = ListInterface.DEFAULT_CAPACITY + 1;
        String string = "ABC";
        boolean result = testList.insert(badIndex, string);
        assertFalse(result);
    }

    @Test
    public void insert_invalidIndex_sameSize() {
        ListInterface testList = GetList();
        int oldSize = testList.size();
        int badIndex = ListInterface.DEFAULT_CAPACITY + 1;
        String string = "ABC";
        testList.insert(badIndex, string);
        int newSize = testList.size();
        assertEquals(oldSize, newSize);

    }

    @Test
    public void insert_nullEntry_returnsFalse() {
        ListInterface testList = GetList();
        String string = null;
        boolean result = testList.insert(0, string);
        assertFalse(result);
    }

    @Test
    public void insert_nullEntry_sameSize() {
        ListInterface testList = GetList();
        int oldSize = testList.size();
        String string = null;
        testList.insert(0, string);
        int newSize = testList.size();
        assertEquals(oldSize, newSize);

    }
    // remove()
    @Test
    public void remove_validContents_returnsEntry() {
        ListInterface testList = GetList();
        String string1 = "ABC";
        testList.add(string1);
        Object result = testList.remove();
        assertEquals(string1, result);
    }

    @Test
    public void remove_validContents_sizeDecrements() {
        ListInterface testList = GetList();
        String string1 = "ABC";
        testList.add(string1);
        int oldSize = testList.size();
        testList.remove();
        int newSize = testList.size();
        assertEquals(oldSize - 1, newSize);
    }

    @Test
    public void remove_validContentsSizeOne_isEmpty() {
        ListInterface testList = GetList();
        String string1 = "ABC";
        testList.add(string1);
        testList.remove();
        assertTrue(testList.isEmpty());
    }

    @Test
    public void remove_emptyList_isEmpty() {
        ListInterface testList = GetList();
        testList.remove();
        assertTrue(testList.isEmpty());
    }

    @Test
    public void remove_emptyList_returnsNull() {
        ListInterface testList = GetList();
        Object result = testList.remove();
        assertNull(result);

    }
    
    // remove(int index)
    @Test
    public void remove_validIndex_returnsEntry() {
        ListInterface testList = GetList();
        String string1 = "ABC";
        testList.add(string1);
        Object result = testList.remove(0);
        assertEquals(string1, result);
    }

    @Test
    public void remove_validIndex_sizeDecrements() {
        ListInterface testList = GetList();
        String string1 = "ABC";
        testList.add(string1);
        int oldSize = testList.size();
        testList.remove(0);
        int newSize = testList.size();
        assertEquals(oldSize - 1, newSize);

    }

    @Test
    public void remove_validIndexSizeOne_isEmpty() {
        ListInterface testList = GetList();
        String string1 = "ABC";
        testList.add(string1);
        testList.remove(0);
        assertTrue(testList.isEmpty());
    }

    @Test
    public void remove_emptyListPassedIndex_returnsNull() {
        ListInterface testList = GetList();
        Object result = testList.remove(0);
        assertNull(result);

    }

    @Test
    public void remove_outOfBoundsIndex_returnNull() {
        ListInterface testList = GetList();
        int badIndex = ListInterface.DEFAULT_CAPACITY + 1;
        String string1 = "ABC";
        testList.add(string1);
        Object result = testList.remove(badIndex);
        assertNull(result);
    }

    @Test
    public void remove_outOfBoundsIndex_sameSize() {
        ListInterface testList = GetList();
        int badIndex = ListInterface.DEFAULT_CAPACITY + 1;
        String string1 = "ABC";
        testList.add(string1);
        int oldSize = testList.size();
        testList.remove(badIndex);
        int newSize = testList.size();
        assertEquals(oldSize, newSize);
    }

    @Test
    public void remove_negativeIndex_returnNull() {
        ListInterface testList = GetList();
        String string1 = "ABC";
        testList.add(string1);
        Object result = testList.remove(-1);
        assertNull(result);
    }

    @Test
    public void remove_negativeIndex_sameSize() {
        ListInterface testList = GetList();
        String string1 = "ABC";
        testList.add(string1);
        int oldSize = testList.size();
        testList.remove(-1);
        int newSize = testList.size();
        assertEquals(oldSize, newSize);
    }

    // replace:
    @Test
    public void replace_validIndexValidEntry_returnsTrue() {
        ListInterface testList = GetList();
        String oldValue = "ABC";
        testList.add(oldValue);
        String newValue = "XYZ";
        boolean result = testList.replace(0, newValue);
        assertTrue(result);
    }

    @Test
    public void replace_validIndexValidEntry_sameSize() {
        ListInterface testList = GetList();
        String oldValue = "ABC";
        testList.add(oldValue);
        String newValue = "XYZ";
        int oldSize = testList.size();
        testList.replace(0, newValue);
        int newSize = testList.size();
        assertEquals(oldSize, newSize);

    }

    @Test
    public void replace_validIndexValidEntry_oldValueGone() {
        ListInterface testList = GetList();
        String oldValue = "ABC";
        testList.add(oldValue);
        String newValue = "XYZ";
        testList.replace(0, newValue);
        assertFalse(testList.contains(oldValue));
    }

    @Test
    public void replace_validIndexValidEntry_newValuePresent() {
        ListInterface testList = GetList();
        String oldValue = "ABC";
        testList.add(oldValue);
        String newValue = "XYZ";
        testList.replace(0, newValue);
        assertTrue(testList.contains(newValue));
    }

    @Test
    public void replace_outOfBoundsIndex_returnsFalse() {
        ListInterface testList = GetList();
        int badIndex = ListInterface.DEFAULT_CAPACITY;
        String oldValue = "ABC";
        testList.add(oldValue);
        String newValue = "XYZ";
        boolean result = testList.replace(badIndex, newValue);
        assertFalse(result);

    }

    @Test
    public void replace_outOfBoundsIndex_oldValuePresent() {
        ListInterface testList = GetList();
        int badIndex = ListInterface.DEFAULT_CAPACITY;
        String oldValue = "ABC";
        testList.add(oldValue);
        String newValue = "XYZ";
        testList.replace(badIndex, newValue);
        assertTrue(testList.contains(oldValue));
    }

    @Test
    public void replace_negativeIndex_returnsFalse() {
        ListInterface testList = GetList();
        String oldValue = "ABC";
        testList.add(oldValue);
        String newValue = "XYZ";
        boolean result = testList.replace(-1, newValue);
        assertFalse(result);

    }

    @Test
    public void replace_negativeIndex_oldValuePresent() {
        ListInterface testList = GetList();
        String oldValue = "ABC";
        testList.add(oldValue);
        String newValue = "XYZ";
        testList.replace(-1, newValue);
        assertTrue(testList.contains(oldValue));
    }

    @Test
    public void replace_nullEntry_returnsFalse() {
        ListInterface testList = GetList();
        String oldValue = "ABC";
        testList.add(oldValue);
        String newValue = null;
        boolean result = testList.replace(0, newValue);
        assertFalse(result);
    }

    @Test
    public void replace_nullEntry_oldValuePresent() {
        ListInterface testList = GetList();
        String oldValue = "ABC";
        testList.add(oldValue);
        String newValue = null;
        testList.replace(0, newValue);
        assertTrue(testList.contains(oldValue));
    }

    @Test
    public void replace_isEmpty_returnsFalse() {
        ListInterface testList = GetList();
        String newValue = "XYZ";
        boolean result = testList.replace(0, newValue);
        assertFalse(result);
    }

    @Test
    public void clear_contents_bagIsEmpty() {
        ListInterface testList = GetList();
        String string = "ABC";
        testList.add(string);
        testList.clear();
        assertTrue(testList.isEmpty());
    }

    @Test
    public void clear_contents_sizeEqualsZero() {
        ListInterface testList = GetList();
        String string = "ABC";
        testList.add(string);
        testList.clear();
        assertEquals(0, testList.size());
    }

// swap:
    // size says the same
    // both ints need to be different
    // both ints cannot be the same
    // doesn't work on an empty bag
    // doesn't work on 1 element
    /*
     @Test
     public void swap_invalidIndex_Entry1Present() {
     ListInterface testList = GetList();

     }

     @Test
     public void swap_invalidIndex_Entry2Present() {
     ListInterface testList = GetList();

     }

     @Test
     public void swap_invalidIndex_returnFalse() {
     ListInterface testList = GetList();

     }

     @Test
     public void swap_sameIndices_returnsFalse() {
     ListInterface testList = GetList();

     }

     @Test
     public void swap_emptyList_returnsFalse() {
     ListInterface testList = GetList();

     }

     @Test
     public void swap_sizeOne_returnsFalse() {
     ListInterface testList = GetList();

     }

     @Test
     public void swap_validIndices_returnTrue() {
     ListInterface testList = GetList();

     }

     @Test
     public void swap_validIndices_valueSwapped() {
     ListInterface testList = GetList();

     }

     @Test
     public void swap_validIndices_sameSize() {
     ListInterface testList = GetList();

     }

    
     */
}
