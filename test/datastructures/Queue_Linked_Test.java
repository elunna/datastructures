package datastructures;

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

}
