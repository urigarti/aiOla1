package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

	static WebDriver _driver;

	DriverFactory() {}

	protected static WebDriver getChromeInstance() {
		if(_driver == null) {
			String path = Thread.currentThread().getContextClassLoader().getResource("drivers/chrome/chromedriver.exe").getPath();
			System.setProperty("webdriver.chrome.driver", path);
			_driver = new ChromeDriver();
		}
		return _driver;
	}
	public static WebDriver getDriver() {
		if(_driver == null) {
			FirefoxOptions options = new FirefoxOptions();
			_driver = new FirefoxDriver(options);
		}
		return _driver;
	}

}
