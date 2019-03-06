package newUser.registrationForm;

import org.openqa.selenium.WebDriver;

import com.google.common.base.Function;

public class UserAccountPage extends Page {

	public UserAccountPage(WebDriver webDriver) {
		super(webDriver);
	}

	public Function<WebDriver, ?> isPageLoaded() {
		return null;
	}

}
