package makemytrip.mytrip;

import java.util.Date;
import java.util.TimeZone;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Calendar;
public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		 Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		 Date date = calendar.getTime();
		// date=date.30;
	      int day = calendar.get(Calendar.DATE);
	      System.out.println("Current Date is: " + date);
	      Calendar c= Calendar.getInstance();
	      c.add(Calendar.DATE, 30);
	      Date d=c.getTime();
	      int dayNo= c.get(c.DAY_OF_WEEK);
	        System.out.println(d);
	        System.out.println(dayNo);
	        
	        int week = c.get(c.WEEK_OF_MONTH);
  
        // Find the day from the local date 
	        System.out.println(week);
	    }

}
