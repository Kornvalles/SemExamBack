package entities;

import dto.IngredientDTO;
import dto.RecipeDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mikkel
 */
@Entity
@Table(name = "recipe")
@NamedQueries({
    @NamedQuery(name = "Recipe.deleteAllRows", query = "DELETE from Recipe"),
    @NamedQuery(name = "Recipe.findAll", query = "SELECT r FROM Recipe r")        
})
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private int recipeId;
    
    @OneToMany(
            mappedBy = "recipe",
            cascade = CascadeType.PERSIST
    )
    private List<Ingredient> ingredients = new ArrayList();
    
    @Column(name = "name")
    private String name;
    @Column(name = "preptime")
    private double prepTime;
    @Column(name = "directions")
    private String directions;

    public Recipe() {
    }

    public Recipe(String name, double prepTime, String directions) {
        this.name = name;
        this.prepTime = prepTime;
        this.directions = directions;
    }
    
    public Recipe(RecipeDTO recipeDTO) {
        this.directions = recipeDTO.getDirection();
        this.prepTime = recipeDTO.getPrepTime();
        this.ingredients = new ArrayList();
        for (IngredientDTO i : recipeDTO.getIngredients()) {
            this.ingredients.add(new Ingredient(i));
        }
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }
    
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(double prepTime) {
        this.prepTime = prepTime;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.recipeId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recipe other = (Recipe) obj;
        if (this.recipeId != other.recipeId) {
            return false;
        }
        return true;
    }

}
