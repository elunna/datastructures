package adts;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author lunatunez
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    
// FINISHED:
//    
    adts.Bag_Array_Tests.class,         //equals
    adts.Bag_Linked_Tests.class,        //equals
    adts.Bag_ResizeableArray_Tests.class,//equals

    adts.Set_Array_Tests.class,         //equals
    adts.Set_Linked_Tests.class,        //equals
    adts.Set_Vector_Tests.class,        //equals

    adts.List_Array_Tests.class,        //equals
    adts.List_Linked_Tests.class,       //equals
    adts.List_LinkedTail_Tests.class,   //equals
    adts.List_ArrayList_Tests.class,    //equals
    adts.List_Vector_Tests.class,       //equals

    
    adts.Stack_Array_Tests.class,
    adts.Stack_Linked_Tests.class,
    adts.Stack_Vector_Tests.class,
////    
    adts.Queue_Linked_Test.class,
    adts.Queue_Vector_Test.class,
    adts.Queue_CircularArray_Test.class,
    adts.Queue_CircularLinked_Test.class,
    adts.Queue_2PartCircular_Tests.class,
    
    adts.Deque_DoublyLinked_Tests.class,
//    
    
//    IN PROGRESS:
   
    
    
}
)

public class TestSuite {

}
