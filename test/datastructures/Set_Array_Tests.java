package datastructures;

import org.junit.Test;

/**
 * Tests for Set_ResizableArray
 *
 * @author Erik Lunna
 */
public class Set_Array_Tests extends Set_Base_Tests {

    @Override
    protected SetInterface GetSet() {
        return new Set_ResizableArray<>();
    }

    protected SetInterface GetSet(int capacity) {
        return new Set_ResizableArray<>(capacity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newSet_zeroCapacity_throwException() {
        SetInterface testSet = GetSet(0);

    }

    @Test(expected = IllegalArgumentException.class)
    public void newSet_negativeCapacity_throwException() {
        SetInterface testSet = GetSet(-1);
    }
}
