package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/main.feature",
        glue={"tests"},
        plugin = { "html:target/cucumber-reports/aiOla.html"  }
)

public class TestRunner {

}
