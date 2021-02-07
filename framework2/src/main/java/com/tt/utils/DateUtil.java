package com.tt.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static String dateFormat="dd-MM-yyyy HH:mm:ss";
	public static String getCurrentDate(String format)
	{
		String output=" ";
		Date d= new Date();
		SimpleDateFormat sf =new SimpleDateFormat(format);
		output=sf.format(d);
		return output;
	}
	public static String getCurrentDate( )
	{
		
		return getCurrentDate(dateFormat);
	}
	public static String getDate(String increamentType,int factor)
	{
		String output=" ";
		Calendar cal=Calendar.getInstance();
		if(increamentType.equalsIgnoreCase("Month"))
			
		
			cal.add(Calendar.MONTH,factor);
		else if(increamentType.equalsIgnoreCase("Year"))
			
			
			cal.add(Calendar.YEAR,factor);
else if(increamentType.equalsIgnoreCase("Hour"))
			
			
			cal.add(Calendar.HOUR,factor);
		
			Date d=cal.getTime();
			SimpleDateFormat sf =new SimpleDateFormat(dateFormat);
			output=sf.format(d);
		
		return output;
	}
	public static long timeDiff(String before,String after) {
		long diff=0;
	try
	{
		Date d1=new SimpleDateFormat (dateFormat).parse(before);
		
		Date d2=new SimpleDateFormat(dateFormat).parse(after);
		SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy HH:mm.ss");
		
		long beforeTime=d1.getTime();
		long afterTime=d2.getTime();
		diff=(afterTime - beforeTime)/1000;
		
	}
	catch(Exception e)
	{ 
		e.printStackTrace();
		
	}
	return diff;
	}
//	public static void delay(int milliseconds)
//	{
//		try
//		{
//			
//		}
//		catch(Exception e)
//		{
//			
//		}
//	}
	public static void main(String args[])
	{
System.out.println(DateUtil.getCurrentDate());
System.out.println(DateUtil.getDate("MONTH", 3));
System.out.println("Time difference in seconds:" + DateUtil.timeDiff("30-01-2021 20:25:50","31-01-2021 20:25:59" ));
}
}
