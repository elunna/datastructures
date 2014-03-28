package adts;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author lunatunez
 */
public class Bag_ResizeableArray_Tests extends Bag_BaseTests {

    @Override
    protected BagInterface<String> GetBag() {
        return new Bag_ResizeableArray<>();
    }

    protected BagInterface<String> GetBag(int capacity) {
        return new Bag_Array<>(capacity);
    }

    @Test
    public void newBag_zeroCapacity_makesEmptyBag() {
//        BagInterface testBag = GetBag();
        Bag_Array<String> testBag = (Bag_Array) GetBag();
        System.out.println(testBag.toString()
                + ": newBag_zeroCapacity_makesEmptyBag");
        Assert.assertEquals(0, testBag.getSize());
    }

    @Test
    public void isFull_usingFullBag_returnsTrue() {
//        BagInterface testBag = GetBag(3);
        Bag_Array<String> testBag = (Bag_Array) GetBag(3);

        System.out.println(testBag.toString()
                + ": isFull_usingFullBag_returnsTrue");
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        Assert.assertTrue(testBag.isFull());
    }

    @Test
    public void add_toFullBag_returnsFalse() {
//        BagInterface testBag = GetBag(3);
        Bag_Array<String> testBag = (Bag_Array) GetBag(3);

        System.out.println(testBag.toString()
                + ": add_toFullBag_returnsFalse");
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        boolean addSucceeded = testBag.add("D");
        Assert.assertTrue(!addSucceeded);
    }

    @Test
    public void newBag_negativeCapacity_makesEmptyBag() {
//        BagInterface testBag = GetBag(-1);
        Bag_Array<String> testBag = (Bag_Array) GetBag(-1);

        System.out.println(testBag.toString()
                + ": newBag_negativeCapacity_makesEmptyBag");
        Assert.assertEquals(0, testBag.getSize());
    }

    @Override
    public String toString() {
        return "Bag_ResizeableArray_Tests";
    }
}