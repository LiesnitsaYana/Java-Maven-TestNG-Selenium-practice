package newUser.registrationForm;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegistrationFormTests {

	protected WebDriver webDriver;
	protected RegistrationFormPage registrationFormPage;
	protected UserAccountPage userAccountPage;

	@BeforeMethod
	@Parameters({ "browserName" })
	public void setup(String browserName) {
		webDriver = WebDriverFactory.getInstance(browserName);
		webDriver.get("https://.........../");
		registrationFormPage = RegistrationPageFactory.initElements(webDriver, RegistrationFormPage.class);
	}

	@Test
	@Parameters({ "validFirstName", "validLastName" })
	public void newUserRegistrationWithValidData(String validFirstName, String validLastName) {
		Assert.assertTrue(registrationFormPage.isSaveButtonDisplayed(), "Save button is not displayed");
		userAccountPage = registrationFormPage.clickOnSaveButtonOnRegistrationFormPage(validFirstName, validLastName);
	}

	@Test
	@Parameters({ "invalidFirstName", "validLastName" })
	public void newUserRegistrationWithInvalidFirstName(String invalidFirstName, String validLastName) {
		Assert.assertTrue(registrationFormPage.isCancelButtonDisplayed(), "Cancel button is not displayed");
		registrationFormPage.clickOnSaveButtonOnRegistrationFormPage(invalidFirstName, validLastName);
		Assert.assertTrue(registrationFormPage.isErrorMessageDisplayed(), "Error message is not displayed");
	}

	@Test
	@Parameters({ "validFirstName", "invalidLastName" })
	public void newUserRegistrationWithInvalidLastName(String validFirstName, String invalidLastName) {
		Assert.assertTrue(registrationFormPage.isFirstNameInputFieldDisplayed(),
				"First name input field is not displayed");
		registrationFormPage.clickOnSaveButtonOnRegistrationFormPage(validFirstName, invalidLastName);
		Assert.assertTrue(registrationFormPage.isErrorMessageDisplayed(), "Error message is not displayed");
	}

	@Test
	@Parameters({ "invalidFirstName", "invalidLastName" })
	public void newUserRegistrationWithInvalidData(String invalidFirstName, String invalidLastName) {
		Assert.assertTrue(registrationFormPage.isFirstNameInputFieldDisplayed(),
				"First name input field is not displayed");
		registrationFormPage.clickOnSaveButtonOnRegistrationFormPage(invalidFirstName, invalidLastName);
		Assert.assertTrue(registrationFormPage.isErrorMessageDisplayed(), "Error message is not displayed");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		if (webDriver != null) {
			WebDriverFactory.killDriverInstance();
		}
	}

}
