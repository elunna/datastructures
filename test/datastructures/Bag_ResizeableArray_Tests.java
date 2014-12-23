package datastructures;

import datastructures.Bag_ResizeableArray;
import datastructures.BagInterface;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Tests for Bag_ResizeableArray.
 *
 * @author Erik Lunna
 */
public class Bag_ResizeableArray_Tests extends Bag_Base_Tests {

    @Override
    protected BagInterface GetBag() {
        return new Bag_ResizeableArray<>();
    }

    protected BagInterface GetBag(int capacity) {
        return new Bag_ResizeableArray<>(capacity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newBag_zeroCapacity_throwException() {
        Bag_ResizeableArray<String> testBag
                = (Bag_ResizeableArray) GetBag(0);
    }

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