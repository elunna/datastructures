package adts;

/**
 *
 * @author lunatunez
 */
public class Bag_Linked_Tests extends Bag_BaseTests {

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

}
