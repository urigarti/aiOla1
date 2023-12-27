package pageobjects.youtube.mainpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.pagecontracts.PageCommon;
import utils.ElementWaiter;

abstract public class YouTubePage extends PageCommon {

    final By mainProgressBar = new By.ByXPath("//yt-page-navigation-progress[@hidden]");

    protected YouTubePage(){}

    public YouTubePage(WebDriver driver) {
        super(driver);
    }

    public void waitForLoadComplete() {
        ElementWaiter.createInstance(getDriver()).fluentWaitElement(mainProgressBar);
    }
}
