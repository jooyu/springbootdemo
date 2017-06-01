package com.zy.test.util;

import java.util.Calendar;
import java.util.Date;

public interface DateHelper {
	public Calendar getCalendar();

	public long getTimeInMillis();

	public Date getDate();

	/**
	 * 获取当天日期，只有日期，时间参数全为0
	 * 
	 * @return Date
	 */
	public Date onlydate();

	/**
	 * 将日期转化为yyyy-MM-dd的格式
	 * 
	 * @param date
	 * @return
	 */
	public String dateToYYYY_MM_DD(Date date);

	/**
	 * 判断输入的日期是否是今天之前的日期
	 * 
	 * @param date
	 * @return
	 */
	public boolean isBeforeTodayDate(Date date);

	/**
	 * 获取当前月份
	 * 
	 * @return
	 */
	public int getCurrMonth();

	/**
	 * 获取当前日
	 * 
	 * @return
	 */
	public int getCurrDay();

	public int getIntervalDays(Date startday, Date endday);
}
