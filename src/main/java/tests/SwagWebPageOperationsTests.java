package tests;

import driver.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import pageobjects.homepage.loginPage.LoginPage;

public class SwagWebPageOperationsTests extends BaseTest {

    @Before
    public void beforeStep(Scenario scenario) {
        updateLoggerManager(scenario);
    }

    @Given("^Set Login Username to \"(.*)\"$")
    public void setLoginUsername(String username) {
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.setUsername(username);
    }

    @Given("^Set Login Password to \"(.*)\"$")
    public void setLoginPassword(String password) {
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.setPassword(password);
    }

    @Given("^Click Login$")
    public void clickLogin() {
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login();
    }

}
