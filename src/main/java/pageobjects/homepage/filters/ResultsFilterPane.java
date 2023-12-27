package pageobjects.homepage.filters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import pageobjects.pagecontracts.PageObjectCommon;
import pageobjects.youtube.mainpage.YouTubePage;
import utils.ElementWaiter;

public class ResultsFilterPane extends YouTubePage implements PageObjectCommon<ResultsFilterPane> {

    @FindBys({
            @FindBy(tagName = "ytd-search-filter-renderer"),
            @FindBy(tagName = "a"),
            @FindBy(tagName = "div"),
            @FindBy(linkText = "Last hour")
    })
    WebElement uploadDateLastHour;

    @FindBy(xpath = "//div[contains(@class, 'ytd-search-filter-renderer') and (@title='Search for Video')]")
    WebElement filterTypeVideo;

    @FindBy(xpath = "//div[contains(@class, 'ytd-search-filter-renderer') and (@title='Sort by view count')]")
    WebElement sortByViewCount;

    @FindBy(xpath = "//ytd-button-renderer[contains(@class, 'ytd-search-header-renderer')]")
    WebElement filterButton;

    @FindBy(xpath = "//button[id='button' and contains(@class, 'style-scope yt-icon-button') and aria-label='Cancel']")
    WebElement closeFilterDialog;

    private ResultsFilterPane() {
    }

    public ResultsFilterPane(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ResultsFilterPane filterUploadLastHour() {
        uploadDateLastHour.click();
        return this;
    }

    public ResultsFilterPane filterByVideoType() {
        ElementWaiter.createInstance(getDriver()).<ResultsFilterPane>fluentWaitClick(filterButton, this);
        ElementWaiter.createInstance(getDriver()).<ResultsFilterPane>fluentWaitClick(filterTypeVideo, this);
        waitForLoadComplete();
        return this;
    }

    public ResultsFilterPane sortByViewCount() {
        ElementWaiter.createInstance(getDriver()).fluentWaitClick(filterButton, this);
        ElementWaiter.createInstance(getDriver()).fluentWaitClick(sortByViewCount, this);
        waitForLoadComplete();
        return this;
    }

    public ResultsFilterPane closeFilterDialog() {
        ElementWaiter.createInstance(getDriver()).fluentWaitClick(closeFilterDialog, this);
        return this;
    }

    @Override
    public ResultsFilterPane refreshElement() {
        PageFactory.initElements(getDriver(), this);
        return this;
    }
}
