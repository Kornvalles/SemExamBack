package dto;

import entities.Recipe;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mikkel
 */
public class RecipeDTO {

    private final int id;
    private final double prepTime;
    private final String direction;
    private String name;
    private List<IngredientDTO> ingredients = new ArrayList();

    public RecipeDTO(Recipe recipe) {
        this.id = recipe.getRecipeId();
        this.name = recipe.getName();
        this.prepTime = recipe.getPrepTime();
        this.direction = recipe.getDirections();
        if (recipe.getIngredients() != null) {
            recipe.getIngredients().forEach((i) -> {
                this.ingredients.add(new IngredientDTO(i));
            });
        }
    }

    public int getId() {
        return id;
    }

    public double getPrepTime() {
        return prepTime;
    }

    public String getDirection() {
        return direction;
    }

    public List<IngredientDTO> getIngredients() {
        return ingredients;
    }
    
}
