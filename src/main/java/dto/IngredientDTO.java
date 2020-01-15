package dto;

import entities.Ingredient;

/**
 *
 * @author mikkel
 */
public class IngredientDTO {
    
    private final int id;
    private final double amount;
    private final ItemDTO item;

    public IngredientDTO(Ingredient ingredient) {
        this.id = ingredient.getIngredientId();
        this.amount = ingredient.getAmount();
        this.item = new ItemDTO(ingredient.getItem());
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public ItemDTO getItem() {
        return item;
    }
    
}
