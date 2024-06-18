package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"stepDefinitions"},
        tags= "@activity6",
        monochrome = true,
        publish = true,
        plugin ={"pretty","json: test-reports/json-report.json"}

)


public class TestRunner {

}
