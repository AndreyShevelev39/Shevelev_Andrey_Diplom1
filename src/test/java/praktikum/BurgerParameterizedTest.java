package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    private final float bunPrice;
    private final float ingredientPrice;
    private final float expectedPrice;

    public BurgerParameterizedTest(float bunPrice, float ingredientPrice, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.expectedPrice = expectedPrice;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
    }

    @Parameterized.Parameters(name = "Цена: булка={0}, доп={1} -> итого={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {100f, 200f, 400f},   // (100*2)+200
                {300f, 50f, 650f},    // (300*2)+50
                {0f, 10f, 10f}        // (0*2)+10
        });
    }

    @Test
    public void checkBurgerPrice() {
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Assert.assertEquals(expectedPrice, burger.getPrice(), 0.001f);
    }
}