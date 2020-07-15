package lm.firstTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Olesya Popovich
 */

public class FirstTest {
    @Test
    public void firstTest() {

//        запуск Webdriver
        System.setProperty("webdriver.chrome.driver", "C:/Users/olesya.popovich/chromedriver_win32/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

//       открываем тестируемое приложение
        driver.get("https://kostroma.leroymerlin.ru/");

//       проверяем название вкладки
        String title = driver.getTitle();
        Assert.assertEquals("Леруа Мерлен в Костроме – купить товары для строительства, ремонта и обустройства дома по низким ценам", title);

//      находим элемент по css селектору
        By elementLocator = By.cssSelector(".basket");
        WebElement element = driver.findElement(elementLocator);

//        нажимаем на элемент
        element.click();

//      ожидание
        new WebDriverWait(driver, 60, 500);

        String titleBasket = driver.getTitle();
        Assert.assertEquals("Корзина – Леруа Мерлен в Костроме", titleBasket);

//        закрывает тестируемое приложение
        driver.quit();
    }

    @Test
    public void secondTest(){
    }
}
