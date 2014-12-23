package datastructures;

/**
 * Tests for Stack_Vector.
 *
 * @author Erik Lunna
 */
public class Stack_Vector_Tests extends Stack_Base_Tests {

    @Override
    protected StackInterface GetStack() {
        return new Stack_Vector<>();
    }
}
