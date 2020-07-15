package integrationtests.cucumbers.lMCreateOrder;

import com.codeborne.selenide.*;
import com.google.common.base.Predicate;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.annotation.Nullable;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.tagName;


/**
 * Created by Olesya Popovich
 */

public class LMCreateOrder {

    WebDriver webDriver;

    @Given("^Запускаем браузер и входим на сайт LeroyMerlin$")
    public void openLeroyMerlin() {
        Configuration.timeout = 30_000;
        open("https://kostroma.leroymerlin.ru/");
    }

    @Given("^Запускаем браузер и входим на сайт LeroyMerlin \"(.*)\"$")
    public void openLMWithRegion(String region) {
        Configuration.timeout = 30_000;
        open("http://" + region + ".leroymerlin.ru/");
    }

    @Then("^Отображается название вкладки сайта LeroyMerlin \"(.*)\"$")
    public void titleName(String nameTitle) {
        Selenide.sleep(3000);
        Assert.assertEquals(title(), nameTitle);
    }

    @Then("^Отображается поп-ап смены региона \"(.*)\"$")
    public void popoverContent(String region) {
        SelenideElement popover = $(".popover-content").shouldHave(Condition.exist, Condition.visible);
        SelenideElement popoverName = popover.$(".confirm-region-text").$(".region-name");
        Assert.assertEquals(popoverName.getText(), region);
    }

    @When("^Нажимаем кнопку \"(.*)\" поп-апе смены гериона$")
    public void editContent(String nameButton) {
        SelenideElement popover = $(".popover-content");
        SelenideElement buttonName = popover.$$(".green-button").filter(Condition.exactText(nameButton)).get(0);
        buttonName.hover().doubleClick();
    }

    @Then("^Отображается регион \"(.*)\"$")
    public void nameRegion(String region) {
        SelenideElement header = $(".header-panel-row");
        SelenideElement regionPanel = header.$(".reg-location");
        SelenideElement regionName = regionPanel.$$("a").filterBy(Condition.visible).get(0);
        Assert.assertEquals(regionName.getText(), region);
    }

    @When("^Открываем каталог товаров по первому видимому баннеру$")
    public void openCatalog() {
        SelenideElement buttonCatalog =$(".root-banner").$$(".banner-with-position").get(0);
        buttonCatalog.hover().doubleClick();
    }

    @Then("^Отображается название страницы каталога \"(.*)\"$")
    public void catalogTitle(String catalogNameTitle) {
        Selenide.sleep(3000);
        SelenideElement pageTitle = $(".page-title").$(".page-title__plp");
        Assert.assertEquals(pageTitle.getText(), catalogNameTitle);
    }

    @When("^Добавляем товар \"(.*)\" в корзину$")
    public void addProduct(String name) {
        ElementsCollection card = $(".plp-card-list").$$(".product-name").filter(Condition.exactText(name));
        SelenideElement buttonBasket = card.get(0).closest(".ui-product-card__info").closest(".ui-product-card").parent().$$(".collect-item").filter(Condition.exactText("В корзину")).get(0);
        buttonBasket.doubleClick();

    }

    @When("^Открываем корзину$")
    public void openBasket() {
        SelenideElement buttonBasket =$(".basket");
        buttonBasket.hover().doubleClick();
    }




//    @When("^Открываем каталог товаров$")
//    public void openCatalog() {
//
//        SelenideElement buttonCatalog = $(".catalog-button").shouldHave(Condition.text("Каталог"));
//        buttonCatalog.hover().doubleClick();
//
//        SelenideElement root1 = $x("./html/body/div[4]/div[2]/uc-app[1]/uc-catalog-v2");
//        SelenideElement shadowRoot1 = executeJavaScript("\"return document.querySelector('js-overlay').shadowRoot.querySelector('overlay js-overlay show')", root1);
//
//        SelenideElement root2 = shadowRoot1.$(".js-overlay");
//        SelenideElement shadowRoot2 = expandRootElement(root2);
//
//        SelenideElement root3 = shadowRoot2.$(".overlay.js-overlay.show");
//        SelenideElement shadowRoot3 = expandRootElement(root3);
//
//        SelenideElement root4 = shadowRoot3.$(".content-wrap");
//
//
//    }
//
//    public SelenideElement expandRootElement(WebElement element) {
//        WebElement ele = executeJavaScript("\"return document.querySelector('js-overlay').shadowRoot.querySelector('overlay js-overlay show')", element);
//        return $("."+ele);
//
//    }


}






