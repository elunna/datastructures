package datastructures;

import datastructures.QueueInterface;
import datastructures.Queue_2PartCircular;

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
