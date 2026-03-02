package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class DatabaseTest {

    @Test
    public void databaseHasBunsAndIngredients() {
        Database database = new Database();

        // Проверяем, что список булок не пустой
        Assert.assertFalse("Список булок пуст", database.availableBuns().isEmpty());

        // Проверяем, что список ингредиентов не пустой
        Assert.assertFalse("Список ингредиентов пуст", database.availableIngredients().isEmpty());
    }
    @Test
    public void databaseConstructorTest() {
        Database db = new Database();
        Assert.assertNotNull(db);
    }
}