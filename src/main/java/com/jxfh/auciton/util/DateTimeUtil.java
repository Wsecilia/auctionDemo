package com.jxfh.auciton.util;

import org.apache.commons.lang3.time.DateFormatUtils;
import java.util.Date;

public final class DateTimeUtil {

    public static final String yyyyMMdd = "yyyyMMdd";//年月日格式不带间隔

    /**
     * @duthor: xingyongchun
     * @description: 格式化日期为yyyyMMdd格式
     * @param: curdate
     * @date: 2018/4/4
     * @return: java.lang.String
     */
    public static String getDateYMDString(Date curdate) {
        String format = DateFormatUtils.format(curdate, yyyyMMdd);
        return format;
    }

}
