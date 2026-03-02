package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {
    @Test
    public void ingredientGettersTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус", 50f);
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
        Assert.assertEquals("Соус", ingredient.getName());
        Assert.assertEquals(50f, ingredient.getPrice(), 0.0f);
    }
}