package newUser.registrationForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPageFactory {
	
	@SuppressWarnings("unchecked")
	public static <T extends Page> T initElements(WebDriver webDriver, Class<T> clazz) {
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		Page page = RegistrationPageFactory.initElements(webDriver, clazz);
		wait.until(page.isPageLoaded());
		
		return (T) page;
	}
	@SuppressWarnings("unchecked")
	public static void initElements(WebDriver webDriver, Page page){
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		RegistrationPageFactory.initElements(webDriver, page);
		wait.until(page.isPageLoaded());
	}

}
