package com.liuyk.asimple.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static Date localDateTime2Date(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDateTime date2localDateTime(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public static Date accurateMinutes(Date date) {
        return DateUtil.localDateTime2Date(DateUtil.date2localDateTime(date).withSecond(0));
    }

    public static Date accurateHour(Date date) {
        return DateUtil.localDateTime2Date(DateUtil.date2localDateTime(date).withMinute(0).withSecond(0));
    }

    public static Date accurateDay(Date date) {
        return DateUtil.localDateTime2Date(DateUtil.date2localDateTime(date).withHour(0).withMinute(0).withSecond(0));
    }

    public static int unixTimeStamp(Date date) {
        return (int) (date.getTime()/1000);
    }

    public static Date parseDate(String dateStr) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DEFAULT_PATTERN);
        return localDateTime2Date(LocalDateTime.parse(dateStr, df));
    }

}