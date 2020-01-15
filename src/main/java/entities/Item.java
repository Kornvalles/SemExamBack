package entities;

import dto.ItemDTO;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mikkel
 */
@Entity
@Table(name = "item")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int itemId;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "cost_per_kilo")
    private double costPerKilo;
    
    public Item() {
    }

    public Item(String name, double costPerKilo) {
        this.name = name;
        this.costPerKilo = costPerKilo;
    }
    
    public Item(ItemDTO item) {
        this.itemId = item.getId();
        this.name = item.getName();
        this.costPerKilo = item.getCostPerKilo();
    }
    
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCostPerKilo() {
        return costPerKilo;
    }

    public void setCostPerKilo(double costPerKilo) {
        this.costPerKilo = costPerKilo;
    }

//    public Storage getStorage() {
//        return storage;
//    }
//
//    public void setStorage(Storage storage) {
//        this.storage = storage;
//    }
    
}
