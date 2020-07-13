package integrationtests.cucumbers.commonUtils;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Olesya Popovich
 */

public class common {


    @Given("^Запускаем браузер и входим на сайт LeroyMerlin$")
    public void openLeroyMerlin() {
        Configuration.timeout = 30_000;
        open("https://kostroma.leroymerlin.ru/");

    }

    @Given("^Запускаем браузер и входим на сайт LeroyMerlin \"(.*)\"$")
    public void openLMWithRegion(String region) {
        Selenide.sleep(3000);
        open("http://" + region + ".leroymerlin.ru/");
    }

    @Then("^Отображается название вкладки сайта LeroyMerlin \"(.*)\"$")
    public void titleName(String nameTitle) {
        Assert.assertEquals(title(), nameTitle);
    }

    @Then("^Отображается поп-ап смены региона \"(.*)\"$")
    public void popoverContent(String region) {
        SelenideElement popover = $(".popover-content").shouldHave(Condition.exist,Condition.visible);
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
//      SelenideElement regionName = regionPanel.findAll(By.tagName("a")).filterBy(Condition.visible).get(0);

}
