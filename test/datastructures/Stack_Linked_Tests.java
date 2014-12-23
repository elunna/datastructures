package datastructures;

import datastructures.Stack_Linked;
import datastructures.StackInterface;

/**
 * Tests for Stack_Linked
 *
 * @author Erik Lunna
 */
public class Stack_Linked_Tests extends Stack_Base_Tests {

    @Override
    protected StackInterface GetStack() {
        return new Stack_Linked<>();
    }
}
