package com.zy.test.util;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelperMock implements DateHelper {
    Calendar calendar;
    /**
	 * 日期初始化对象，yyyy-MM-dd
	 */
	private SimpleDateFormat sdf_yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");

    public DateHelperMock(Calendar calendar) {
        this.calendar = calendar;
    }

    public DateHelperMock(String dateText) throws ParseException {
        this(dateText, "yyyy-MM-dd HH:mm:ss");
    }

    public DateHelperMock(String dateText, String format) throws ParseException {
        Date date = DateUtils.parseDate(dateText, format);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        this.calendar = cal;
    }

    @Override
    public Calendar getCalendar() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(this.calendar.getTimeInMillis());
        return cal;
    }

    @Override
    public long getTimeInMillis() {
        return this.calendar.getTimeInMillis();
    }

    @Override
    public Date getDate() {
        return this.calendar.getTime();
    }
    
    @Override
	public Date onlydate() {
		Date result = null;
		try {
			result = sdf_yyyy_MM_dd.parse(sdf_yyyy_MM_dd.format(getCalendar()));
		} catch (ParseException e) {
			// 转换规则经过测试，无需做任何处理
		}
		return result;
	}

	@Override
	public String dateToYYYY_MM_DD(Date date) {
		return sdf_yyyy_MM_dd.format(date);
	}

	@Override
	public boolean isBeforeTodayDate(Date date) {
		boolean result = false;
		if (onlydate().after(date)) {
			result = true;
		}

		return result;
	}

	@Override
	public int getCurrMonth() {
		return getCalendar().get(Calendar.MONTH) + 1;
	}

	@Override
	public int getCurrDay() {
		return getCalendar().get(Calendar.DATE);
	}

    @Override
    public int getIntervalDays(Date startday, Date endday) {
        try {
            if (startday == null || endday == null) {
                return 0;
            }
            if (startday.after(endday)) {
                Date cal = startday;
                startday = endday;
                endday = cal;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            startday = sdf.parse(sdf.format(startday));
            endday = sdf.parse(sdf.format(endday));
            Calendar cal = Calendar.getInstance();
            cal.setTime(startday);
            long time1 = cal.getTimeInMillis();
            cal.setTime(endday);
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);

            return Integer.parseInt(String.valueOf(between_days));
        } catch (ParseException e) {
            return 0;
        }
    }
}
