package homeWork2;

public class AboutPageOpenInChrome extends Pages implements IGetHtmlChrome{

	public AboutPageOpenInChrome(String title, String url, String htmlContent) {
		super(title, url, htmlContent);
		
	}
	public String toString() {
		return ("AboutPageOpenInChrome");
	}

	@Override
	public String getHtmlChrome() {
		return getHtmlContent();
	}

}
