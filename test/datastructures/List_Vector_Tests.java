package datastructures;

import datastructures.ListInterface;
import datastructures.List_Vector;

/**
 * Tests for List_Vector.
 *
 * @author Erik Lunna
 */
public class List_Vector_Tests extends List_Base_Tests {

    @Override
    protected ListInterface GetList() {
        return new List_Vector<>();
    }

}
