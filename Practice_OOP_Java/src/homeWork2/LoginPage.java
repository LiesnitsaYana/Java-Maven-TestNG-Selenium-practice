package homeWork2;

public class LoginPage extends Pages implements IGetHtmlChrome, IGetHtmlFF {

	public LoginPage(String title, String url, String htmlContent) {
		super(title, url, htmlContent);
	}
	public String toString() {
		return ("LoginPage");
	}

	@Override
	public String getHtmlFF() {
		return getHtmlContent();
	}

	@Override
	public String getHtmlChrome() {
		return getHtmlContent();
	}

}
