package TestNG_HomeWork9.HomeWork9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

public class SigninPasswordPage extends Page {

	@FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
	private WebElement passwordInputField;
	
	@FindBy(xpath = "//*[@id=\"passwordNext\"]/content/span")
	private WebElement nextButton1;

	public SigninPasswordPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public boolean isNextButton1Displayed() {
		return nextButton1.isDisplayed();
	}
	
	public InboxPage clickOnSignInButton1(String password) {
		passwordInputField.sendKeys(password);
		jsClickOnElement(nextButton1);
		return GmailPageFactory.initElements(webDriver, InboxPage.class);
	}
	 
	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return ExpectedConditions.visibilityOf(nextButton1);
	}

}
