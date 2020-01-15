package entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author mikkel
 */
@Entity
@Table(name = "weekmenuplan")
public class WeekMenuPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private int menuId;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
        name = "weekmenu_recipes",
        joinColumns = {
            @JoinColumn(name = "menu_id")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "recipe_id")
        }
    )
    private List<Recipe> recipes;
    @Column(name = "week_no")
    private int weekNo;
    @Column(name = "year_no")
    private int year;

    public WeekMenuPlan() {
    }

    public WeekMenuPlan(int weekNo, int year) {
        this.weekNo = weekNo;
        this.year = year;
    }
    
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public int getWeekNo() {
        return weekNo;
    }

    public void setWeekNo(int weekNo) {
        this.weekNo = weekNo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.menuId;
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
        final WeekMenuPlan other = (WeekMenuPlan) obj;
        if (this.menuId != other.menuId) {
            return false;
        }
        return true;
    }
    
}
