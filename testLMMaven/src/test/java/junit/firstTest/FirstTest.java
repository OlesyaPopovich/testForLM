package junit.firstTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Olesya Popovich
 */

public class FirstTest {
    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/olesya.popovich/chromedriver_win32/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://kostroma.leroymerlin.ru/");

        String title = driver.getTitle();
        Assert.assertEquals("Леруа Мерлен в Костроме – купить товары для строительства, ремонта и обустройства дома по низким ценам", title);

        driver.quit();
    }
}
