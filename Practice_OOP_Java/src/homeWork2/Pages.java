package homeWork2;

public class Pages {
	private String title;
	private String url;
	private String htmlContent;

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public String getHtmlContent() {
		return htmlContent;
	}

	public void setTitle() {
	}

	public void setUrl() {
	}

	public void setHtmlContent() {
	}

	public Pages(String title, String url, String htmlContent) {
		this.title = title;
		this.url = url;
		this.htmlContent = htmlContent;
	}

	public void load() {
		System.out.println("The page " + getTitle() + " is loaded");
	}

	public void refresh() {
		System.out.println("The page " + getTitle() + " is refreshed");
	}

	public String htmlBuilder(String htmlContent) {
		return getUrl();
	}

}
