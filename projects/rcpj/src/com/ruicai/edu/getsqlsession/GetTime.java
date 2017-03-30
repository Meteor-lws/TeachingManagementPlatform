package com.ruicai.edu.getsqlsession;
/*
 * 时间类
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class GetTime {
	public static String gettime()
	{
		Date date=new Date();
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=dateFormat.format(date);
		return time;
	}

}
