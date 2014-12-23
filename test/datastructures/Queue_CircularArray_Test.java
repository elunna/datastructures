package datastructures;

/**
 * Tests for Queue_CircularArray.
 *
 * @author Erik Lunna
 */
public class Queue_CircularArray_Test extends Queue_Base_Tests {

    @Override
    protected QueueInterface GetQueue() {
        return new Queue_CircularArray();
    }
}
