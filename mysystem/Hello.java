package main;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Hello {

public static void main(String[] args) {
	
	
	 Calendar calendar = Calendar.getInstance();
     calendar.setTime(new Date());
     calendar.set(Calendar.HOUR_OF_DAY, 23);
     calendar.set(Calendar.MINUTE, 59);
     calendar.set(Calendar.SECOND, 59);
     Date zero = calendar.getTime();
     long current = System.currentTimeMillis();
     long zero1=current/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset();
     System.out.println(new Timestamp(zero1));
     System.out.println(zero);
}
}
