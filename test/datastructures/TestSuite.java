package datastructures;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test suite for datastructures package.
 *
 * @author Erik Lunna
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    // FINISHED:

    datastructures.Bag_Array_Tests.class,
    datastructures.Bag_Linked_Tests.class,
    datastructures.Bag_ResizeableArray_Tests.class,
    datastructures.List_Array_Tests.class,
    datastructures.List_Linked_Tests.class,
    datastructures.List_LinkedTail_Tests.class,
    datastructures.List_ArrayList_Tests.class,
    datastructures.List_Vector_Tests.class,
    datastructures.Stack_Array_Tests.class,
    datastructures.Stack_Linked_Tests.class,
    datastructures.Stack_Vector_Tests.class,
    datastructures.Queue_Linked_Test.class,
    datastructures.Queue_Vector_Test.class,
    datastructures.Queue_CircularArray_Test.class,
    datastructures.Queue_CircularLinked_Test.class,
    datastructures.Queue_2PartCircular_Tests.class,
    datastructures.Deque_DoublyLinked_Tests.class,
    datastructures.MatrixTests.class, 
// IN PROGRESS: // program union, intersection, difference
//    adts.Set_Array_Tests.class, //equals
//    adts.Set_Linked_Tests.class, //equals
//    adts.Set_Vector_Tests.class, //equals
}
)

public class TestSuite {

}
