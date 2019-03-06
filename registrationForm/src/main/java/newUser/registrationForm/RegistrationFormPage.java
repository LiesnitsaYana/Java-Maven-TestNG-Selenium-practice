package newUser.registrationForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

public class RegistrationFormPage extends Page {
	
	@FindBy(xpath = "//*[...]")
	private WebElement firstNameInputField;
	
	@FindBy(xpath = "//*[...]")
	private WebElement lastNameInputField;
		
	@FindBy(xpath = "//*[...]")
	private WebElement saveButton;
	
	@FindBy(xpath = "//*[...]")
	private WebElement cancelButton;
	
	@FindBy(xpath = "//*[...]")
	private WebElement actualMessage;
		
	public RegistrationFormPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public UserAccountPage clickOnSaveButtonOnRegistrationFormPage(String firstName, String lastName) {
		firstNameInputField.sendKeys(firstName);
		lastNameInputField.sendKeys(lastName);
		jsClickOnElement(saveButton);
		return RegistrationPageFactory.initElements(webDriver, UserAccountPage.class);
	}
	
	public boolean isErrorMessageDisplayed() {
		String errorMessage = "Invalid first name or last name";
		return actualMessage.getText().contains(errorMessage);
	}
	
	public boolean isSaveButtonDisplayed() {
		return saveButton.isDisplayed();
	}
	
	public boolean isCancelButtonDisplayed() {
		return cancelButton.isDisplayed();
	}
	
	public boolean isFirstNameInputFieldDisplayed() {
		return firstNameInputField.isDisplayed();
	}
  
	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return ExpectedConditions.visibilityOf(saveButton);
	}

}
