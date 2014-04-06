package adts;

/**
 * File: Description:
 *
 * @author lunatunez
 */
public class Set_Linked_Tests extends Set_Base_Tests {

    @Override
    protected SetInterface GetSet() {
        return new Set_Linked<>();
    }

}
