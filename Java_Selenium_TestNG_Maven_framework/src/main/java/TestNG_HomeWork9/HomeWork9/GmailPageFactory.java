package TestNG_HomeWork9.HomeWork9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPageFactory {
	
	@SuppressWarnings("unchecked")
	public static <T extends Page> T initElements(WebDriver webDriver, Class<T> clazz) {
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		Page page = PageFactory.initElements(webDriver, clazz);
		wait.until(page.isPageLoaded());
		
		return (T) page;
	}
	@SuppressWarnings("unchecked")
	public static void initElements(WebDriver webDriver, Page page){
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		PageFactory.initElements(webDriver, page);
		wait.until(page.isPageLoaded());
	}

}
