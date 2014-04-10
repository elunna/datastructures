package adts;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lunatunez
 */
public abstract class Queue_Base_Tests {

    /**
     *
     * @return a Queue extending the QueueInterface
     */
    protected abstract QueueInterface GetQueue(); // empty queue

    // *************************************************************************
    // *** STATIC TESTS ********************************************************
    /**
     * Test of ieEmpty method, using a new empty queue, should return true
     */
    @Test
    public void size_emptyQueue_equalsZero() {
        QueueInterface testQueue = GetQueue();
        assertEquals(0, testQueue.size());
    }

    /**
     * Test of isEmpty method, using a queue w/ contents, should return false
     */
    @Test
    public void isEmpty_queueContents_returnsFalse() {
        QueueInterface testQueue = GetQueue();
        String string1 = "ABCDE";
        String string2 = "DEFGH";
        testQueue.enqueue(string1);
        testQueue.enqueue(string2);
        assertFalse(testQueue.isEmpty());
    }

    /**
     * Test of getFront method, adding and removing one valid entry.
     */
    @Test
    public void getFront_oneEntry_resultMatches() {
        QueueInterface testQueue = GetQueue();
        String string = "ABCDE";
        testQueue.enqueue(string);
        // Check for correct casting here.
        Object result = testQueue.getFront();
        assertEquals(string, result);
    }

    /**
     * Test of getFront method, on queue containing multiple entries. Should
     * return the first entry added.
     */
    @Test
    public void getFront_multipleEntries_resultMatches() {
        QueueInterface testQueue = GetQueue();
        String addedFirst = "ABC";
        String addedLast = "DEF";
        testQueue.enqueue(addedFirst);
        testQueue.enqueue(addedLast);

        // Check for correct casting here.
//        Object result = testQueue.getFront();
        String result = (String) testQueue.getFront();
        assertEquals(addedFirst, result);
    }

    /**
     * Test of getFront method, remove from empty dequeue, should return null.
     */
    @Test
    public void getFront_emptyQueue_returnsNull() {
        QueueInterface testQueue = GetQueue();

        // Check for correct casting here.
        Object result = testQueue.getFront();
        assertNull(result);
    }

    // *************************************************************************
    // *** MUTATOR TESTS *******************************************************
    /**
     * Test of enqueue method, test adding a valid element to an empty queue.
     */
    @Test
    public void enqueue_validEntry_sizeIncrements() {
        QueueInterface testQueue = GetQueue();
        int oldSize = testQueue.size();
        
        String string = "ABCDE";
        testQueue.enqueue(string);
        
        int newSize = testQueue.size();
        assertEquals(oldSize + 1, newSize);
    }

    // ************************************************************************
    // *** MUTATOR TESTS *******************************************************
    /**
     * Test of enqueue method, test adding a valid element to an empty queue.
     */
    @Test
    public void enqueue_validEntry_returnsTrue() {
        QueueInterface testQueue = GetQueue();
        String string = "ABCDE";
        boolean result = testQueue.enqueue(string);
        assertTrue(result);
    }

    /**
     * Test of enqueue method, adding a valid element to queue containing an
     * element. Size should equal two.
     */
    @Test
    public void enqueue_existingElement_notAddedToFront() {
        QueueInterface testQueue = GetQueue();
        String front = "ABCDE";
        String back = "DEFGH";
        testQueue.enqueue(front);
        testQueue.enqueue(back);
        assertFalse(testQueue.getFront() == back);
    }

    /**
     * Test of enqueue method, test adding null entry. Queue does not accept
     * null entries, so the queue should still be empty.
     */
    @Test
    public void enqueue_nullEntry_isEmpty() {
        QueueInterface testQueue = GetQueue();
        testQueue.enqueue(null);
        assertTrue(testQueue.isEmpty());
    }

    public void enqueue_nullEntry_sameSize() {
        QueueInterface testQueue = GetQueue();
        int oldSize = testQueue.size();
        testQueue.enqueue(null);
        int newSize = testQueue.size();
        assertEquals(oldSize, newSize);
    }

    /**
     * Test of dequeue method, adding and removing one valid entry.
     */
    @Test
    public void dequeue_validEntry_sizeDecrements() {
        QueueInterface testQueue = GetQueue();
        
        String string = "ABCDE";
        testQueue.enqueue(string);
        int oldSize = testQueue.size();

        testQueue.dequeue();
        int newSize = testQueue.size();
        
        assertEquals(oldSize - 1, newSize);
    }

    /**
     * Test of dequeue method, on queue containing multiple entries. Should
     * return the first entry added.
     */
    @Test
    public void dequeue_existingEntries_returnsFront() {
        QueueInterface testQueue = GetQueue();
        String addedFirst = "ABC";
        String middle = "BBC";
        String addedLast = "DEF";
        testQueue.enqueue(addedFirst);
        testQueue.enqueue(middle);
        testQueue.enqueue(addedLast);

        Object result = testQueue.dequeue();
        assertEquals(addedFirst, result);
    }

    /**
     * Test of dequeue method, remove from empty dequeue, should return null.
     */
    @Test
    public void dequeue_emptyQueue_returnsNull() {
        QueueInterface testQueue = GetQueue();
        Object result = testQueue.dequeue();
        assertNull(result);
    }

    /**
     * Test of clearmethod, using a queue w/ contents, isEmpty should return
     * true
     */
    @Test
    public void clear_contents_isEmpty() {
        QueueInterface testQueue = GetQueue();
        String string1 = "ABCDE";
        String string2 = "DEFGH";
        testQueue.enqueue(string1);
        testQueue.enqueue(string2);
        testQueue.clear();
        assertTrue(testQueue.isEmpty());
    }

    @Test
    public void clear_contents_sizeEqualsZero() {
        QueueInterface testQueue = GetQueue();
        String string1 = "ABCDE";
        String string2 = "DEFGH";
        testQueue.enqueue(string1);
        testQueue.enqueue(string2);
        testQueue.clear();
        assertEquals(0, testQueue.size());
    }

}
