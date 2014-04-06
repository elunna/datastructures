package adts;

/**
 * File: Description:
 *
 * @author lunatunez
 */
public class Set_Vector_Tests extends Set_Base_Tests {

    /**
     *
     * @return
     */
    @Override
    protected SetInterface GetSet() {
        return new Set_Vector<>();
    }

}
