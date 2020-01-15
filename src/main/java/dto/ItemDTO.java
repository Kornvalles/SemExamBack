package dto;

import entities.Item;

/**
 *
 * @author mikkel
 */
public class ItemDTO {
    
    private final int id;
    private final String name;
    private final double costPerKilo;
    
    public ItemDTO(Item item) {
        this.id = item.getItemId();
        this.name = item.getName();
        this.costPerKilo = item.getCostPerKilo();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCostPerKilo() {
        return costPerKilo;
    }
    
}
