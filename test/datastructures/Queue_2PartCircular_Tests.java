package datastructures;

/**
 * Tests for Queue_2PartCircular.
 *
 * @author Erik Lunna
 */
public class Queue_2PartCircular_Tests extends Queue_Base_Tests {

    @Override
    protected QueueInterface GetQueue() {
        return new Queue_2PartCircular();
    }
}
