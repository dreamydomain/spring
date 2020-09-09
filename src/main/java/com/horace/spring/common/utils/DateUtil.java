package com.horace.spring.common.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
    private DateUtil() {
    }

    public static Date addHours(Date date, int hours) {
        if (date == null) {
            return null;
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hours);
        date = calendar.getTime();
        return date;
    }

    public static Date newDate(int year, int month, int day) {
        Calendar calendar = new GregorianCalendar();
        calendar.set(year, month, day);
        return calendar.getTime();
    }

    public static int howManyMonths(Date start, Date end) {
        return (end.getYear() - start.getYear())*12 + (end.getMonth() - start.getMonth()) + 1;
    }
}
