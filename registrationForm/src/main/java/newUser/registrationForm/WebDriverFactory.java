package newUser.registrationForm;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
	
	private static final String CHROME = "chrome";

	private static WebDriver webDriver;

	private WebDriverFactory() {

	}
	
	public static WebDriver getInstance(String browser) {
		if (webDriver == null) {
			if (CHROME.equals(browser)) {
				
				WebDriverManager.chromedriver().setup();
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("test-type");
				options.addArguments("disable-infobars");

				webDriver = new ChromeDriver(options);				
			} else
				throw new IllegalArgumentException("Invalid browser property set in configuration file");
			
			webDriver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			webDriver.manage().window().maximize();
			webDriver.manage().deleteAllCookies();
		}

		return webDriver;
	}

	public static void killDriverInstance() {
		if (webDriver != null) {
			webDriver.manage().deleteAllCookies();
			webDriver.quit();
			webDriver = null;
		}
	}

}
