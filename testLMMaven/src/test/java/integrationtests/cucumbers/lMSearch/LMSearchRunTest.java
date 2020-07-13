package integrationtests.cucumbers.lMSearch;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"integrationtests.cucumbers.lMSearch",
                "cucumber.api.spring"},
        tags = "@lMSearch")
public class LMSearchRunTest {
}
