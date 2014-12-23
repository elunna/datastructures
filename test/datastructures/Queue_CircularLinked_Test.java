package datastructures;

/**
 * Tests for Queue_CircularLinked.
 *
 * @author Erik Lunna
 */
public class Queue_CircularLinked_Test extends Queue_Base_Tests {

    @Override
    protected QueueInterface GetQueue() {
        return new Queue_CircularLinked();
    }

}
