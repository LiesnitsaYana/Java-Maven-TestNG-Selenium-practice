package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task1 {
	
	public static void main(String[] args) {

		System.out.println("Random string set with random count of letters: " + generateRandomString(6, 15, 5));

	}

	private static final String letters = "abcdefghijklmnopqrstuvwxyz";

	public static String generateRandomString(int lower, int upper, int count) {
		final List<StringBuilder> randomWords = new ArrayList<>(count);
		final Random random = new Random();
		final int range = upper - lower + 1;

		for (int i = 0; i < count; i++) { 
			int wordLength = lower + random.nextInt(range);
			final StringBuilder word = new StringBuilder(wordLength);

			for (int j = 0; j <= wordLength; j++) { 
				word.append(letters.charAt(random.nextInt(letters.length())));
				
			}
			randomWords.add(word);
		}
		return randomWords.toString();
	}
	
}
