package adts;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lunatunez
 */
public abstract class BaseQueueTests {

    /**
     *
     * @return a Queue extending the QueueInterface
     */
    // protected abstract QueueInterface GetQueue(int capacity);
    protected abstract QueueInterface GetQueue(); // empty queue

    /**
     * Test of ieEmpty method, using a new empty queue, should return true
     */
    @Test
    public void isEmpty_newQueue_returnsTrue() {
        // BagInterface testBag = GetBag();
        QueueInterface testQueue = GetQueue();
        System.out.println(testQueue.toString()
                + ": isEmpty_newQueue_returnsTrue");
        assertTrue(testQueue.isEmpty());
    }

    /**
     * Test of ieEmpty method, using a queue w/ contents, should return false
     */
    @Test
    public void isEmpty_queueContents_returnsFalse() {
        QueueInterface testQueue = GetQueue();
        System.out.println(testQueue.toString()
                + ": isEmpty_queueContents_returnsFalse");
        String string1 = "ABCDE";
        String string2 = "DEFGH";
        testQueue.enqueue(string1);
        testQueue.enqueue(string2);

        assertFalse(testQueue.isEmpty());
    }

    /**
     * Test of enqueue method, test adding a valid element to an empty queue.
     */
    @Test
    public void enqueue_onEmptyQueue_isNotEmpty() {
        QueueInterface testQueue = GetQueue();
        System.out.println(testQueue.toString()
                + ": enqueue_onEmptyQueue_isNotEmpty");
        String string = "ABCDE";
        testQueue.enqueue(string);
        assertFalse(testQueue.isEmpty());
    }

    /**
     * Test of enqueue method, adding a valid element to queue containing an
     * element. Size should equal two.
     */
    @Test
    public void enqueue_existingElement_sizeEqualsTwo() {
        QueueInterface testQueue = GetQueue();
        System.out.println(testQueue.toString()
                + ": enqueue_existingElement_sizeEqualsTwo");
        String string1 = "ABCDE";
        String string2 = "DEFGH";
        testQueue.enqueue(string1);
        testQueue.enqueue(string2);
        assertEquals(2, testQueue.getLength());
    }

    /**
     * Test of enqueue method, adding a valid element to queue containing an
     * element. Added element should be the last in line.
     */
    @Test
    public void enqueue_existingElement_addedIsLast() {
        QueueInterface testQueue = GetQueue();
        System.out.println(testQueue.toString()
                + ": enqueue_existingElement_addedIsLast");
        String addedFirst = "ABCDE";
        String addedLast = "DEFGH";
        testQueue.enqueue(addedFirst);
        testQueue.enqueue(addedLast);
        testQueue.dequeue();
        Object result = testQueue.getFront();

        assertEquals(addedLast, result);
    }

    /**
     * Test of enqueue method, test adding null entry. Queue does not accept
     * null entries, so the queue should still be empty.
     */
    @Test
    public void enqueue_nullEntry_isEmpty() {
        QueueInterface testQueue = GetQueue();
        System.out.println(testQueue.toString()
                + ": enqueue_nullEntry_isEmpty");
        testQueue.enqueue(null);
        assertTrue(testQueue.isEmpty());
    }

    /**
     * Test of dequeue method, adding and removing one valid entry.
     */
    @Test
    public void dequeue_oneEntry_resultMatches() {
        QueueInterface testQueue = GetQueue();
        System.out.println(testQueue.toString()
                + ": dequeue_oneEntry_resultMatches");
        String string = "ABCDE";
        testQueue.enqueue(string);
        // Check for correct casting here.
        Object result = testQueue.dequeue();
        assertEquals(result, string);
    }

    /**
     * Test of dequeue method, on queue containing multiple entries. Should
     * return the first entry added.
     */
    @Test
    public void dequeue_existingEntry_resultMatches() {
        QueueInterface testQueue = GetQueue();
        System.out.println(testQueue.toString()
                + ": dequeue_existingEntry_resultMatches");
        String addedFirst = "ABC";
        String addedLast = "DEF";
        testQueue.enqueue(addedFirst);
        testQueue.enqueue(addedLast);

        // Check for correct casting here.
        Object result = testQueue.dequeue();
        assertEquals(result, addedFirst);
    }

    /**
     * Test of dequeue method, remove from empty dequeue, should return null.
     */
    @Test
    public void dequeue_emptyQueue_returnsNull() {
        QueueInterface testQueue = GetQueue();
        System.out.println(testQueue.toString()
                + ": dequeue_emptyQueue_returnsNull");
        // Check for correct casting here.
        Object result = testQueue.dequeue();
        assertNull(result);
    }

    /**
     * Test of getFront method, adding and removing one valid entry.
     */
    @Test
    public void getFront_oneEntry_resultMatches() {
        QueueInterface testQueue = GetQueue();
        System.out.println(testQueue.toString()
                + ": getFront_oneEntry_resultMatches");
        String string = "ABCDE";
        testQueue.enqueue(string);
        // Check for correct casting here.
        Object result = testQueue.getFront();
        assertEquals(result, string);
    }

    /**
     * Test of getFront method, on queue containing multiple entries. Should return
     * the first entry added.
     */
    @Test
    public void getFront_existingEntry_resultMatches() {
        QueueInterface testQueue = GetQueue();
        System.out.println(testQueue.toString()
                + ": getFront_existingEntry_resultMatches");
        String addedFirst = "ABC";
        String addedLast = "DEF";
        testQueue.enqueue(addedFirst);
        testQueue.enqueue(addedLast);

        // Check for correct casting here.
        Object result = testQueue.getFront();
        assertEquals(result, addedFirst);
    }

    /**
     * Test of getFront method, remove from empty dequeue, should return null.
     */
    @Test
    public void getFront_emptyQueue_returnsNull() {
        QueueInterface testQueue = GetQueue();
        System.out.println(testQueue.toString()
                + ": getFront_emptyQueue_returnsNull");
        // Check for correct casting here.
        Object result = testQueue.getFront();
        assertNull(result);
    }

    /**
     * Test of clearmethod, using a queue w/ contents, 
     * isEmpty should return true
     */
    @Test
    public void clear_contents_isEmpty() {

        QueueInterface testQueue = GetQueue();
        System.out.println(testQueue.toString()
                + ": clear_contents_isEmpty");
        String string1 = "ABCDE";
        String string2 = "DEFGH";
        testQueue.enqueue(string1);
        testQueue.enqueue(string2);
        testQueue.clear();
        assertTrue(testQueue.isEmpty());
    }

    /**
     * Test of getLength method, of class QueueInterface.
     */
    @Test
    public void testGetLength_newQueue_returnsZero() {
        QueueInterface testQueue = GetQueue();
        System.out.println(testQueue.toString()
                + ": testGetLength_newQueue_returnsZero");
        
        assertEquals(0, testQueue.getLength());

    }

}
