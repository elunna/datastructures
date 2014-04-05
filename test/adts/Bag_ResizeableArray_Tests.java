package adts;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author lunatunez
 */
public class Bag_ResizeableArray_Tests extends Bag_Base_Tests {

    @Override
    protected BagInterface GetBag() {
        return new Bag_ResizeableArray<>();
    }

    protected BagInterface GetBag(int capacity) {
        return new Bag_ResizeableArray<>(capacity);
    }

    // If a resizeable bag is passed a zero capacity argument,
    // throw an exception.
    @Test(expected = IllegalArgumentException.class)
    public void newBag_zeroCapacity_throwException() {
        Bag_ResizeableArray<String> testBag
                = (Bag_ResizeableArray) GetBag(0);
    }

    // If a resizeable bag is passed a negative capacity argument,
    // throw an exception.
    @Test(expected = IllegalArgumentException.class)
    public void newBag_negativeCapacity_throwException() {
        Bag_ResizeableArray<String> testBag
                = (Bag_ResizeableArray) GetBag(-1);
    }


    @Test
    public void isFull_bagIsFull_returnsTrue() {
        Bag_ResizeableArray<String> testBag = (Bag_ResizeableArray) GetBag(3);
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        Assert.assertTrue(testBag.isFull());
    }

    /**
     * Addition to a resizeable array should always succeed until disk space
     * isn't available.
     */
    @Test
    public void add_toFullBag_returnsTrue() {
        Bag_ResizeableArray<String> testBag = (Bag_ResizeableArray) GetBag(3);
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        boolean addSucceeded = testBag.add("D");
        Assert.assertTrue(addSucceeded);
    }

    @Override
    public String toString() {
        return "Bag_ResizeableArray_Tests";
    }
}
