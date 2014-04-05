package adts;

/**
 *
 * @author lunatunez
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
