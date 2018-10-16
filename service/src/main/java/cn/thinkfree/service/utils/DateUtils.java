package cn.thinkfree.service.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xusonghui
 */
public class DateUtils {
    /**
     * 时间格式化
     * @param strDate
     * @param format
     * @return
     */
    public static Date strToDate(String strDate,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date(0);
    }
    /**
     * 时间格式化
     * @param strDate
     * 格式：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date strToDate(String strDate){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date(0);
    }

    /**
     * 时间格式化
     * @param date
     * @param format
     * @return
     */
    public static String dateToStr(Date date,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 时间格式化
     * @param date
     * 格式：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String dateToStr(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
