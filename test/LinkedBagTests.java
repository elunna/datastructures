/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import adts.LinkedBag;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author lunatunez
 */
public class LinkedBagTests {

    public LinkedBagTests() {
    }

    @Test
    public void isEmpty_newBag_returnsTrue() {
        LinkedBag<String> testBag = new LinkedBag();
        Assert.assertTrue(testBag.isEmpty());
    }

//    @Test
//    public void newBag_negativeCapacity_makesEmptyBag() {
//        LinkedBag<String> testBag = new LinkedBag<>(-1);
//        Assert.assertEquals(0, testBag.getSize());
//    }
//    @Test
//    public void newBag_zeroCapacity_makesEmptyBag() {
//        LinkedBag<String> testBag = new LinkedBag<>(0);
//        Assert.assertEquals(0, testBag.getSize());
//    }
    
    @Test
    public void isFull_anytime_returnsFalse() {
        LinkedBag<String> testBag = new LinkedBag();
        Assert.assertTrue(!testBag.isFull());
    }

//    @Test
//    public void isFull_onEmptyBag_returnsFalse() {
//        LinkedBag<String> testBag = new LinkedBag();
//        Assert.assertTrue(!testBag.isFull());
//    }
// 
//    @Test
//    public void isFull_usingFullBag_returnsTrue() {
//        LinkedBag<String> testBag = new LinkedBag<>(3);
//        testBag.add("A");
//        testBag.add("B");
//        testBag.add("C");
//        Assert.assertTrue(testBag.isFull());
//    }
    
    @Test
    public void add_passingValidToEmptyBag_returnsTrue() {
        LinkedBag<String> testBag = new LinkedBag();
        String string1 = "ABCDE";
        testBag.add(string1);
        Assert.assertEquals(1, testBag.getSize());
    }

    @Test
    public void add_passingValidToFullBag_returnsFalse() {
        LinkedBag<String> testBag = new LinkedBag<>();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        boolean addSucceeded = testBag.add("D");
        Assert.assertTrue(!addSucceeded);
    }

    @Test
    public void remove_validString_sizeIsZero() {
        LinkedBag<String> testBag = new LinkedBag();
        String string1 = "ABCDE";
        testBag.add(string1);
        testBag.remove();
        Assert.assertEquals(0, testBag.getSize());
    }

    @Test
    public void remove_specificValidElement_elementMatchesRemoved() {
        LinkedBag<String> testBag = new LinkedBag<>();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        String targetValue = "B";
        String removedValue = testBag.remove(1);
        Assert.assertEquals(targetValue, removedValue);
    }

    @Test
    public void add_NullStringToEmptyBag_returnsFalse() {
        LinkedBag<String> testBag = new LinkedBag();
        boolean success = testBag.add(null);
        Assert.assertTrue(!success);
    }

    @Test
    public void add_NullStringToEmptyBag_bagIsEmpty() {
        LinkedBag<String> testBag = new LinkedBag();
        testBag.add(null);
        Assert.assertTrue(testBag.isEmpty());
    }

    @Test
    public void toArray_copy3Elements_sizeEquals3() {
        LinkedBag<String> testBag = new LinkedBag<>();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        Object[] testReturnArray = testBag.toArray();
        Assert.assertEquals(3, testReturnArray.length);
    }

    @Test
    public void toArray_copy3Elements_elementsMatch() {
        LinkedBag<String> testBag = new LinkedBag<>();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        Object[] testReturnArray = testBag.toArray();
        Assert.assertEquals("A", testReturnArray[0]);
        Assert.assertEquals("B", testReturnArray[1]);
        Assert.assertEquals("C", testReturnArray[2]);
    }

    @Test
    public void toArray_emptyBag_makesEmptyBag() {
        // The bag should go ahead and return an array size 0.
        LinkedBag<String> testBag = new LinkedBag<>();
        Object[] testReturnArray;
        testReturnArray = testBag.toArray();
        Assert.assertEquals(0, testReturnArray.length);
    }

    @Test
    public void clear_bagWithContents_bagIsEmpty() {
        LinkedBag<String> testBag = new LinkedBag<>();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        testBag.clear();
        Assert.assertTrue(testBag.isEmpty());
    }

    @Test
    public void contains_usingEmptyBag_returnsFalse() {
        LinkedBag<String> testBag = new LinkedBag<>();
        Assert.assertEquals(false, testBag.contains("A"));
    }

    @Test
    public void contains_valueIsInBag_returnsTrue() {
        LinkedBag<String> testBag = new LinkedBag<>();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        Assert.assertTrue(testBag.contains("A"));
    }

    @Test
    public void contains_valueIsMissing_returnsFalse() {
        LinkedBag<String> testBag = new LinkedBag<>();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        Assert.assertTrue(!testBag.contains("D"));
    }

    @Test
    public void contains_searchingForNullValue_returnsFalse() {
        // This should return false, since a bag can't contain a null.
        LinkedBag<String> testBag = new LinkedBag<>();
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        Assert.assertEquals(false, testBag.contains(null));
    }

    @Test
    public void getIndexOf_elementInBag_returnsCorrectIndex() {
        LinkedBag<String> testBag = new LinkedBag<>();
        String targetString = "C";
        testBag.add("A");
        testBag.add("B");
        testBag.add(targetString);
        int targetIndex = testBag.getIndexOf(targetString);
        Assert.assertEquals(2, targetIndex);
    }

    @Test
    public void getIndexOf_missingElement_returnNegative() {
        LinkedBag<String> testBag = new LinkedBag<>();
        String targetString = "D";
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        int targetIndex = testBag.getIndexOf(targetString);
        Assert.assertEquals(-1, targetIndex);
    }

    @Test
    public void getFrequencyOf_oneElementMatch_returnsOne() {
        LinkedBag<String> testBag = new LinkedBag<>();
        String targetString = "A";
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        int count = testBag.getFrequencyOf(targetString);
        Assert.assertEquals(1, count);
    }

    @Test
    public void getFrequencyOf_noElementMatch_returnsZero() {
        LinkedBag<String> testBag = new LinkedBag<>();
        String targetString = "D";
        testBag.add("A");
        testBag.add("B");
        testBag.add("C");
        int count = testBag.getFrequencyOf(targetString);
        Assert.assertEquals(0, count);
    }
}
