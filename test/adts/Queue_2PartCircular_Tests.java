package adts;

/**
 *
 * @author lunatunez
 */
public class Queue_2PartCircular_Tests extends Queue_Base_Tests {

    @Override
    protected QueueInterface GetQueue() {
        return new Queue_2PartCircular();
    }
}
