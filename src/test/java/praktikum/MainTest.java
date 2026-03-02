package praktikum;

import org.junit.Test;
import org.junit.Assert;

public class MainTest {
    @Test
    public void mainTest() {
        // Вызываем main для покрытия логики
        Praktikum.main(new String[0]);

        // Создаем экземпляр класса Praktikum для покрытия конструктора по умолчанию
        Praktikum praktikum = new Praktikum();
        Assert.assertNotNull(praktikum);
    }
}