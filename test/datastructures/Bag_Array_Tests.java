package datastructures;

import datastructures.Bag_Array;
import datastructures.BagInterface;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 * Tests for the Bag_Array class
 * @author Erik Lunna
 */
public class Bag_Array_Tests extends Bag_Base_Tests {

    @Override
    protected BagInterface GetBag() {
        return new Bag_Array<>();
    }

    /**
     * Returns a full 3-element bag.
     *
     * @return the bag.
     */
    protected BagInterface GetFullBag() {
        BagInterface<String> bag = new Bag_Array<>(3);
        bag.add("A");
        bag.add("B");
        bag.add("C");
        return bag;
    }

    protected BagInterface GetBag(int capacity) {
        return new Bag_Array<>(capacity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newBag_0Capacity_throwsException() {
        BagInterface testBag = GetBag(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newBag_negativeCapacity_throwsException() {
        BagInterface testBag = GetBag(-1);
    }

    @Test
    public void isFull_usingFullBag_returnsTrue() {
        BagInterface testBag = GetFullBag();

        boolean result = true;
        boolean expResult = testBag.isFull();
        assertEquals(expResult, result);
    }

    @Test
    public void add_validToFullBag_returnsFalse() {
        BagInterface testBag = GetFullBag();

        boolean result = false;
        boolean expResult = testBag.add("D");
        assertEquals(expResult, result);
    }

    @Override
    public String toString() {
        return "Bag_Array_Tests";
    }
}
