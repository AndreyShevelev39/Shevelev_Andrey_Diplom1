package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsSetsCorrectBun() {
        burger.setBuns(bun);
        Assert.assertEquals("Булка не установилась", bun, burger.bun);
    }

    @Test
    public void addIngredientAddsToList() {
        burger.addIngredient(ingredient1);
        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientReducesListSize() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientChangesOrder() {
        burger.addIngredient(ingredient1); // индекс 0
        burger.addIngredient(ingredient2); // индекс 1
        burger.moveIngredient(0, 1);

        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
        Assert.assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void getPriceCalculatesCorrectTotal() {
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient1.getPrice()).thenReturn(50f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);

        float expectedPrice = 250f; // (100 * 2) + 50
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0.0f);
    }

    @Test
    public void getReceiptReturnsFormattedString() {
        Mockito.when(bun.getName()).thenReturn("Космическая булка");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn("Марсианский соус");
        Mockito.when(ingredient1.getPrice()).thenReturn(50f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);

        String receipt = burger.getReceipt();

        Assert.assertTrue(receipt.contains("Космическая булка"));
        Assert.assertTrue(receipt.contains("Марсианский соус"));
        Assert.assertTrue(receipt.contains("Price: 250,000000"));
    }
}