/*
 *  Queue tests

 */

package adts;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lunatunez
 */
public class Queue_LinkedTest {
   
    public Queue_LinkedTest() {
    }
    
    /**
     * Test of enqueue method, of class Queue_Linked.
     */
    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
        Object newEntry = null;
        Queue_Linked instance = new Queue_Linked();
        instance.enqueue(newEntry);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dequeue method, of class Queue_Linked.
     */
    @Test
    public void testDequeue() {
        System.out.println("dequeue");
        Queue_Linked instance = new Queue_Linked();
        Object expResult = null;
        Object result = instance.dequeue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class Queue_Linked.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Queue_Linked instance = new Queue_Linked();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class Queue_Linked.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Queue_Linked instance = new Queue_Linked();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFront method, of class Queue_Linked.
     */
    @Test
    public void testGetFront() {
        System.out.println("getFront");
        Queue_Linked instance = new Queue_Linked();
        Object expResult = null;
        Object result = instance.getFront();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLength method, of class Queue_Linked.
     */
    @Test
    public void testGetLength() {
        System.out.println("getLength");
        Queue_Linked instance = new Queue_Linked();
        int expResult = 0;
        int result = instance.getLength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Override
    public String toString() {
        return "Queue_LinkedTest";
    }
}
