package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTest {
    @Test
    public void ingredientTypeTest() {
        Assert.assertEquals("SAUCE", IngredientType.SAUCE.name());
        Assert.assertEquals("FILLING", IngredientType.FILLING.name());
    }
}