package adts;

/**
 * File: 
 * Description:
 *
 * @author lunatunez
 */
public class Stack_Vector_Tests extends Stack_Base_Tests {

    @Override
    protected StackInterface GetStack() {
        return new Stack_Vector<>();
    }
}
