package TestNG_HomeWork9.HomeWork9;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Function;

public class InboxPage extends Page {

	@FindBy(how = How.ID_OR_NAME, using = "q")
	private WebElement searchInputField;

	@FindBy(how = How.XPATH, using = "//*[@id=\"aso_search_form_anchor\"]/button[3]")
	private WebElement deleteSearchRequestButton;

	@FindBy(how = How.XPATH, using = "//div[@role=\"main\"]//table[@id]//tr//td")
	private List<WebElement> allLettersList;

	public InboxPage(WebDriver webDriver) {
		super(webDriver);
	}

	public boolean isSearchInputFieldDisplayed() {
		return searchInputField.isDisplayed();
	}
	
	public InboxPage clearSearchInputField() {
		searchInputField.clear();
		return GmailPageFactory.initElements(webDriver, InboxPage.class);
	}

	public InboxPage searchTheLetter(String letterTitle) {
		searchInputField.sendKeys(letterTitle);
		searchInputField.sendKeys(Keys.ENTER);
		return GmailPageFactory.initElements(webDriver, InboxPage.class);
	}
 
	public void areLettersDisplayed(SoftAssert sa, String letterTitle) {
		List<String> tittlesList = allLettersList.stream() 
				.map(WebElement :: getText) 
				.collect(Collectors.toList());
		
		for (int i = 0; i < tittlesList.size(); i++) {
			if (tittlesList.get(i).equals(letterTitle)) {
				sa.assertEquals(tittlesList.get(i).toString().toLowerCase().contains(letterTitle), true);
			}
		}
	}

	public void areLettersNotDisplayed(SoftAssert sa, String letterTitle) {
		List<String> tittlesList = allLettersList.stream() 
				.map(WebElement :: getText) 
				.collect(Collectors.toList());

		for (int i = 0; i < tittlesList.size(); i++) {
			if (tittlesList.get(i).equals(letterTitle)) {
				sa.assertNotEquals(tittlesList.get(i).toString().toLowerCase().contains(letterTitle), true);
			}
		}
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return ExpectedConditions.visibilityOf(searchInputField);
	}

}
