package task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task3 {

	public static void main(String[] args) {

		List<Integer> someNumbers = Arrays.asList(23, 44, 25, 10, 65, 78, 38, 10, 95);
		List<Integer> temp1 = numbersListWithUsingAverage(someNumbers);

		System.out.println("Original list of numbers: " + "\n" + someNumbers);
		System.out.println("New list of numbers: " + "\n" + temp1);

	}

	public static List<Integer> numbersListWithUsingAverage(List<Integer> originalList) {
		int sum, aver;
		sum = 0;
		aver = 0;
		for (int i = 0; i < originalList.size(); i++) {
			sum += originalList.get(i);
			aver = sum / originalList.size();
		}
		System.out.println("Average of numbers in the someNumbers list is: " + aver);

		List<Integer> average = new ArrayList<>(originalList);
		int indexOfMin = originalList.lastIndexOf(Collections.min(originalList));
		average.set(indexOfMin, aver);
		return average;
	}

}