package homeWork2;

public class ForumPageOpenInFF extends Pages implements IGetHtmlFF {

	public ForumPageOpenInFF(String title, String url, String htmlContent) {
		super(title, url, htmlContent);
		
	}
	public String toString() {
		return ("ForumPageOpenInFF");
	}

	@Override
	public String getHtmlFF() {
		return getHtmlContent();
	}

}
