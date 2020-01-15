package facades;

import dto.RecipeDTO;
import entities.Ingredient;
import entities.Item;
import entities.Recipe;
import entities.Storage;
import entities.WeekMenuPlan;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class RecipeFacade {

    private static RecipeFacade FACADE;
    private static EntityManagerFactory EMF;
    
    //Private Constructor to ensure Singleton
    private RecipeFacade() {
    }
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static RecipeFacade getRecipeFacade(EntityManagerFactory _emf) {
        if (FACADE == null) {
            EMF = _emf;
            FACADE = new RecipeFacade();
        }
        return FACADE;
    }

    private EntityManager getEntityManager() {
        return EMF.createEntityManager();
    }
    
    public void populateDatabase() {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            
            //Items
            Item rice = new Item("Rice",12.0);
            Item carrot = new Item("Carrot",20.9);
            Item onion = new Item("Onion",13.4);
            Item butter = new Item("Butter",45.2);
            Item oil = new Item("Oil",123.34);
            Item chicken = new Item("Chicken",65.2);
            Item lamb = new Item("Lamb",280);
            
            //Ingredients
            Ingredient rice1 = new Ingredient(200, rice);
            Ingredient rice2 = new Ingredient(150, rice);
            Ingredient carrot1 = new Ingredient(80, carrot);
            Ingredient carrot2 = new Ingredient(80, carrot);
            Ingredient onion1 = new Ingredient(50, onion);
            Ingredient onion2 = new Ingredient(30, onion);
            Ingredient butter1 = new Ingredient(60, butter);
            Ingredient butter2 = new Ingredient(40, butter);
            Ingredient oil1 = new Ingredient(30, oil);
            Ingredient oil2 = new Ingredient(15, oil);
            Ingredient chicken1 = new Ingredient(300, chicken);
            Ingredient chicken2 = new Ingredient(250, chicken);
            Ingredient lamb1 = new Ingredient(200, lamb);
            Ingredient lamb2 = new Ingredient(150, lamb);
            
            
//            List<Ingredient> ingredients1 = new ArrayList();
//            ingredients1.add(rice1);
//            ingredients1.add(carrot1);
//            ingredients1.add(onion1);
//            ingredients1.add(butter1);
//            ingredients1.add(oil1);
//            ingredients1.add(chicken1);
//            
//            List<Ingredient> ingredients2 = new ArrayList();
//            ingredients2.add(rice2);
//            ingredients2.add(carrot2);
//            ingredients2.add(onion2);
//            ingredients2.add(butter2);
//            ingredients2.add(oil2);
//            ingredients2.add(chicken2);
            
            //Recipes
            Recipe butterChicken = new Recipe("Butterchicken",2500, "Chicken in oil then cook rice, and add onions and carrots");
            rice1.setRecipe(butterChicken);
            carrot1.setRecipe(butterChicken);
            butter1.setRecipe(butterChicken);
            chicken1.setRecipe(butterChicken);
            Recipe chiliLamb = new Recipe("ChiliLamb",2500, "Chicken in oil then cook rice, and add onions and carrots");
            rice2.setRecipe(chiliLamb);
            onion2.setRecipe(chiliLamb);
            oil2.setRecipe(chiliLamb);
            lamb1.setRecipe(chiliLamb);
            
            List<Recipe> recipes = new ArrayList();
            recipes.add(butterChicken);
            recipes.add(chiliLamb);
            
            //Storages
            Storage storage1 = new Storage();
            storage1.setItem(rice);
            storage1.setAmount(1000);
            Storage storage2 = new Storage();
            storage2.setItem(carrot);
            storage2.setAmount(1000);
            Storage storage3 = new Storage();
            storage3.setItem(onion);
            storage3.setAmount(1000);
            Storage storage4 = new Storage();
            storage4.setItem(butter);
            storage4.setAmount(1000);
            Storage storage5 = new Storage();
            storage5.setItem(oil);
            storage5.setAmount(1000);
            Storage storage6 = new Storage();
            storage6.setItem(chicken);
            storage6.setAmount(1000);
            
            //WeekMenuPlan
            WeekMenuPlan wmp1 = new WeekMenuPlan(1, 2020);
            wmp1.setRecipes(recipes);

            em.persist(storage1);
            em.persist(storage2);
            em.persist(storage3);
            em.persist(storage4);
            em.persist(storage5);
            em.persist(storage6);
            
            em.persist(wmp1);
            
            em.persist(butterChicken);
            em.persist(chiliLamb);
            
            em.persist(rice1);
            em.persist(rice2);
            em.persist(carrot1);
            em.persist(carrot2);
            em.persist(onion1);
            em.persist(onion2);
            em.persist(butter1);
            em.persist(oil1);
            em.persist(oil2);
            em.persist(chicken1);
            em.persist(chicken2);
            em.persist(lamb1);
            em.persist(lamb2);
            
            em.getTransaction().commit();
            
        } finally {
            em.close();
        }
    }
    
    public List<RecipeDTO> getAllRecipes() {
        EntityManager em = getEntityManager();
        try {
            List<Recipe> recipes = em.createNamedQuery("Recipe.findAll").getResultList();
            List<RecipeDTO> result = new ArrayList();
            recipes.forEach((recipe) -> {
                result.add(new RecipeDTO(recipe));
            });
            return result;
        } finally {
            em.close();
        }
    }
    
    public Recipe addRecipe(Recipe recipe) {
        EntityManager em = getEntityManager();
        //Recipe recipe = new Recipe(recipeDTO);
        try {
            em.getTransaction().begin();
            em.persist(recipe);
            em.getTransaction().commit();
            return recipe;
        } finally {
            em.close();
        }
    }
    
//    public boolean isSufficientStorage(List<Recipe> recipes) {
//        boolean res = true;
//        EntityManager em = getEntityManager();
//        try {
//            
//        } finally {
//            em.close();
//        }
//    }

}
