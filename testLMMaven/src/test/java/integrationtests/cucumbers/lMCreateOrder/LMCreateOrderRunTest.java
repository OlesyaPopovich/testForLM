package integrationtests.cucumbers.lMCreateOrder;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Created by Olesya Popovich
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"integrationtests.cucumbers.lMCreateOrder",
                "cucumber.api.spring"},
        tags = "@lMCreateOrder")
public class LMCreateOrderRunTest {
}
