package livestore;

import java.io.Serializable;
import lombok.Data;

@Data
public class ItemDTO implements Serializable{
    private int id;
    private String type;
    private String size;
    private String color;
    private double price;
    private double cost;
    
    /*
public ItemDTO(int id,String type,String size,String color,double price, double cost){
        this.id = id;
        this.type = type;
        this.size = size;
        this.color = color;
        this.price = price;
        this.cost = cost;
    }
*/
    
}
