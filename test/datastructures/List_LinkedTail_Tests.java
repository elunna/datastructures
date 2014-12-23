package datastructures;

/**
 * Tests for List_LinkedTail
 *
 * @author Erik Lunna
 */
public class List_LinkedTail_Tests extends List_Base_Tests {

    @Override
    protected ListInterface GetList() {
        return new List_LinkedTail<>();
    }
}
