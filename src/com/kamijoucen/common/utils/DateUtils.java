package com.kamijoucen.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    /**
     * 根据指定的格式字符串格式化一个日期
     * @param date
     * @param formatStr
     * @return
     */
    public static String format(Date date, String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.format(date);
    }


    /**
     * 将一种格式的日期字符串转换为另一种格式
     * @param src 待转换的字符串
     * @param srcFmt 源格式
     * @param targetFmt 目标格式
     * @return
     */
    public static String convertFormat(String src, String srcFmt, String targetFmt) {
        SimpleDateFormat sfmt = new SimpleDateFormat(srcFmt);
        Date time = null;
        try {
            time = sfmt.parse(src);
        } catch (ParseException e) {
            e.printStackTrace();
            time = new Date();
        }
        SimpleDateFormat tFmt = new SimpleDateFormat(targetFmt);
        return tFmt.format(time);
    }

}
