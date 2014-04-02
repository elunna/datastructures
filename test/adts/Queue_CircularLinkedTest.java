package adts;

/**
 *
 * @author lunatunez
 */
public class Queue_CircularLinkedTest extends BaseQueueTests {

    @Override
    protected QueueInterface GetQueue() {

        return new Queue_CircularLinked<>();
    }

    @Override
    public String toString() {
        return "Queue_CircularLinkedTest";
    }
}
