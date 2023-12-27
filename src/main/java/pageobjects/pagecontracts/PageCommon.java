package pageobjects.pagecontracts;

import org.openqa.selenium.WebDriver;

public abstract class PageCommon {

	WebDriver driver;

	public PageCommon() {}

	public PageCommon(WebDriver driver) {
		this.driver = driver;
	}

	protected WebDriver getDriver() {
		return this.driver;
	}

	protected void openUrl(String url) {
		this.driver.get(url);
	}

}
