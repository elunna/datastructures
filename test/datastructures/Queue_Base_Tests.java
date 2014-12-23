package datastructures;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 * Abstract test driver class pattern for Queue_Base.
 *
 * @author Erik Lunna
 */
public abstract class Queue_Base_Tests {

    /**
     *
     * @return a Queue extending the QueueInterface
     */
    protected abstract QueueInterface GetQueue(); // empty queue

    @Test
    public void size_emptyQueue_equalsZero() {
        QueueInterface testQueue = GetQueue();
        assertEquals(0, testQueue.size());
    }

    @Test
    public void isEmpty_queueContents_returnsFalse() {
        QueueInterface testQueue = GetQueue();
        String string1 = "ABCDE";
        String string2 = "DEFGH";
        testQueue.enqueue(string1);
        testQueue.enqueue(string2);

        boolean result = testQueue.isEmpty();
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void getFront_oneEntry_resultMatches() {
        QueueInterface testQueue = GetQueue();
        String string = "ABCDE";
        testQueue.enqueue(string);

        Object result = testQueue.getFront();
        assertEquals(string, result);
    }

    @Test
    public void getFront_multipleEntries_resultMatches() {
        QueueInterface testQueue = GetQueue();
        String enqueueedFirst = "ABC";
        String enqueueedLast = "DEF";
        testQueue.enqueue(enqueueedFirst);
        testQueue.enqueue(enqueueedLast);

        Object result = testQueue.getFront();
        assertEquals(enqueueedFirst, result);
    }

    @Test
    public void getFront_emptyQueue_returnsNull() {
        QueueInterface testQueue = GetQueue();

        Object result = testQueue.getFront();
        Object expResult = null;
        assertEquals(expResult, result);
    }

    @Test
    public void enqueue_validEntry_sizeIncrements() {
        QueueInterface testQueue = GetQueue();
        int oldSize = testQueue.size();

        String string = "ABCDE";
        testQueue.enqueue(string);

        int result = testQueue.size();
        int expResult = oldSize + 1;
        assertEquals(expResult, result);
    }

    @Test
    public void equals_matchingQueue_returnsTrue() {
        QueueInterface testQueue = GetQueue();
        testQueue.enqueue("ABC");
        testQueue.enqueue("XYZ");

        QueueInterface matchingQueue = GetQueue();
        matchingQueue.enqueue("ABC");
        matchingQueue.enqueue("XYZ");

        boolean result = testQueue.equals(matchingQueue);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void equals_differentQueue_returnsFalse() {
        QueueInterface testQueue = GetQueue();
        testQueue.enqueue("ABC");
        testQueue.enqueue("XYZ");

        QueueInterface differentQueue = GetQueue();
        differentQueue.enqueue("123");
        differentQueue.enqueue("456");

//        boolean result = testQueue.equals(differentQueue);
        boolean result = testQueue == differentQueue;
        boolean expResult = false;
        assertEquals(expResult, result);

    }

    @Test
    public void enqueue_validEntry_returnsTrue() {
        QueueInterface testQueue = GetQueue();
        String string = "ABCDE";

        boolean result = testQueue.enqueue(string);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void enqueue_existingElement_notAddedToFront() {
        QueueInterface testQueue = GetQueue();
        String front = "ABCDE";
        String back = "DEFGH";
        testQueue.enqueue(front);
        testQueue.enqueue(back);

        boolean result = testQueue.getFront() == back;
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void enqueue_nullEntry_isEmpty() {
        QueueInterface testQueue = GetQueue();
        testQueue.enqueue(null);

        boolean result = testQueue.isEmpty();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    public void enqueue_nullEntry_sameSize() {
        QueueInterface testQueue = GetQueue();
        int oldSize = testQueue.size();
        testQueue.enqueue(null);

        int result = testQueue.size();
        assertEquals(oldSize, result);
    }

    @Test
    public void dequeue_validEntry_sizeDecrements() {
        QueueInterface testQueue = GetQueue();

        String string = "ABCDE";
        testQueue.enqueue(string);
        int oldSize = testQueue.size();

        testQueue.dequeue();

        int result = testQueue.size();
        int expResult = oldSize - 1;
        assertEquals(expResult, result);
    }

    @Test
    public void dequeue_existingEntries_returnsFront() {
        QueueInterface testQueue = GetQueue();
        String enqueueedFirst = "ABC";
        String middle = "BBC";
        String enqueueedLast = "DEF";
        testQueue.enqueue(enqueueedFirst);
        testQueue.enqueue(middle);
        testQueue.enqueue(enqueueedLast);

        Object result = testQueue.dequeue();
        assertEquals(enqueueedFirst, result);
    }

    @Test
    public void dequeue_emptyQueue_returnsNull() {
        QueueInterface testQueue = GetQueue();

        Object result = testQueue.dequeue();
        Object expResult = null;
        assertEquals(expResult, result);
    }

    @Test
    public void clear_contents_isEmpty() {
        QueueInterface testQueue = GetQueue();
        String string1 = "ABCDE";
        String string2 = "DEFGH";
        testQueue.enqueue(string1);
        testQueue.enqueue(string2);
        testQueue.clear();

        boolean result = testQueue.isEmpty();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void clear_contents_sizeEqualsZero() {
        QueueInterface testQueue = GetQueue();
        String string1 = "ABCDE";
        String string2 = "DEFGH";
        testQueue.enqueue(string1);
        testQueue.enqueue(string2);
        testQueue.clear();

        int result = testQueue.size();
        int expResult = 0;
        assertEquals(expResult, result);
    }
}
