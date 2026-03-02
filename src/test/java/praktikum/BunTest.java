package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    @Test
    public void bunGettersTest() {
        Bun bun = new Bun("Булка", 100f);
        Assert.assertEquals("Булка", bun.getName());
        Assert.assertEquals(100f, bun.getPrice(), 0.0f);
    }
}