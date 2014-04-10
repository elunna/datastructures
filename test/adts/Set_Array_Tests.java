package adts;

import junit.framework.Assert;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 * File: Description:
 *
 * @author lunatunez
 */
public class Set_Array_Tests extends Set_Base_Tests {

    @Override
    protected SetInterface GetSet() {
        return new Set_Array<>();
    }

    protected SetInterface GetSet(int capacity) {
        return new Set_Array<>(capacity);
    }

// If a resizeable bag is passed a zero capacity argument,
    // throw an exception.
    @Test(expected = IllegalArgumentException.class)
    public void newSet_zeroCapacity_throwException() {
//        Set_Array<String> testSet = (Set_Array) GetSet(0);
        SetInterface testSet = GetSet(0);

    }

    // If a resizeable bag is passed a negative capacity argument,
    // throw an exception.
    @Test(expected = IllegalArgumentException.class)
    public void newSet_negativeCapacity_throwException() {
//        Set_Array<String> testSet = (Set_Array) GetSet(-1);
        SetInterface testSet = GetSet(-1);

    }

    @Test
    public void isFull_usingFullSet_returnsTrue() {
        // Here we set a custom capacity
//        Set_Array<String> testSet = (Set_Array) GetSet(3);
        SetInterface testSet = GetSet(3);

        testSet.add("A");
        testSet.add("B");
        testSet.add("C");
        Assert.assertTrue(testSet.isFull());
    }

    @Test
    public void isFull_setNotFull_returnsFalse() {
        SetInterface testSet = GetSet();
        testSet.add("testSet");
        assertFalse(testSet.isFull());
    }

}
