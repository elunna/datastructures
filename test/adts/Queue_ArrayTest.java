package adts;

/**
 *
 * @author lunatunez
 */
public class Queue_ArrayTest extends BaseQueueTests {

    @Override
    protected QueueInterface GetQueue() {

        return new Queue_Array();
    }
}
