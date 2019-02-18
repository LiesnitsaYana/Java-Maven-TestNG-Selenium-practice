package homeWork2;

public class ForumPageOpenInChrome extends Pages implements IGetHtmlChrome {

	public ForumPageOpenInChrome(String title, String url, String htmlContent) {
		super(title, url, htmlContent);
		
	}
	public String toString() {
		return ("ForumPageOpenInChrome");
	}

	@Override
	public String getHtmlChrome() {
		return getHtmlContent();
	}

	

}
