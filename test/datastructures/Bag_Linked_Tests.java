package datastructures;

import datastructures.BagInterface;
import datastructures.Bag_Linked;

/**
 * Tests for Bag_Linked class.
 *
 * @author Erik Lunna
 */
public class Bag_Linked_Tests extends Bag_Base_Tests {

    @Override
    protected BagInterface GetBag() {
        return new Bag_Linked<>();
    }

}
