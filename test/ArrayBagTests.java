
import adts.ArrayBag;
import adts.BagInterface;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author lunatic007
 */
public class ArrayBagTests extends BaseBagTests {

    
    
    @Override
    protected BagInterface<String> GetBag() {
        return new ArrayBag<>();
    }

    
    
    @Override
    protected BagInterface GetBag(int capacity) {
        return new ArrayBag<>(capacity);
    }

    
    
    @Test
    public void newBag_zeroCapacity_makesEmptyBag() {
//        BagInterface testBag = GetBag();
        ArrayBag<String> testBag = (ArrayBag) GetBag();
        Assert.assertEquals(0, testBag.getSize());
    }

    
    
    @Test
    public void isFull_usingFullBag_returnsTrue() {
//        BagInterface testBag = GetBag(3);
        ArrayBag<String> testBag = (ArrayBag) GetBag(3);
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        Assert.assertTrue(testBag.isFull());
    }

    
    
    @Test
    public void add_passingValidToFullBag_returnsFalse() {
//        BagInterface testBag = GetBag(3);
        ArrayBag<String> testBag = (ArrayBag) GetBag(3);
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        boolean addSucceeded = testBag.add("D");
        Assert.assertTrue(!addSucceeded);
    }

    
    
    @Test
    public void newBag_negativeCapacity_makesEmptyBag() {

//        BagInterface testBag = GetBag(-1);
        ArrayBag<String> testBag = (ArrayBag) GetBag(-1);
        Assert.assertEquals(0, testBag.getSize());
    }

    
    
    @Override
    public String toString() {
        return "LinkedBagTests";
    }

}
