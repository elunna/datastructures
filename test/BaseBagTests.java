
import adts.ArrayBag;
import adts.BagInterface;
import junit.framework.Assert;
import org.junit.Test;

/**
 * File: Description: Abstract test driver class pattern.
 *
 * @author lunatunez
 */
public abstract class BaseBagTests {

    /**
     *
     * @param capacity
     * @return a Bag extending the BagInterface of initialized capacity
     */
    protected abstract BagInterface GetBag(int capacity);

    protected abstract BagInterface GetBag(); // empty

// Should I even be testing the constructors??
    @Test
    public void isEmpty_newBag_returnsTrue() {
        BagInterface testBag = GetBag();
        Assert.assertTrue(testBag.isEmpty());
    }

    @Test
    public void isFull_onEmptyBag_returnsFalse() {
        BagInterface testBag = GetBag();
        Assert.assertTrue(!testBag.isFull());
    }

    @Test
    public void add_passingValidToEmptyBag_returnsTrue() {
        BagInterface testBag = GetBag();
        String string1 = "ABCDE";
        testBag.add(string1);
        Assert.assertEquals(1, testBag.getSize());
    }

    @Test
    public void remove_validString_sizeIsZero() {
        BagInterface testBag = GetBag();
        String string1 = "ABCDE";
        testBag.add(string1);
        testBag.remove();
        Assert.assertEquals(0, testBag.getSize());
    }

    @Test
    public void remove_specificValidElement_elementMatchesRemoved() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        String targetValue = "B";
        String removedValue = testBag.remove(1).toString();
        Assert.assertEquals(targetValue, removedValue);
    }

    @Test
    public void add_NullToEmptyBag_returnsFalse() {
        BagInterface testBag = GetBag();
        boolean success = testBag.add(null);
        Assert.assertTrue(!success);
    }

    @Test
    public void add_NullToEmptyBag_bagIsEmpty() {
        BagInterface testBag = GetBag();
        testBag.add(null);
        Assert.assertTrue(testBag.isEmpty());
    }

    @Test
    public void toArray_copy3Elements_sizeEquals3() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        Object[] testReturnArray = testBag.toArray();
        Assert.assertEquals(3, testReturnArray.length);
    }

    @Test
    public void toArray_copy3Elements_elementsMatch() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        Object[] testReturnArray = testBag.toArray();
        Assert.assertEquals("A", testReturnArray[0]);
        Assert.assertEquals("B", testReturnArray[1]);
        Assert.assertEquals("C", testReturnArray[2]);
    }

    @Test
    public void toArray_emptyBag_makesEmptyBag() {
        // The bag should go ahead and return an array size 0.
        BagInterface testBag = GetBag();
        Object[] testReturnArray;
        testReturnArray = testBag.toArray();
        Assert.assertEquals(0, testReturnArray.length);
    }

    @Test
    public void clear_bagWithContents_bagIsEmpty() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        testBag.clear();
        Assert.assertTrue(testBag.isEmpty());
    }

    @Test
    public void contains_usingEmptyBag_returnsFalse() {
        BagInterface testBag = GetBag();
        Assert.assertEquals(false, testBag.contains("A"));
    }

    @Test
    public void contains_valueIsInBag_returnsTrue() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        Assert.assertTrue(testBag.contains("A"));
    }

    @Test
    public void contains_valueIsMissing_returnsFalse() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        Assert.assertTrue(!testBag.contains("D"));
    }

    @Test
    public void contains_searchingForNullValue_returnsFalse() {
        // This should return false, since a bag can't contain a null.
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        Assert.assertEquals(false, testBag.contains(null));
    }

    @Test
    public void getIndexOf_elementInBag_returnsCorrectIndex() {
        BagInterface testBag = GetBag();
        String targetString = "C";
        testBag.add("A");
        testBag.add("B");
        testBag.add(targetString);
        int targetIndex = testBag.getIndexOf(targetString);
        Assert.assertEquals(2, targetIndex);
    }

    @Test
    public void getIndexOf_missingElement_returnNegative() {
        ArrayBag<String> testBag = new ArrayBag<>(3);
        String targetString = "D";
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        int targetIndex = testBag.getIndexOf(targetString);
        Assert.assertEquals(-1, targetIndex);
    }

    @Test
    public void getFrequencyOf_oneElementMatch_returnsOne() {
        ArrayBag<String> testBag = new ArrayBag<>(3);
        String targetString = "A";
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        int count = testBag.getFrequencyOf(targetString);
        Assert.assertEquals(1, count);
    }

    @Test
    public void getFrequencyOf_noElementMatch_returnsZero() {
        ArrayBag<String> testBag = new ArrayBag<>(3);
        String targetString = "D";
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        int count = testBag.getFrequencyOf(targetString);
        Assert.assertEquals(0, count);
    }

}
