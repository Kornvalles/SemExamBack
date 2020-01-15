package facades;

import entities.Recipe;
import java.util.ArrayList;
import java.util.List;
import utils.EMF_Creator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class RecipeFacadeTest {

    private static EntityManagerFactory EMF;
    private static RecipeFacade FACADE;
    private static List<Recipe> RECIPES = new ArrayList();

    public RecipeFacadeTest() {
    }

    /*   **** HINT **** 
        A better way to handle configuration values, compared to the UNUSED example above, is to store those values
        ONE COMMON place accessible from anywhere.
        The file config.properties and the corresponding helper class utils.Settings is added just to do that. 
        See below for how to use these files. This is our RECOMENDED strategy
     */
    @BeforeAll
    public static void setUpClassV2() {
       EMF = EMF_Creator.createEntityManagerFactory(DbSelector.TEST,Strategy.DROP_AND_CREATE);
       FACADE = RecipeFacade.getRecipeFacade(EMF);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = EMF.createEntityManager();
        Recipe r1 = new Recipe();
        Recipe r2 = new Recipe();
        
        RECIPES.add(r1);
        RECIPES.add(r2);
        
        
        
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Recipe.deleteAllRows").executeUpdate();
            em.persist(r1);
            em.persist(r2);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    @Test
    public void testGetAllRecipes() {
        //Arrange
        int exp = RECIPES.size();
        //Act
        int act = FACADE.getAllRecipes().size();
        //Assert
        assertEquals(exp, act);
    }
    
//    @Test
//    public void testIsSufficientStorage() {
//        //Arrange
//        boolean exp = true;
//        //Act
//        boolean act = FACADE.isSufficientStorage(RECIPES);
//        //Assert
//        assertTrue(act);
//    }

}
