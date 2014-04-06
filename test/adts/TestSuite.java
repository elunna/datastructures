package adts;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author lunatunez
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    adts.Bag_Linked_Tests.class,
    adts.Bag_ResizeableArray_Tests.class,
    adts.Bag_Array_Tests.class,

//    adts.Stack_Array_Tests.class,
//    adts.Stack_Linked_Tests.class,
//    adts.Stack_Vector_Tests.class
    
//    adts.Queue_CircularArray_Test.class
//    adts.Queue_Linked_Test.class
//    adts.Queue_Vector_Test.class,
//    adts.Queue_CircularLinked_Test.class
//    adts.Queue_2PartCircular_Tests.class
    
      adts.List_ArrayList_Tests.class
}
)

public class TestSuite {

}
