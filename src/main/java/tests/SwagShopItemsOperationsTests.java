package tests;

import customexceptions.EmptyShopException;
import customexceptions.ShopItemNotFoundException;
import driver.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import logger.LoggerManager;
import pageobjects.homepage.mainpage.ItemsManager;

public class SwagShopItemsOperationsTests extends BaseTest {

    @Before
    public void beforeStep(Scenario scenario) {
        updateLoggerManager(scenario);
    }

    @Given("^Populate StoreItems$")
    public void populateStore() throws EmptyShopException {
        ItemsManager.createInstance(DriverFactory.getDriver()).populateStoreItems();
    }

    @When("^Validate Shop Item with Title \"(.*)\" to Have Description that Contains \"(.*)\"$")
    public void validateShopItem(String itemTitle, String itemDescription) throws ShopItemNotFoundException {
        try {
            if(!ItemsManager.createInstance(DriverFactory.getDriver()).getDescriptionForItem(itemTitle).contains(itemDescription)) {
                throw new IllegalStateException("Item: " + itemTitle + " did not contain the description: " + itemDescription);
            }
        } catch (ShopItemNotFoundException e) {
            LoggerManager.getInstance().fail(e.getMessage());
            throw e;
        }
    }

    @When("^Validate Shop Item count \"(.*)\"$")
    public void validateShopItemsCount(int itemsCount) {
        if(ItemsManager.createInstance(DriverFactory.getDriver()).getShopItemsCount() != itemsCount) {
            throw new IllegalStateException("Shop items count is not: " + itemsCount + " as expected." + "\nCurrent shop items is: " + ItemsManager.createInstance(DriverFactory.getDriver()).getShopItemsCount());
        }
    }
}
