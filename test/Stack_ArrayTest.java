package adts;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lunatunez
 */
public class Stack_ArrayTest {
    
    public Stack_ArrayTest() {
    }
    
    /**
     * Test of push method, of class Stack_Array.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        Object newEntry = null;
        Stack_Array instance = new Stack_Array();
        instance.push(newEntry);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of peek method, of class Stack_Array.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        Stack_Array instance = new Stack_Array();
        Object expResult = null;
        Object result = instance.peek();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pop method, of class Stack_Array.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        Stack_Array instance = new Stack_Array();
        Object expResult = null;
        Object result = instance.pop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class Stack_Array.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Stack_Array instance = new Stack_Array();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class Stack_Array.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Stack_Array instance = new Stack_Array();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }   
}