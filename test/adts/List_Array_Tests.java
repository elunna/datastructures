package adts;

import junit.framework.Assert;
import org.junit.Test;

/**
 * File:        
 * Description: 
 * @author lunatunez
 */

public class List_Array_Tests extends List_Base_Tests {

    @Override
    protected ListInterface GetList() {
        return new List_Array<>();
    }
    
    protected ListInterface GetList(int capacity) {
        return new List_Array<>(capacity);
    }

// If a resizeable bag is passed a zero capacity argument,
    // throw an exception.
    @Test(expected = IllegalArgumentException.class)
    public void newList_zeroCapacity_throwException() {
        List_Array<String> testList = (List_Array) GetList(0);
    }

    // If a resizeable bag is passed a negative capacity argument,
    // throw an exception.
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
