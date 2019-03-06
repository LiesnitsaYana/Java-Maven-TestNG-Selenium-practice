package newUser.registrationForm;

import org.openqa.selenium.WebDriver;

import com.google.common.base.Function;

public interface IPageLoaded {

	Function<WebDriver, ?> isPageLoaded();
}
