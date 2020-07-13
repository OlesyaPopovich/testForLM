package integrationtests.cucumbers.commonUtils;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class common {

    @Given("^Запускаем браузер и входим на сайт LeroyMerlin$")
    public void openLeroyMerlin() {
        Selenide.sleep(3000);
        open("https://kostroma.leroymerlin.ru/");
    }

    @Given("^Запускаем браузер и входим на сайт LeroyMerlin \"(.*)\"$")
    public void openLMWithRegion(String region) {
        Selenide.sleep(3000);
        open("http://" + region + ".leroymerlin.ru/");
    }
}
