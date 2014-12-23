package datastructures;

import datastructures.Set_Linked;
import datastructures.SetInterface;

/**
 * Tests for Set_Linked.
 *
 * @author Erik Lunna
 */
public class Set_Linked_Tests extends Set_Base_Tests {

    @Override
    protected SetInterface GetSet() {
        return new Set_Linked<>();
    }
}
