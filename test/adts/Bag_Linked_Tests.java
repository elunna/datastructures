package adts;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author lunatunez
 */
public class Bag_Linked_Tests extends Bag_Base_Tests {

    @Override
    protected BagInterface GetBag() {
        // Note: We don't care about a size, the constructor for Bag_Linked
        // doesn't take an arg.
        return new Bag_Linked<>();
    }

    @Override
    public String toString() {
        return "LinkedBagTests";
    }

    @Test
    @Override
    public void toArray_copy3Elements_elementsMatch() {
        BagInterface testBag = GetBag();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        Object[] testReturnArray = testBag.toArray();
        assertEquals("C", testReturnArray[0]);
        assertEquals("B", testReturnArray[1]);
        assertEquals("A", testReturnArray[2]);
    }

}
