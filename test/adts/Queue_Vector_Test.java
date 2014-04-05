package adts;

/**
 *
 * @author lunatunez
 */
public class Queue_Vector_Test extends Queue_Base_Tests {

    @Override
    protected QueueInterface GetQueue() {

        return new Queue_Vector();
    }
}
