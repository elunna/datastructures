package adts;

/**
 *
 * @author lunatunez
 */
public class Queue_LinkedTest extends BaseQueueTests {

    @Override
    protected QueueInterface GetQueue() {

        return new Queue_Linked();
    }
}
