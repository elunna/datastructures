package adts;

/**
 * File: Description:
 *
 * @author lunatunez
 */
public class List_Vector_Tests extends List_Base_Tests {

    @Override
    protected ListInterface GetList() {
        return new List_Vector<>();
    }

}
