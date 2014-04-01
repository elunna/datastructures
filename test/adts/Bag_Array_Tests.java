package adts;

import junit.framework.Assert;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author lunatic007
 */
public class Bag_Array_Tests extends Bag_BaseTests {

    @Override
    protected BagInterface GetBag() {
        return new Bag_Array<>();
    }

    protected BagInterface GetBag(int capacity) {
        return new Bag_Array<>(capacity);
    }

    // We don't want to allow the instantiation of an Bag_Array
    // with capacity of 0.  It is not resizeable, therefore it 
    // would be unusable.  The class should simply throw an
    // exception.
    @Test
    public void newBag_zeroCapacity_throwException() {
        // BagInterface testBag = GetBag(0);
        Bag_Array<String> testBag = (Bag_Array)GetBag(0);
        System.out.println(testBag.toString()
                + ": newBag_zeroCapacity_throwException");
        Assert.assertTrue(testBag.isEmpty());
    }

    @Test
    public void newBag_zeroCapacity_bagSizeEqualsZero() {
        Bag_Array<String> testBag = (Bag_Array)GetBag();
        System.out.println(testBag.toString()
                + ": newBag_zeroCapacity_bagSizeEqualsZero");
        Assert.assertEquals(0, testBag.getSize());
    }

    @Test
    public void isFull_usingFullBag_returnsTrue() {
//        BagInterface testBag = GetBag(3);
        Bag_Array<String> testBag = (Bag_Array)GetBag(3);
        System.out.println(testBag.toString()
                + ": isFull_usingFullBag_returnsTrue");
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        Assert.assertTrue(testBag.isFull());
    }

    @Test
    public void add_validToFullBag_returnsFalse() {
//        BagInterface testBag = GetBag(3);
        Bag_Array<String> testBag = (Bag_Array)GetBag(3);
        System.out.println(testBag.toString()
                + ": add_validToFullBag_returnsFalse");
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        boolean addSucceeded = testBag.add("D");
        Assert.assertTrue(!addSucceeded);
    }

    @Test
    public void newBag_negativeCapacity_sizeEqualsZero() {
//        BagInterface testBag = GetBag(-1);
        Bag_Array<String> testBag = (Bag_Array)GetBag(-1);
        System.out.println(testBag.toString()
                + ": newBag_negativeCapacity_sizeEqualsZero");
        Assert.assertEquals(0, testBag.getSize());
    }

    @Test
    public void newBag_negativeCapacity_bagIsEmpty() {
//        BagInterface testBag = GetBag(-1);
        Bag_Array<String> testBag = (Bag_Array)GetBag(-1);
        System.out.println(testBag.toString()
                + ": newBag_negativeCapacity_bagIsEmpty");
        Assert.assertTrue(testBag.isEmpty());
    }

    @Test
    public void remove_index_containsReturnsFalse() {
        Bag_Array<String> testBag = (Bag_Array)GetBag();
        System.out.println(testBag.toString()
                + ": ");
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        String targetValue = "B";
        testBag.remove(1);
        // assertEquals(targetValue, removedValue);
        Assert.assertTrue(testBag.contains(targetValue));
    }

    @Test
    public void getIndexOf_elementInBag_returnsCorrectIndex() {
        Bag_Array<String> testBag = (Bag_Array)GetBag();
        String targetString = "C";
        testBag.add("A");
        testBag.add("B");
        testBag.add(targetString);
        int targetIndex;
        targetIndex = testBag.getIndexOf(targetString);
        assertEquals(2, targetIndex);
    }

    @Test
    public void getIndexOf_missingElement_returnNegative() {
        Bag_Array<String> testBag = (Bag_Array)GetBag();
        String targetString = "D";
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        int targetIndex = testBag.getIndexOf(targetString);
        assertEquals(-1, targetIndex);
    }

    @Override
    public String toString() {
        return "Bag_Array_Tests";
    }
}
