package datastructures;

/**
 * Tests for Deque_DoublyLinked
 *
 * @author Erik Lunna
 */
public class Deque_DoublyLinked_Tests extends Deque_Base_Tests {

    @Override
    protected DequeInterface GetDeque() {
        return new Deque_DoublyLinked<>();
    }
}
