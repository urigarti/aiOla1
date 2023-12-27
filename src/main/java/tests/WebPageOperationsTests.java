package tests;

import driver.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import utils.WebPageUtils;


public class WebPageOperationsTests extends BaseTest {

    @Before
    public void beforeStep(Scenario scenario) {
        updateLoggerManager(scenario);
    }

    @Given("^a Web Page is opened with the following URL \"(.*)\"$")
    public void openWebPageWithURL(String URL) {
        WebPageUtils.createInstance(DriverFactory.getDriver()).openUrl(URL);
    }

}
