package utils;

import org.openqa.selenium.WebDriver;

public class WebPageUtils {

    WebDriver driver;

    WebPageUtils() {
    }

    private WebPageUtils(WebDriver driver) {
        this.driver = driver;
    }

    public static WebPageUtils createInstance(WebDriver driver) {
        return new WebPageUtils(driver);
    }

    public void openUrl(String URL) {
        this.driver.get(URL);
    }
}
