package com.whut.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * 目前的功能就是把new Date()转换成特定格式的字符串。
 * @author Edward
 *
 */
public class DateUtils {

	public static String getCurrentDate(){
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss"); 
	    String ctime = formatter.format(date); 
	    return ctime;
	}
}
