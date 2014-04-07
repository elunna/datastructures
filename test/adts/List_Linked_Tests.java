package adts;

/**
 * File:        
 * Description: 
 * @author lunatunez
 */

public class List_Linked_Tests extends List_Base_Tests {

    
    @Override
    protected ListInterface GetList() {
        return new List_Linked<>();
    }
    
}
