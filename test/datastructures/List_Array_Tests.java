package datastructures;

import datastructures.ListInterface;
import datastructures.List_Array;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Tests for List_Array.
 *
 * @author Erik Lunna
 */
public class List_Array_Tests extends List_Base_Tests {

    @Override
    protected ListInterface GetList() {
        return new List_Array<>();
    }

    protected ListInterface GetList(int capacity) {
        return new List_Array<>(capacity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newList_zeroCapacity_throwException() {
        List_Array<String> testList = (List_Array) GetList(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newList_negativeCapacity_throwException() {
        List_Array<String> testList = (List_Array) GetList(-1);
    }

    @Test
    public void isFull_usingFullList_returnsTrue() {
        List_Array<String> testList = (List_Array) GetList(3);
        testList.add("A");
        testList.add("B");
        testList.add("C");
        Assert.assertTrue(testList.isFull());
    }
}
