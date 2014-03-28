package adts;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * File: 
 * Description: Abstract test driver class pattern.
 *
 * @author lunatunez
 */
public abstract class Bag_BaseTests {

    /**
     *
     * @return a Bag extending the BagInterface of initialized capacity
     */
    // protected abstract BagInterface GetBag(int capacity);
    protected abstract BagInterface GetBag(); // empty bag

    @Test
    public void isEmpty_newBag_returnsTrue() {
        BagInterface testBag = GetBag();
        System.out.println(testBag.toString()
                + ": isEmpty_newBag_returnsTrue");
        assertTrue(testBag.isEmpty());
    }

    // what does this test accomplish?
//    @Test
//    public void isFull_onEmptyBag_returnsFalse() {
//        BagInterface testBag = GetBag();
//        System.out.println(testBag.toString()
//                + ": ");
//        assertTrue(!testBag.isFull());
//    }

    @Test
    public void add_validEntry_sizeEqualsOne() {
        BagInterface testBag = GetBag();
        System.out.println(testBag.toString()
                + ": add_validEntry_sizeEqualsOne");
        String string1 = "ABCDE";
        testBag.add(string1);
        assertEquals(1, testBag.getSize());
    }

    @Test
    public void add_validEntry_isNotEmpty() {
        BagInterface testBag = GetBag();
        System.out.println(testBag.toString()
                + ": add_validEntry_isNotEmpty");
        String string1 = "ABCDE";
        testBag.add(string1);
        assertTrue(!testBag.isEmpty());
    }
    
    @Test
    public void remove_oneEntry_sizeIsZero() {
        BagInterface testBag = GetBag();
        System.out.println(testBag.toString()
                + ": remove_oneEntry_sizeIsZero");
        String string1 = "ABCDE";
        testBag.add(string1);
        testBag.remove();
        assertEquals(0, testBag.getSize());
    }

    @Test
    public void remove_oneEntry_isEmpty() {
        BagInterface testBag = GetBag();
        System.out.println(testBag.toString()
                + ": remove_oneEntry_isEmpty");
        String string1 = "ABCDE";
        testBag.add(string1);
        testBag.remove();
        assertTrue(testBag.isEmpty());
    }
    


    @Test
    public void add_NullToBag_returnsFalse() {
        BagInterface testBag = GetBag();
        System.out.println(testBag.toString()
                + ": add_NullToBag_returnsFalse");
        boolean success = testBag.add(null);
        assertTrue(!success);
    }

    @Test
    public void add_nullToEmptyBag_bagIsEmpty() {
        BagInterface testBag = GetBag();
        System.out.println(testBag.toString()
                + ": add_nullToEmptyBag_bagIsEmpty");
        testBag.add(null);
        assertTrue(testBag.isEmpty());
    }

    @Test
    public void toArray_copyElements_correctSize() {
        BagInterface testBag = GetBag();
        System.out.println(testBag.toString()
                + ": toArray_copyElements_correctSize");
        int numberOfElements = 3;
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        Object[] testReturnArray = testBag.toArray();
        assertEquals(numberOfElements, testReturnArray.length);
    }

    @Test
    public void toArray_copy3Elements_elementsMatch() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        Object[] testReturnArray = testBag.toArray();
        assertEquals("A", testReturnArray[0]);
        assertEquals("B", testReturnArray[1]);
        assertEquals("C", testReturnArray[2]);
    }

    @Test
    public void toArray_emptyBag_returnsEmptyArray() {
        // The bag should go ahead and return an array size 0.
        BagInterface testBag = GetBag();
        Object[] testReturnArray;
        testReturnArray = testBag.toArray();
        assertEquals(0, testReturnArray.length);
    }

    @Test
    public void clear_bagWithContents_bagIsEmpty() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.clear();
        assertTrue(testBag.isEmpty());
    }

    @Test
    public void clear_bagWithContents_sizeEqualsZero() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.clear();
        assertEquals(0, testBag.getSize());
    }
    @Test
    public void contains_usingEmptyBag_returnsFalse() {
        BagInterface testBag = GetBag();
        assertEquals(false, testBag.contains("A"));
    }

    @Test
    public void contains_valueIsInBag_returnsTrue() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        assertTrue(testBag.contains("A"));
    }

    @Test
    public void contains_valueIsMissing_returnsFalse() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        assertTrue(!testBag.contains("D"));
    }

    @Test
    public void contains_searchingForNull_returnsFalse() {
        // This should return false, since you can't search for 'nothing'
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        assertEquals(false, testBag.contains(null));
    }

    
    @Test
    public void getFrequencyOf_oneElementMatch_returnsOne() {
        BagInterface testBag = GetBag();

//        Bag_Array<String> testBag = new Bag_Array<>(3);
        String targetString = "A";
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        int count = testBag.getFrequencyOf(targetString);
        assertEquals(1, count);
    }

    @Test
    public void getFrequencyOf_noElementMatch_returnsZero() {
        Bag_Array<String> testBag = new Bag_Array<>();
        String targetString = "D";
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        int count = testBag.getFrequencyOf(targetString);
        assertEquals(0, count);
    }

}
