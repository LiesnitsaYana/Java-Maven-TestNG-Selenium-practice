package homeWork2;

public class AboutPageOpenInFF extends Pages implements  IGetHtmlFF{

	public AboutPageOpenInFF(String title, String url, String htmlContent) {
		super(title, url, htmlContent);
		
	}
	public String toString() {
		return ("AboutPageOpenInFF");
	}

	@Override
	public String getHtmlFF() {
		return getHtmlContent();
	}

}
