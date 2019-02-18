package homeWork2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Website {

	public static void main(String[] args) {

		LoginPage loginPage = new LoginPage("login", "/login", "<html><body1>...</body1></html>");
		HomePage homePage = new HomePage("home", "/home", "<html><body2>...</body2></html>");
		ForumPageOpenInFF forumPageOpenInFF = new ForumPageOpenInFF("forum", "/forum_ff",
				"<html><body3>...</body3></html>");
		ForumPageOpenInChrome forumPageOpenInChrome = new ForumPageOpenInChrome("forum", "/forum_chrome",
				"<html><body4>...</body4></html>");
		AboutPageOpenInFF aboutPageOpenInFF = new AboutPageOpenInFF("about", "/about_ff",
				"<html><body5>...</body5></html>");
		AboutPageOpenInChrome aboutPageOpenInChrome = new AboutPageOpenInChrome("about", "/about_about",
				"<html><body6>...</body6></html>");

		// ------------------------------------------------

		System.out.println("1st and 2nd tasks: ");

		List<Pages> allPagesList = Arrays.asList(loginPage, homePage, forumPageOpenInFF, forumPageOpenInChrome,
				aboutPageOpenInFF, aboutPageOpenInChrome);
		System.out.println("The all pages list is: \n" + allPagesList);

		// ------------------------------------------------

		System.out.println("\n3rd task:");

		List<Pages> allPagesOpenInFF = new ArrayList<>();
		for (Pages temp : allPagesList) {
			if (temp instanceof IGetHtmlFF)
				allPagesOpenInFF.add(temp);
		}
		System.out.println("The all pages open in FF list is: \n" + allPagesOpenInFF);

		List<Pages> allPpagesOpenInChrome = new ArrayList<>();
		for (Pages temp : allPagesList) {
			if (temp instanceof IGetHtmlChrome)
				allPpagesOpenInChrome.add(temp);
		}
		System.out.println("The all pages open in Chrome list is: \n" + allPpagesOpenInChrome);

		// ------------------------------------------------

		System.out.println("\n4th task:");

		String temp1 = loginPage.htmlBuilder(loginPage.getHtmlContent());
		System.out.println("This htmlBuilder method for " + loginPage.getTitle() + " page: " + temp1);

		String temp2 = homePage.htmlBuilder(homePage.getHtmlContent());
		System.out.println("The " + homePage.getTitle() + "page link is: " + temp2);

		String temp3 = forumPageOpenInFF.htmlBuilder(forumPageOpenInFF.getHtmlContent());
		System.out
				.println("Click on the link: " + temp3 + "and look at the html: " + forumPageOpenInFF.getHtmlContent());

		String temp4 = forumPageOpenInChrome.htmlBuilder(forumPageOpenInChrome.getHtmlContent());
		System.out.println("The htmlBuilder method for " + forumPageOpenInChrome.getTitle() + " page is: " + temp4);

		String temp5 = aboutPageOpenInFF.htmlBuilder(aboutPageOpenInFF.getHtmlContent());
		System.out.println("Steps: click on the link: " + temp5);

		String temp6 = aboutPageOpenInChrome.htmlBuilder(aboutPageOpenInChrome.getHtmlContent());
		System.out.println("The " + aboutPageOpenInChrome.getTitle() + " page link is: " + temp6);

		// ------------------------------------------------

		System.out.println("\n5th task:");

		List<String> allPagesTitles = Arrays.asList(loginPage.getTitle(), homePage.getTitle(),
				forumPageOpenInFF.getTitle(), forumPageOpenInChrome.getTitle(), aboutPageOpenInFF.getTitle(),
				aboutPageOpenInChrome.getTitle());

		Set<String> uniquePagesTitles = new HashSet<>(allPagesTitles);

		System.out.println("The all unique page titles list is: \n" + uniquePagesTitles);

		// ------------------------------------------------

		System.out.println("\n6th task:");

		Map<String, List<Pages>> mapWithTitles = new HashMap<String, List<Pages>>();
		for (String keyTitle : uniquePagesTitles) {
			List<Pages> valuePages = new LinkedList<Pages>();
			for (Pages page : allPagesList) {
				if (page.getTitle() == keyTitle) {
					valuePages.add(page);
				}
			}

			mapWithTitles.put(keyTitle, valuePages);
			System.out.println(mapWithTitles);
		}

		System.out.println(loginPage.getHtmlContent());
		System.out.println(homePage.getHtmlContent());
		System.out.println(forumPageOpenInFF.getHtmlContent());
		System.out.println(forumPageOpenInChrome.getHtmlContent());
		System.out.println(aboutPageOpenInFF.getHtmlContent());
		System.out.println(aboutPageOpenInChrome.getHtmlContent());

	}

}
