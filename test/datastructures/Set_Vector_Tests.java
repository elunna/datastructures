package datastructures;

/**
 * Tests for Set_Vector.
 *
 * @author Erik Lunna
 */
public class Set_Vector_Tests extends Set_Base_Tests {

    @Override
    protected SetInterface GetSet() {
        return new Set_Vector<>();
    }
}
