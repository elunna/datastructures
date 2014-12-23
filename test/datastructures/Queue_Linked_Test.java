package datastructures;

import datastructures.QueueInterface;
import datastructures.Queue_Linked;

/**
 * Tests for Queue_Linked
 *
 * @author Erik Lunna
 */
public class Queue_Linked_Test extends Queue_Base_Tests {

    @Override
    protected QueueInterface GetQueue() {
        return new Queue_Linked();
    }

    @Override
    public String toString() {
        return "Queue_CircularLinkedTest";
    }
}
