package pageobjects.homepage.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.pagecontracts.PageCommon;
import pageobjects.pagecontracts.PageObjectCommon;
import utils.ElementWaiter;

public class LoginPage extends PageCommon implements PageObjectCommon<LoginPage> {

    @FindBy(xpath = "//input[(@id='user-name')]")
    WebElement username;

    @FindBy(xpath = "//input[(@id='password')]")
    WebElement password;

    @FindBy(xpath = "//input[(@id='login-button')]")
    WebElement loginButton;

    public void setUsername(String username) {
        ElementWaiter.createInstance(getDriver()).<LoginPage>fluentWaitType(this.username, username, this);
    }

    public void setPassword(String password) {
        ElementWaiter.createInstance(getDriver()).<LoginPage>fluentWaitType(this.password, password, this);
    }

    public void login() {
        ElementWaiter.createInstance(getDriver()).<LoginPage>fluentWaitClick(this.loginButton, this);
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public LoginPage refreshElement() {
        PageFactory.initElements(getDriver(), this);
        return this;
    }
}
