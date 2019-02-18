package TestNG_HomeWork9.HomeWork9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

public class GmailAboutPage extends Page {
	
	@FindBy(xpath = "//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"gmail-nav__nav-link__sign-in\", \" \" ))]")
	private WebElement signInButton;

	public GmailAboutPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public SigninLoginPage clickOnSignInButton() {
		jsClickOnElement(signInButton);
		return GmailPageFactory.initElements(webDriver, SigninLoginPage.class);
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return ExpectedConditions.visibilityOf(signInButton);
	}

}
