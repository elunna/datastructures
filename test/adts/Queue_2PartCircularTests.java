package adts;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lunatunez
 */
public class Queue_2PartCircularTests extends BaseQueueTests {

    
    @Override
    protected QueueInterface GetQueue() {

        return new Queue_2PartCircular();
    }

}
