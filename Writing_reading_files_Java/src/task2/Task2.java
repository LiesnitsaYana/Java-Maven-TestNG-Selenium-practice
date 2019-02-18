package task2;

import java.util.Calendar;
import java.util.Date;

public class Task2 {
	
public static void main(String[] args) {
		
		Date currentDate = new Date();
		System.out.println(currentDate);
		Date temp = modifitedDateMethod(currentDate, 1, 5, 20);
		System.out.println(temp);
		Date temp2 = modifitedDateMethod(currentDate, 4, 8, 15);
		System.out.println(temp2);
		
		
	}
		public static Date modifitedDateMethod(Date date, int years, int months, int days) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.YEAR, years);
			calendar.add(Calendar.MONTH, months);
			calendar.add(Calendar.DAY_OF_MONTH, days);
			
			Date modifitedDate = (Date) calendar.getTime();
			return modifitedDate;
			
			
		}	
	
}