package adts;

/**
 *
 * @author lunatunez
 */
public class Queue_VectorTest extends BaseQueueTests {

    @Override
    protected QueueInterface GetQueue() {

        return new Queue_Vector();
    }
}
