package com.zy.test.util;

/**
 * <pre>
 * LogTool - com.devsisters.logtool.common
 * </pre>
 *
 * @author Kim Seong Su, Devsisters Corp. Platform team.
 * @since 2012. 2. 26.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <b>기능</b> :
 * <p/>
 * 날짜 및 시간을 시스템으로부터 연산하는 클래스입니다.
 * 
 * @author Administrator
 * @see java.util.Date
 * @since 1.0
 */
public class DateUtils {

	public static final int YEAR = 1;
	public static final int MONTH = 2;
	public static final int DATE = 3;
	public static final int MONTHFIRST = 4;
	public static final int MONTHEND = 5;
	//public static final int WEEKLY_SCORE_RESET_DAY = Calendar.SUNDAY;
	//public static final int WEEKLY_SCORE_RESET_HOUR = 21;
	public static final int WEEKLY_SCORE_RESET_DAY = Calendar.SATURDAY;
	public static final int WEEKLY_SCORE_RESET_HOUR = 22;

	// public static final int WEEKLY_SCORE_RESET_DAY =Calendar.WEDNESDAY;

	public static String convertFormat(String dateString, String fromFormat,
			String toFormat) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(fromFormat);
		SimpleDateFormat outSdf = new SimpleDateFormat(toFormat);
		return outSdf.format(sdf.parse(dateString));
	}

	/**
	 * <p/>
	 * 현재 날짜와 시각을 yyyyMMdd 형태로 변환 후 return.
	 * 
	 * @return yyyyMMdd
	 *         <p/>
	 * 
	 *         <pre>
	 *          - 사용 예
	 *         String date = DateUtil.getYyyymmdd()
	 * </pre>
	 */
	public static String getYyyymmdd(Calendar cal) {
		//Locale currentLocale = new Locale("KOREAN", "KOREA");
		Locale currentLocale = new Locale("CHINESE", "CHINA");
		String pattern = "yyyyMMdd";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern,
				currentLocale);
		return formatter.format(cal.getTime());
	}

	/**
	 * @return YYYY-mm-dd hh:MM:ss
	 * @author Kim Seong Su
	 * @last_modified 2012. 10. 18.
	 */
	public static String getYyyymmddhhMMssNow() {
		return String.format("%tF %tT", Calendar.getInstance(),
				Calendar.getInstance());
	}

	public static String getFormattedDate(Calendar cal, String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(cal.getTime());
	}

	public static Calendar getYesterDay() {
		return DateUtils.getAddDay(-1);
	}

	public static Calendar getAddDay(int dayCount) {
		Calendar caldt = Calendar.getInstance();
		Date dateInit =new DateHelperImpl().getDate();
		caldt.setTime(dateInit);
		caldt.add(Calendar.DATE, dayCount);
		return caldt;
	}
	public static Calendar getAddDay(Long date,int dayCount) {
		Calendar caldt = Calendar.getInstance();
		caldt.setTimeInMillis(date);
		caldt.add(Calendar.DATE, dayCount);
		return caldt;
	}

	public static java.sql.Date getScoreChangeDateNow() {
		return getScoreChangeDate(Calendar.getInstance());
	}

	public static Date getScoreChangeDateNow2() {
		return getScoreChangeDate2(Calendar.getInstance());
	}

	public static java.sql.Date getScoreChangeDatePrevious() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, -24 * 7);
		return getScoreChangeDate(cal);
	}

	public static Date getScoreChangeDatePrevious2() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, -24 * 7);
		return getScoreChangeDate2(cal);
	}

	public static java.sql.Date getScoreChangeDate(Calendar today) {
		//TimeZone pstTime = TimeZone.getTimeZone("Asia/Seoul");
		TimeZone pstTime = TimeZone.getTimeZone("Asia/Shanghai");
		today.setTimeZone(pstTime);
		if (today.get(Calendar.DAY_OF_WEEK) == WEEKLY_SCORE_RESET_DAY
				&& today.get(Calendar.HOUR_OF_DAY) >= WEEKLY_SCORE_RESET_HOUR) {
			today.add(Calendar.DAY_OF_WEEK, 7);
		} else {
			while (today.get(Calendar.DAY_OF_WEEK) != WEEKLY_SCORE_RESET_DAY) {
				today.add(Calendar.DAY_OF_WEEK, 1);
			}
		}
		return java.sql.Date.valueOf(String.format("%tF", today));
	}

	public static Date getScoreChangeDate2(Calendar today) {
		//TimeZone pstTime = TimeZone.getTimeZone("Asia/Seoul");
		TimeZone pstTime = TimeZone.getTimeZone("Asia/Shanghai");
		today.setTimeZone(pstTime);
		if (today.get(Calendar.DAY_OF_WEEK) == WEEKLY_SCORE_RESET_DAY
				&& today.get(Calendar.HOUR_OF_DAY) >= WEEKLY_SCORE_RESET_HOUR) {
			today.add(Calendar.DAY_OF_WEEK, 7);
		} else {
			while (today.get(Calendar.DAY_OF_WEEK) != WEEKLY_SCORE_RESET_DAY) {
				today.add(Calendar.DAY_OF_WEEK, 1);
			}
		}

		// Day 보다 낮은 시간에 대해 고정 값 적용
		today.set(Calendar.HOUR_OF_DAY, WEEKLY_SCORE_RESET_HOUR);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		today.set(Calendar.MILLISECOND, 0);

		return today.getTime();
	}

	public static java.util.Date getNextWeeklyResetTime() {
		Calendar today = Calendar.getInstance();
		//TimeZone pstTime = TimeZone.getTimeZone("Asia/Seoul");
		TimeZone pstTime = TimeZone.getTimeZone("Asia/Shanghai");
		today.setTimeZone(pstTime);
		if (today.get(Calendar.DAY_OF_WEEK) == WEEKLY_SCORE_RESET_DAY
				&& today.get(Calendar.HOUR_OF_DAY) >= WEEKLY_SCORE_RESET_HOUR) {
			today.add(Calendar.DAY_OF_WEEK, 7);
		} else {
			while (today.get(Calendar.DAY_OF_WEEK) != WEEKLY_SCORE_RESET_DAY) {
				today.add(Calendar.DAY_OF_WEEK, 1);
			}
		}
		today.set(Calendar.HOUR_OF_DAY, WEEKLY_SCORE_RESET_HOUR);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		today.set(Calendar.MILLISECOND, 0);
		return new java.util.Date(today.getTimeInMillis());
	}

	public static java.util.Date getPrevWeeklyResetTime() {
		Calendar today = Calendar.getInstance();
		today.setTime(getNextWeeklyResetTime());
		today.add(Calendar.HOUR, -24 * 7);
		return new java.util.Date(today.getTimeInMillis());
	}

	/**
	 * <p/>
	 * GregorianCalendar 객체를 반환함.
	 * 
	 * @param yyyymmdd
	 *            날짜 인수
	 * @return GregorianCalendar
	 * @see java.util.Calendar
	 * @see java.util.GregorianCalendar <p>
	 *      <p/>
	 * 
	 *      <pre>
	 *       - 사용 예
	 *      Calendar cal = DateUtil.getGregorianCalendar(DateUtil.getCurrentYyyymmdd())
	 * </pre>
	 */
	public static GregorianCalendar getGregorianCalendar(String yyyymmdd) {

		int yyyy = Integer.parseInt(yyyymmdd.substring(0, 4));
		int mm = Integer.parseInt(yyyymmdd.substring(4, 6));
		int dd = Integer.parseInt(yyyymmdd.substring(6));

		return new GregorianCalendar(yyyy, mm - 1, dd, 0, 0, 0);

	}

	/**
	 * <p/>
	 * 현재 날짜와 시각을 yyyyMMddhhmmss 형태로 변환 후 return.
	 * 
	 * @return yyyyMMddhhmmss
	 * @see java.util.Date
	 * @see java.util.Locale <p>
	 *      <p/>
	 * 
	 *      <pre>
	 *       - 사용 예
	 *      String date = DateUtil.getCurrentDateTime()
	 * </pre>
	 */
	public static String getCurrentDateTime() {
		Date today = new DateHelperImpl().getDate();
		//Locale currentLocale = new Locale("KOREAN", "KOREA");
		Locale currentLocale = new Locale("CHINESE", "CHINA");
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern,
				currentLocale);
		return formatter.format(today);
	}

	/**
	 * <p/>
	 * 현재 시각을 hhmmss 형태로 변환 후 return.
	 * 
	 * @return hhmmss
	 * @see java.util.Date
	 * @see java.util.Locale <p>
	 *      <p/>
	 * 
	 *      <pre>
	 *       - 사용 예
	 *        String date = DateUtil.getCurrentDateTime()
	 * </pre>
	 */
	public static String getCurrentTime() {
		Date today = new DateHelperImpl().getDate();
		//Locale currentLocale = new Locale("KOREAN", "KOREA");
		Locale currentLocale = new Locale("CHINESE", "CHINA");
		String pattern = "HHmmss";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern,
				currentLocale);
		return formatter.format(today);

	}

	/**
	 * <p/>
	 * 현재 날짜를 yyyyMMdd 형태로 변환 후 return.
	 * 
	 * @return yyyyMMdd *
	 *         <p/>
	 *         <p/>
	 * 
	 *         <pre>
	 *          - 사용 예
	 *         String date = DateUtil.getCurrentYyyymmdd()
	 * </pre>
	 */
	public static String getCurrentYyyymmdd() {
		return getCurrentDateTime().substring(0, 8);
	}

	/**
	 * <p/>
	 * 주로 일자를 구하는 메소드.
	 * 
	 * @param yyyymm
	 *            년월
	 * @param week
	 *            몇번째 주
	 * @param pattern
	 *            리턴되는 날짜패턴 (ex:yyyyMMdd)
	 * @return 연산된 날짜
	 * @see java.util.Calendar <p>
	 *      <p/>
	 * 
	 *      <pre>
	 *       - 사용 예
	 *      String date = DateUtil.getWeekToDay("200801" , 1, "yyyyMMdd")
	 * </pre>
	 */
	@SuppressWarnings("static-access")
	public static String getWeekToDay(String yyyymm, int week, String pattern) {

		Calendar cal = Calendar.getInstance();

		int new_yy = Integer.parseInt(yyyymm.substring(0, 4));
		int new_mm = Integer.parseInt(yyyymm.substring(4, 6));
		int new_dd = 1;

		cal.set(new_yy, new_mm - 1, new_dd);

		// 임시 코드
		if (cal.get(cal.DAY_OF_WEEK) == cal.SUNDAY) {
			week = week - 1;
		}

		cal.add(Calendar.DATE,
				(week - 1)
						* 7
						+ (cal.getFirstDayOfWeek() - cal
								.get(Calendar.DAY_OF_WEEK)));

		SimpleDateFormat formatter = new SimpleDateFormat(pattern);

		return formatter.format(cal.getTime());

	}

	/**
	 * <p/>
	 * 지정된 플래그에 따라 연도 , 월 , 일자를 연산한다.
	 * 
	 * @param field
	 *            연산 필드
	 * @param amount
	 *            더할 수
	 * @param date
	 *            연산 대상 날짜
	 * @return 연산된 날짜
	 * @see java.util.Calendar <p>
	 *      <p/>
	 * 
	 *      <pre>
	 *       - 사용 예
	 *      String date = DateUtil.getOpDate(java.util.Calendar.DATE , 1, "20080101")
	 * </pre>
	 */
	public static String getOpDate(int field, int amount, String date) {

		GregorianCalendar calDate = getGregorianCalendar(date);

		if (field == Calendar.YEAR) {
			calDate.add(GregorianCalendar.YEAR, amount);
		} else if (field == Calendar.MONTH) {
			calDate.add(GregorianCalendar.MONTH, amount);
		} else {
			calDate.add(GregorianCalendar.DATE, amount);
		}

		return getYyyymmdd(calDate);

	}

	/**
	 * <p/>
	 * 입력된 일자를 더한 주를 구하여 return한다
	 * 
	 * @param yyyymmdd
	 *            년도별
	 * @param addDay
	 *            추가일
	 * @return 연산된 주
	 * @see java.util.Calendar <p>
	 *      <p/>
	 * 
	 *      <pre>
	 *       - 사용 예
	 *      int date = DateUtil.getWeek(DateUtil.getCurrentYyyymmdd() , 0)
	 * </pre>
	 */
	public static int getWeek(String yyyymmdd, int addDay) {
		Calendar cal = Calendar.getInstance();
		int new_yy = Integer.parseInt(yyyymmdd.substring(0, 4));
		int new_mm = Integer.parseInt(yyyymmdd.substring(4, 6));
		int new_dd = Integer.parseInt(yyyymmdd.substring(6, 8));

		cal.set(new_yy, new_mm - 1, new_dd);
		cal.add(Calendar.DATE, addDay);

		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * <p/>
	 * 입력된 년월의 마지막 일수를 return 한다.
	 * 
	 * @param year
	 * @param month
	 * @return 마지막 일수
	 * @see java.util.Calendar <p>
	 *      <p/>
	 * 
	 *      <pre>
	 *       - 사용 예
	 *      int date = DateUtil.getLastDayOfMon(2008 , 1)
	 * </pre>
	 */
	public static int getLastDayOfMon(int year, int month) {

		Calendar cal = Calendar.getInstance();
		cal.set(year, month, 1);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);

	}// :

	/**
	 * <p/>
	 * 입력된 년월의 마지막 일수를 return한다
	 * 
	 * @return 마지막 일수
	 *         <p/>
	 *         <p/>
	 * 
	 *         <pre>
	 *          - 사용 예
	 *         int date = DateUtil.getLastDayOfMon("2008")
	 * </pre>
	 */
	public static int getLastDayOfMon(String yyyymm) {

		Calendar cal = Calendar.getInstance();
		int yyyy = Integer.parseInt(yyyymm.substring(0, 4));
		int mm = Integer.parseInt(yyyymm.substring(4)) - 1;

		cal.set(yyyy, mm, 1);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * <p/>
	 * 입력된 날자가 올바른지 확인합니다.
	 * 
	 * @param yyyymmdd
	 * @return boolean
	 *         <p/>
	 *         <p/>
	 * 
	 *         <pre>
	 *          - 사용 예
	 *         boolean b = DateUtil.isCorrect("20080101")
	 * </pre>
	 */
	public static boolean isCorrect(String yyyymmdd) {
		boolean flag;
		if (yyyymmdd.length() < 8) {
			return false;
		}
		try {
			int yyyy = Integer.parseInt(yyyymmdd.substring(0, 4));
			int mm = Integer.parseInt(yyyymmdd.substring(4, 6));
			int dd = Integer.parseInt(yyyymmdd.substring(6));
			flag = DateUtils.isCorrect(yyyy, mm, dd);
		} catch (Exception ex) {
			return false;
		}
		return flag;
	}// :

	/**
	 * <p/>
	 * 입력된 날자가 올바른 날자인지 확인합니다.
	 * 
	 * @param yyyy
	 * @param mm
	 * @param dd
	 * @return boolean
	 *         <p/>
	 *         <p/>
	 * 
	 *         <pre>
	 *          - 사용 예
	 *         boolean b = DateUtil.isCorrect(2008,1,1)
	 * </pre>
	 */
	public static boolean isCorrect(int yyyy, int mm, int dd) {
		if (yyyy < 0 || mm < 0 || dd < 0) {
			return false;
		}
		if (mm > 12 || dd > 31) {
			return false;
		}

		String year = "" + yyyy;
		String month = "00" + mm;
		String year_str = year + month.substring(month.length() - 2);
		int endday = DateUtils.getLastDayOfMon(year_str);

		return dd <= endday;

	}// :

	/**
	 * <p/>
	 * 현재 일자를 입력된 type의 날짜로 반환합니다.
	 * 
	 * @param type
	 * @return String
	 * @see java.text.DateFormat <p>
	 *      <p/>
	 * 
	 *      <pre>
	 *       - 사용 예
	 *      String date = DateUtil.getThisDay("yyyymmddhhmmss")
	 * </pre>
	 */
	public static String getThisDay(String type) {
		Date date = new DateHelperImpl().getDate();
		SimpleDateFormat sdf;

		try {
			if (type.toLowerCase().equals("yyyymmdd")) {
				sdf = new SimpleDateFormat("yyyyMMdd");
				return sdf.format(date);
			}
			if (type.toLowerCase().equals("yyyymmddhh")) {
				sdf = new SimpleDateFormat("yyyyMMddHH");
				return sdf.format(date);
			}
			if (type.toLowerCase().equals("yyyymmddhhmm")) {
				sdf = new SimpleDateFormat("yyyyMMddHHmm");
				return sdf.format(date);
			}
			if (type.toLowerCase().equals("yyyymmddhhmmss")) {
				sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				return sdf.format(date);
			}
			if (type.toLowerCase().equals("yyyymmddhhmmssms")) {
				sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				return sdf.format(date);
			} else {
				sdf = new SimpleDateFormat(type);
				return sdf.format(date);
			}
		} catch (Exception e) {
			return "[ ERROR ]: parameter must be 'YYYYMMDD', 'YYYYMMDDHH', 'YYYYMMDDHHSS'or 'YYYYMMDDHHSSMS'";
		}
	}

	/**
	 * <p/>
	 * 입력된 일자를 '9999년 99월 99일' 형태로 변환하여 반환한다.
	 * 
	 * @param yyyymmdd
	 * @return String
	 *         <p/>
	 *         <p/>
	 * 
	 *         <pre>
	 *          - 사용 예
	 *         String date = DateUtil.changeDateFormat("20080101")
	 * </pre>
	 */
	public static String changeDateFormat(String yyyymmdd) {
		String rtnDate;

		String yyyy = yyyymmdd.substring(0, 4);
		String mm = yyyymmdd.substring(4, 6);
		String dd = yyyymmdd.substring(6, 8);
		rtnDate = yyyy + " 年 " + mm + " 月 " + dd + " 日";

		return rtnDate;

	}

	/**
	 * <p/>
	 * 두 날짜간의 날짜수를 반환(윤년을 감안함)
	 * 
	 * @param startDate
	 *            시작 날짜
	 * @param endDate
	 *            끝 날짜
	 * @return 날수
	 * @see java.util.GregorianCalendar <p>
	 *      <p/>
	 * 
	 *      <pre>
	 *       - 사용 예
	 *      long date = DateUtil.getDifferDays("20080101","20080202")
	 * </pre>
	 */
	public static long getDifferDays(String startDate, String endDate) {

		GregorianCalendar StartDate = getGregorianCalendar(startDate);
		GregorianCalendar EndDate = getGregorianCalendar(endDate);
		return (EndDate.getTime().getTime() - StartDate.getTime().getTime()) / 86400000;

	}

	/**
	 * <p/>
	 * 현재의 요일을 구한다.
	 * 
	 * @param
	 * @return 요일
	 * @see java.util.Calendar <p>
	 *      <p/>
	 * 
	 *      <pre>
	 *       - 사용 예
	 *      int day = DateUtil.getDayOfWeek()
	 *       SUNDAY    = 1
	 *       MONDAY    = 2
	 *       TUESDAY   = 3
	 *       WEDNESDAY = 4
	 *       THURSDAY  = 5
	 *       FRIDAY    = 6
	 * </pre>
	 */
	public static int getDayOfWeek() {
		Calendar rightNow = Calendar.getInstance();
		return rightNow.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * <p/>
	 * 현재주가 올해 전체의 몇째주에 해당되는지 계산한다.
	 * 
	 * @param
	 * @return 요일
	 * @see java.util.Calendar <p>
	 *      <p/>
	 * 
	 *      <pre>
	 *       - 사용 예
	 *      int day = DateUtil.getWeekOfYear()
	 * </pre>
	 */
	public static int getWeekOfYear() {
		Locale LOCALE_COUNTRY = Locale.KOREA;
		Calendar rightNow = Calendar.getInstance(LOCALE_COUNTRY);
		return rightNow.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * <p/>
	 * 현재주가 현재월에 몇째주에 해당되는지 계산한다.
	 * 
	 * @param
	 * @return 요일
	 * @see java.util.Calendar <p>
	 *      <p/>
	 * 
	 *      <pre>
	 *       - 사용 예
	 *      int day = DateUtil.getWeekOfMonth()
	 * </pre>
	 */
	public static int getWeekOfMonth() {
		Locale LOCALE_COUNTRY = Locale.KOREA;
		Calendar rightNow = Calendar.getInstance(LOCALE_COUNTRY);
		return rightNow.get(Calendar.WEEK_OF_MONTH);
	}

	/**
	 * <p/>
	 * 해당 p_date날짜에 Calendar 객체를 반환함.
	 * 
	 * @param p_date
	 * @return Calendar
	 * @see java.util.Calendar <p>
	 *      <p/>
	 * 
	 *      <pre>
	 *       - 사용 예
	 *      Calendar cal = DateUtil.getCalendarInstance(DateUtil.getCurrentYyyymmdd())
	 * </pre>
	 */
	public static Calendar getCalendarInstance(String p_date) {
		Calendar retCal = Calendar.getInstance();

		if (p_date != null && p_date.length() == 8) {
			int year = Integer.parseInt(p_date.substring(0, 4));
			int month = Integer.parseInt(p_date.substring(4, 6)) - 1;
			int date = Integer.parseInt(p_date.substring(6));

			retCal.set(year, month, date);
		}
		return retCal;
	}

	/**
	 * <p/>
	 * 해당 p_date날짜에 Calendar 객체를 반환함.
	 * 
	 * @param p_date
	 * @return Calendar
	 * @see java.util.Calendar <p>
	 *      <p/>
	 * 
	 *      <pre>
	 *       - 사용 예
	 *      Calendar cal = DateUtil.getCalendarInstance(DateUtil.getCurrentYyyymmdd())
	 * </pre>
	 */
	public static Calendar getCalendarInstance(Date p_date) {
		if (p_date == null) {
			return null;
		}
		Calendar retCal = Calendar.getInstance();
		retCal.setTime(p_date);
		return retCal;
	}

	public static long diffRestoreTime(long lifeRestoredTime,
			long lifeRestoreTime) {
		return Calendar.getInstance().getTimeInMillis() - lifeRestoreTime
				- lifeRestoredTime;
	}
	
}