package pageobjects.homepage.mainpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageobjects.pagecontracts.PageCommon;
import pageobjects.pagecontracts.PageObjectCommon;
import utils.ElementWaiter;

public class ListItem extends PageCommon implements PageObjectCommon<ListItem>  {

    final By imageLocator = By.className("inventory_item_img");
    final By titleLocator = By.xpath(".//div[(@class='inventory_item_name ')]");
    final By descriptionLocator = By.className("inventory_item_desc");
    final By priceLocator = By.className("inventory_item_price");
    final By addToCartLocator = By.className("add-to-cart-sauce-labs-backpack");

    WebElement rootElement;

    String title;
    String description;
    String price;

    public ListItem(WebDriver driver, WebElement itemRoot) {
        super(driver);
        this.rootElement = itemRoot;
    }

    public ListItem populateElements() {
        updateTitle();
        updateDescription();
        updatePrice();
        return this;
    }

    public void updateTitle() {
        this.title = ElementWaiter.createInstance(getDriver()).withRootElement(this.rootElement).fluentWaitGetText(this.titleLocator);
    }

    public void updateDescription() {
        this.description = ElementWaiter.createInstance(getDriver()).withRootElement(this.rootElement).fluentWaitGetText(this.descriptionLocator);
    }

    public void updatePrice() {
        this.price = ElementWaiter.createInstance(getDriver()).withRootElement(this.rootElement).fluentWaitGetText(this.priceLocator);
    }

    public void addToCart() {
        ElementWaiter.createInstance(getDriver()).withRootElement(this.rootElement).fluentWaitClick(this.addToCartLocator, this);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public ListItem refreshElement() {
        PageFactory.initElements(getDriver(), this);
        return this;
    }
}
