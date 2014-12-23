package datastructures;

import datastructures.QueueInterface;
import datastructures.Queue_CircularLinked;

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

    @Override
    public String toString() {
        return "Queue_CircularLinkedTest";
    }
}
