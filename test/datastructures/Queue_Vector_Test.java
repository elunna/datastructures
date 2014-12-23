package datastructures;

/**
 * Tests for Queue_Vector
 *
 * @author Erik Lunna
 */
public class Queue_Vector_Test extends Queue_Base_Tests {

    @Override
    protected QueueInterface GetQueue() {

        return new Queue_Vector();
    }
}
