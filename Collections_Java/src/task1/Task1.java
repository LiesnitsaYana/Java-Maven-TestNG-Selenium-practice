package task1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Task1 {

	public static void main(String[] args) {

		List<String> suitcase = new LinkedList<>();
		Collections.addAll(suitcase, "glasses", "hat", "socks", "hat", "sweater", "hat", "tickets", "passport");

		ListIterator<String> iterator = suitcase.listIterator();
		for (int i = 0; i < suitcase.size() / 2; i++) {
			String next = iterator.next();
			if (next.equals("hat")) {
				iterator.set("t-shirt");
			}
		}
		System.out.println("Things I need to put in my suitcase: " + "\n" + suitcase);
	}
}