package adts;

import junit.framework.Assert;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author lunatic007
 */
public class Bag_Array_Tests extends Bag_Base_Tests {

    @Override
    protected BagInterface GetBag() {
        return new Bag_Array<>();
    }

    protected BagInterface GetBag(int capacity) {
        return new Bag_Array<>(capacity);
    }

    // If a resizeable bag is passed a zero capacity argument,
    // throw an exception.
    @Test(expected = IllegalArgumentException.class)
    public void newBag_zeroCapacity_throwException() {
        BagInterface testBag = GetBag(0);
    }

    // If a resizeable bag is passed a negative capacity argument,
    // throw an exception.
    @Test(expected = IllegalArgumentException.class)
    public void newBag_negativeCapacity_throwException() {
        BagInterface testBag = GetBag(-1);
    }

    @Test
    public void isFull_usingFullBag_returnsTrue() {
        BagInterface testBag = GetBag(3);
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        Assert.assertTrue(testBag.isFull());
    }

    @Test
    public void add_validToFullBag_returnsFalse() {
        BagInterface testBag = GetBag(3);
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        boolean addSucceeded = testBag.add("D");
        Assert.assertTrue(!addSucceeded);
    }

    @Test
    public void getIndexOf_elementInBag_returnsCorrectIndex() {
        Bag_Array<String> testBag = (Bag_Array) GetBag();
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
        Bag_Array<String> testBag = (Bag_Array) GetBag();
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
