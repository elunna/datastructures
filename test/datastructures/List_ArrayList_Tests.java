package datastructures;

/**
 * Tests for List_ArrayList.
 *
 * @author Erik Lunna
 */
public class List_ArrayList_Tests extends List_Base_Tests {

    @Override
    protected ListInterface GetList() {
        return new List_ArrayList<>();
    }
}
