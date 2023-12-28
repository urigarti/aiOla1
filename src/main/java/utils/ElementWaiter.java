package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pageobjects.pagecontracts.PageObjectCommon;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.NoSuchElementException;

public class ElementWaiter {

    Wait<WebDriver> waiter;
    WebDriver _driver;

    WebElement rootElement;

    static ElementWaiter elementWaiter;

    private ElementWaiter(WebDriver driver) {
        _driver = driver;
        waiter = new FluentWait<>(_driver)
                .withTimeout(Duration.of(10, ChronoUnit.SECONDS))
                .pollingEvery(Duration.of(1, ChronoUnit.SECONDS))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    public static ElementWaiter createInstance(WebDriver driver) {
        if (elementWaiter == null) {
            elementWaiter = new ElementWaiter(driver);
        }
        return elementWaiter;
    }

    public ElementWaiter withRootElement(WebElement rootElement) {
        this.rootElement = rootElement;
        return this;
    }

    public Boolean isElementExist(By locator) {
        try {
            return _driver.findElement(locator) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean isElementExist(WebElement element) {
        try {
            return element != null;
        } catch (Exception e) {
            return false;
        }
    }

    public <T extends PageObjectCommon> void fluentWaitClick(WebElement _element, T targetClass) {
        waiter.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver arg0) {
                try {
                    targetClass.refreshElement();
                    if (elementInteractable(_element)) {
                        _element.click();
                        return true;
                    } else {
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        });
    }

    public <T extends PageObjectCommon> void fluentWaitClick(By _element, T targetClass) {
        waiter.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver arg0) {
                try {
                    WebElement targetElement = innerFindElement(arg0, _element);

                    targetClass.refreshElement();
                    if (elementInteractable(targetElement)) {
                        targetElement.click();
                        return true;
                    } else {
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        });
    }

    public <T extends PageObjectCommon> void fluentWaitSpecialClick(WebElement _element, T targetClass) {
        waiter.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver arg0) {
                try {
                    targetClass.refreshElement();
                    new Actions(arg0).sendKeys(_element, Keys.RETURN).perform();
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        });
    }

    public <T extends PageObjectCommon> void fluentWaitType(WebElement _element, String text, T targetClass) {
        waiter.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver arg0) {
                try {
                    targetClass.refreshElement();
                    _element.sendKeys(text);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        });
    }

    public WebElement fluentWaitElement(By locator) {
        return waiter.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver arg0) {
                try {
                    return innerFindElement(arg0, locator);
                } catch (Exception e) {
                    return null;
                }
            }
        });
    }

    public <T extends PageObjectCommon> String fluentWaitGetText(WebElement element, T targetClass) {
        return waiter.until(new ExpectedCondition<String>() {
            @Override
            public String apply(WebDriver arg0) {
                try {
                    targetClass.refreshElement();
                    return element.getText();
                } catch (Exception e) {
                    return null;
                }
            }
        });
    }

    public String fluentWaitGetAttribute(By element, WebElement parentElement, String attribute) {
        return waiter.until(new ExpectedCondition<String>() {
            @Override
            public String apply(WebDriver arg0) {
                try {
                    WebElement targetElement = innerFindElement(arg0, element);
                    return elementInteractable(targetElement) ? targetElement.getAttribute(attribute) : null;
                } catch (Exception e) {
                    return null;
                }
            }
        });
    }

    public String fluentWaitGetText(By element) {
        return waiter.until(new ExpectedCondition<String>() {
            @Override
            public String apply(WebDriver arg0) {
                try {
                    WebElement targetElement = innerFindElement(arg0, element);
                    if (targetElement != null) {
                        return targetElement.getText();
                    }
                } catch (Exception e) {
                    return null;
                }
                return null;
            }
        });
    }

    protected boolean elementInteractable(WebElement webElement) {
        return webElement != null && (webElement.isEnabled() & webElement.isDisplayed());
    }

    protected WebElement innerFindElement(WebDriver driver, By elementSelector) {
        if (this.rootElement == null) {
            return driver.findElement(elementSelector);
        } else {
            return this.rootElement.findElement(elementSelector);
        }
    }

}
