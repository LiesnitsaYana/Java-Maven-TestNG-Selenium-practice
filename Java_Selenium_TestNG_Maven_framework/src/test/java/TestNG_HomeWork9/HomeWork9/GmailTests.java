package TestNG_HomeWork9.HomeWork9;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GmailTests {
	
	private WebDriver webDriver;
	protected GmailAboutPage gmailAboutPage;
	protected SigninLoginPage signinLoginPage;
	protected SigninPasswordPage signinPasswordPage;
	protected InboxPage inboxPage;
	SoftAssert sa;

	@BeforeSuite
	@Parameters({ "browserName" })
	public void setup(String browserName) {
		
		webDriver = WebDriverFactory.getInstance(browserName);
		webDriver.get("https://www.gmail.com/");
		if (webDriver.getCurrentUrl().contains("https://www.gmail.com/")) {
			gmailAboutPage = GmailPageFactory.initElements(webDriver, GmailAboutPage.class);
		} else {
			signinLoginPage = GmailPageFactory.initElements(webDriver, SigninLoginPage.class);
		}
	}

	@Test
	@Parameters({ "login" })
	public void goToSigninLoginPage(String login) {
		if (webDriver.getCurrentUrl().contains("https://www.gmail.com/")) {
			signinLoginPage = gmailAboutPage.clickOnSignInButton();
			Assert.assertTrue(signinLoginPage.isSignInButtonDisplayed(), "Sign In button is not displayed");
			signinPasswordPage = signinLoginPage.clickOnSignInButtonOnLoginPage(login);
			Assert.assertTrue(signinPasswordPage.isNextButton1Displayed(), "Next button is not displayed");
			
		} else {
			signinPasswordPage = signinLoginPage.clickOnSignInButtonOnLoginPage(login);
			Assert.assertTrue(signinPasswordPage.isNextButton1Displayed(), "Next button is not displayed");
		}
	}

	@Test(dependsOnMethods = "goToSigninLoginPage")
	@Parameters({ "password" })
	public void goToInboxPage(String password) {
		inboxPage = signinPasswordPage.clickOnSignInButton1(password);
		Assert.assertTrue(inboxPage.isSearchInputFieldDisplayed(), "Search Input field is not displayed");
	}
		
	@Test(dependsOnMethods = "goToInboxPage") //enabled = false
	@Parameters({ "title1" })
	public void findTheLetterByTittleTrue(String title1) {
		sa = new SoftAssert();
		inboxPage.searchTheLetter(title1);
		inboxPage.areLettersDisplayed(sa, title1);

	}
	
	@Test(dependsOnMethods = "findTheLetterByTittleTrue")
	@Parameters({ "title2" })
	public void findTheLetterByInvalidTitle(String title2) {
		sa = new SoftAssert();
		inboxPage.clearSearchInputField();
		inboxPage.searchTheLetter(title2);
		inboxPage.areLettersNotDisplayed(sa, title2);

	}

	@AfterSuite
	public void tearDown() throws Exception {
		if (webDriver != null) {
			sa.assertAll();
			WebDriverFactory.killDriverInstance();
		}
	}

}
