package adts;

/**
 *
 * @author lunatunez
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
