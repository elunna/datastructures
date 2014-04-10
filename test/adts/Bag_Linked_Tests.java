package adts;

/**
 *
 * @author lunatunez
 */
public class Bag_Linked_Tests extends Bag_Base_Tests {

    @Override
    protected BagInterface GetBag() {
        return new Bag_Linked<>();
    }

    @Override
    public String toString() {
        return "LinkedBagTests";
    }
}
