package newUser.registrationForm;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page implements IPageLoaded {

	protected WebDriver webDriver;

	public Page(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public String getTitle() {
		return webDriver.getTitle();
	}

	public String getPageUrl() {
		return webDriver.getCurrentUrl();
	}

	public WebDriverWait getWebDriverWait(int seconds) {
		WebDriverWait wait = new WebDriverWait(webDriver, seconds);
		return wait;
	}

	public void jsClickOnElement(WebElement webElement) {
		getJSExecutor().executeScript("arguments[0].click();", webElement);
	}

	private JavascriptExecutor getJSExecutor() {
		return (JavascriptExecutor) webDriver;
	}
}
