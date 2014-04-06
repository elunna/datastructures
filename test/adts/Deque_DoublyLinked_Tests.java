package adts;

/**
 * File:        
 * Description: 
 * @author lunatunez
 */

public class Deque_DoublyLinked_Tests extends Deque_Base_Tests {
    
     @Override
    protected DequeInterface GetDeque() {
        // Note: We don't care about a size, the constructor for Bag_Linked
        // doesn't take an arg.
        return new Deque_DoublyLinked<>();
    }
}
