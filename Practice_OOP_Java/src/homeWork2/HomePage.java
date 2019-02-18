package homeWork2;

public class HomePage extends Pages implements IGetHtmlChrome, IGetHtmlFF {

	public HomePage(String title, String url, String htmlContent) {
		super(title, url, htmlContent);
		
	}
	public String toString() {
		return ("HomePage");
	}

	@Override
	public String getHtmlChrome() {
		return getHtmlContent();
	}

	@Override
	public String getHtmlFF() {
		return getHtmlContent();
	}

}
