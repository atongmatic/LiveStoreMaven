package livestore;

import java.util.List;

public class LiveStore {
    public static void main (String args []){
        StoreLoader std = new StoreLoader ("mydb1","root","password");
        //std.LoadItems();
       
        List<ItemDTO> items = std.LoadItems();
        
        for (ItemDTO item : items) {
            System.out.println(" ID ==> " + item.getId()
                +" Item Type  = " +item.getType()
                +" Item Size  = " +item.getSize()
                +" Item Color = " + item.getColor()
                +" Item Price = " + item.getPrice()
                +" Item Cost  = " + item.getCost());
           System.out.println("-----------------------");
    }
    }
}
