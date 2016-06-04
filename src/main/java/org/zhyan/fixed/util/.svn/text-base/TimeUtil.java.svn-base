package org.zhyan.fixed.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间工具类
 * @author Administrator
 *
 */
public class TimeUtil {

	/**
	 * 获取当前时间
	 * @return
	 */
	public static String getCurrentTime(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	
	/*
	 * Date 转String 年月日
	 */
	public static String dateToStringWithDay(Date date)
	{
		if(date == null)
		{
			return "";
		}else
		{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
			 
			String str=sdf.format(date);  
			return str;
		}
	}
	/*
	 * Date 转String 年月日时分秒
	 */
	public static String dateToStringWithSecond(Date date)
	{
		if(date == null)
		{
			return "";
		}else
		{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str=sdf.format(date);  
		return str;
		}
	}
	/*
	 * String 转 Date 年月日
	 */
	public static Date stringToDate(String time)
	{
		String[] timeTemp = time.split("-");
		if(timeTemp.length != 3)
			return null;
		int year = Integer.parseInt(timeTemp[0])-1900;
		int month = Integer.parseInt(timeTemp[1]) -1;
		int day = Integer.parseInt(timeTemp[2]);
		Date date = new Date(year,month,day);
		return date;
		
	}

	/*
	 * String 转date seconds
	 */
	public static Date stringToDateSeconds(String time)
	{
		String[] timeTemp1 = time.split(" ");
		
		if(timeTemp1.length != 2)
			return null;
		String[] timeTemp2 = timeTemp1[0].split("-");
		String[] timeTemp3 = timeTemp1[1].split(":");
		
		int year = Integer.parseInt(timeTemp2[0])-1900;
		int month = Integer.parseInt(timeTemp2[1]) -1;
		int day = Integer.parseInt(timeTemp2[2]);
		
		int minutes = Integer.parseInt(timeTemp3[0]);
		int seconds = Integer.parseInt(timeTemp3[1]);
		
		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date date = null;
		date = new Date(year,month,day,minutes,seconds);
		return date;
	}
	public static Date getCurrentTimeDate()
	{
		int year=0;
		int month=0; 
		int day=0;
		int hour=0;
		int min =0;
		int ss = 0;
		Calendar c=Calendar.getInstance();//获得系统当前日期
		year=c.get(Calendar.YEAR)-1900;
		month=c.get(Calendar.MONTH);//系统日期从0开始算起
		day=c.get(Calendar.DAY_OF_MONTH);
		hour=c.get(Calendar.HOUR_OF_DAY);
		min=c.get(Calendar.MINUTE);
		ss=c.get(Calendar.SECOND);
		Date date = new Date(year,month,day,hour,min,ss);
		return date;
	}
	
	/*
	 * 根据月数获取天数 yyyy-MM
	 */
	public static int yearMonthReturnDays(String yearMonth) throws ParseException{
		
		String strDate = "2012-02"; 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM"); 
		Calendar calendar = new GregorianCalendar(); 
		Date date1 = sdf.parse(yearMonth); 
		calendar.setTime(date1); //放入你的日期 
		System.out.println("天数为=" + calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
}
