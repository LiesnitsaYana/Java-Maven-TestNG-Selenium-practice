package TestNG_HomeWork9.HomeWork9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

public class SigninLoginPage extends Page {
	
	@FindBy(xpath = "//*[(@id = \"identifierId\")]")
	private WebElement signInInputField;
		
	@FindBy(xpath = "//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"CwaK9\", \" \" ))]")
	private WebElement signInButtonOnLoginPage;

	public SigninLoginPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public SigninPasswordPage clickOnSignInButtonOnLoginPage(String login) {
		signInInputField.sendKeys(login);
		jsClickOnElement(signInButtonOnLoginPage);
		return GmailPageFactory.initElements(webDriver, SigninPasswordPage.class);
	}
	
	public boolean isSignInButtonDisplayed() {
		return signInButtonOnLoginPage.isDisplayed();
	}
  
	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return ExpectedConditions.visibilityOf(signInButtonOnLoginPage);
	}

}
