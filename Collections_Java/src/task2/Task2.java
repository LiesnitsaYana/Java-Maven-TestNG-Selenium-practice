package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Task2 {

	public static void main(String[] args) {

		List<Integer> pagesToReadList = Arrays.asList(232, 215, 232, 195, 232, 150, 195, 123, 150, 24);
		List<Integer> pagesInReverse = reverseList(pagesToReadList);
		LinkedHashSet<Integer> uniquePagesNumbers = uniqueElements(pagesInReverse);

		System.out.println("Page numbers for reading: " + "\n" + pagesToReadList);
		System.out.println("Page numbers in reverse: " + "\n" + pagesInReverse);
		System.out.println("Right pages list: " + "\n" + uniquePagesNumbers);

	}

	public static List<Integer> reverseList(List<Integer> ourListOfIntegers) {

		List<Integer> reverse = new ArrayList<>(ourListOfIntegers.size());
		for (int i = ourListOfIntegers.size() - 1; i >= 0; i--) {
			reverse.add(ourListOfIntegers.get(i));
		}
		return reverse;
	}

	public static LinkedHashSet<Integer> uniqueElements(List<Integer> ourListOfIntegers) {
		Set<Integer> unique = new LinkedHashSet<>(ourListOfIntegers);
		return (LinkedHashSet<Integer>) unique;
	}

}