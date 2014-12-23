package datastructures;

import datastructures.List_Linked;
import datastructures.ListInterface;

/**
 * Tests for List_Linked.
 *
 * @author Erik Lunna
 */
public class List_Linked_Tests extends List_Base_Tests {

    @Override
    protected ListInterface GetList() {
        return new List_Linked<>();
    }
}
