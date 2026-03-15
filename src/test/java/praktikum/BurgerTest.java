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
    private Ingredient sauce; // Исправлено: вместо ingredient1

    @Mock
    private Ingredient filling; // Исправлено: вместо ingredient2

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsSetsCorrectBun() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientAddsToList() {
        burger.addIngredient(sauce);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientReducesListSize() {
        burger.addIngredient(sauce);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientChangesOrder() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(filling, burger.ingredients.get(0));
    }

    @Test
    public void getPriceCalculatesCorrectTotal() {
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(sauce.getPrice()).thenReturn(50f);
        burger.setBuns(bun);
        burger.addIngredient(sauce);

        Assert.assertEquals(250f, burger.getPrice(), 0.0f);
    }

    // Ревьюер просил: один тест - одна проверка. Разделяем getReceipt:

    @Test
    public void getReceiptContainsBunName() {
        Mockito.when(bun.getName()).thenReturn("Космическая булка");
        burger.setBuns(bun);
        Assert.assertTrue(burger.getReceipt().contains("Космическая булка"));
    }

    @Test
    public void getReceiptContainsIngredientName() {
        Mockito.when(bun.getName()).thenReturn("Космическая булка");
        Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(sauce.getName()).thenReturn("Марсианский соус");

        burger.setBuns(bun);
        burger.addIngredient(sauce);

        Assert.assertTrue(burger.getReceipt().contains("Марсианский соус"));
    }

    @Test
    public void getReceiptContainsCorrectPrice() {
        Mockito.when(bun.getName()).thenReturn("Космическая булка");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);

        Assert.assertTrue(burger.getReceipt().contains("Price: 200,000000"));
    }
}