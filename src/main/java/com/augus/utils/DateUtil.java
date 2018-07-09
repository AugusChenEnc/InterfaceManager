package com.augus.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * date util
 * @author Augus
 * @date 2018/7/9 11:40
 */
public class DateUtil {

    /**
     * getExpiresDate （获取超时时间）
     * @param calendarField
     * @param calendarInterval
     * @return
     */
    public static Date getExpiresDate(int calendarField, int calendarInterval) {
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(calendarField, calendarInterval);
        Date expiresDate = nowTime.getTime();
        return expiresDate;
    }



}
