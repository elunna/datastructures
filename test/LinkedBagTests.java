
import adts.BagInterface;
import adts.LinkedBag;

/**
 *
 * @author lunatunez
 */
public class LinkedBagTests extends BaseBagTests {

    
    @Override
    protected BagInterface<String> GetBag() {
        // Note: We don't care about a size, the constructor for LinkedBag
        // doesn't take an arg.
        return new LinkedBag<>();
    }

    
    
    @Override
    protected BagInterface GetBag(int capacity) {
        // capacity is not supported for LinkedBag
        return GetBag();
    }
    
    
    
    @Override
    public String toString() {
        return "LinkedBagTests";
    }

}
