package pageobjects.homepage.mainpage;

import customexceptions.EmptyShopException;
import customexceptions.ShopItemNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.pagecontracts.PageCommon;
import pageobjects.pagecontracts.PageObjectCommon;

import java.util.ArrayList;
import java.util.List;

public class ItemsManager extends PageCommon implements PageObjectCommon<ItemsManager> {

    static ItemsManager itemsManager;

    @FindBy(xpath = "//div[(@class='inventory_item')]")
    List<WebElement> items;

    List<ListItem> storeItems = new ArrayList<ListItem>();

    private ItemsManager(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static ItemsManager createInstance(WebDriver driver) {
        if(itemsManager ==null) {
            itemsManager = new ItemsManager(driver);
        }
        return itemsManager;
    }
    public ItemsManager populateStoreItems() throws EmptyShopException {
        if((items == null) || (items != null && items.size() == 0)) {
            throw new EmptyShopException("Shop items do not exist, or had not been populated");
        }
        for(WebElement storeItem : items) {
            ListItem currentStoreItem = new ListItem(this.getDriver(), storeItem);
            currentStoreItem.populateElements();
            storeItems.add(currentStoreItem);
        }
        return this;
    }

    public int getShopItemsCount() {
        return storeItems.size();
    }

    public ListItem getListItem(String itemTitle) throws ShopItemNotFoundException {
        String foundDesc = null;
        for (ListItem item : storeItems) {
            if (itemTitle.equals(item.getTitle())) {
                return item;
            }
        }
        throw new ShopItemNotFoundException(itemTitle);
    }

    @Override
    public ItemsManager refreshElement() {
        PageFactory.initElements(getDriver(), this);
        return this;
    }
}
