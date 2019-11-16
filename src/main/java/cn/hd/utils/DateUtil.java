package cn.hd.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author :Created by
 * @Date : 2016/4/14 16:12
 * @Description:
 */
public class DateUtil {

    private static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    private static final String DATE_FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
    /**
     * 毫秒时间数据专用表达式。
     * "2020-10-13-15.23.47.136123";
     */
    private static final String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd-HH.mm.ss.SSS";
    private static final String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd-HH.mm.ss";
    /**
     * yyyy-mm-dd
     * @return
     */
    public static Date getCurrentDate(){
        return DateUtil.parser(DATE_FORMAT_YYYY_MM_DD);
    }
    /**
     * yyyy-mm-dd HH:mm:ss
     * @return
     */
    public static Date getCurrentDateTime(){
        return DateUtil.parser(DATE_FORMAT_DATE_TIME);
    }

    /**
     * 日期字符串格式化YYYYMMDD
     * @param date
     * @return
     */
    public static Date dateFormate(String date){
        SimpleDateFormat sdf =new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static Date dateFormate_ldh(String date){
        SimpleDateFormat sdf =new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 毫秒时间数据专用表达式转换方法 返回时间，如果不能转换则返回当前时间。
     * "2020-10-13-15.23.47.136123";
     * @param timeStr
     * @return
     */
    public static Date dateFormateOFSSS(String timeStr){
        SimpleDateFormat sdf =new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS);
        if(timeStr.length()==26){
            timeStr = timeStr.substring(0,timeStr.length()-3);
        }else{
            sdf =new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
        }

        try {
            return sdf.parse(timeStr);
        } catch (ParseException e) {
            //e.printStackTrace();
            //throw new RuntimeException(e);
            return new Date();
        }
    }

    /**
     * 日期YYYYMMDD格式化成字符串YYYYMMDD
     * @param date
     * @return
     */
    public static String dateFormate(Date date){
        SimpleDateFormat sdf =new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
        try {
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    /**
     * 日期YYYYMMDD格式化成字符串YYYYMMDD
     * @param date
     * @return
     */
    public static String dateFormate2(Date date){
        SimpleDateFormat sdf =new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
        try {
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期YYYYMMDD加月份
     * @param date
     * @param month
     * @return
     */
    public static Date dateAppendMonth(Date date,int month){
        SimpleDateFormat sdf =new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
        try {
            Date dt = sdf.parse(dateFormate(date));
            Calendar cld = Calendar.getInstance();
            cld.setTime(dt);
            cld.add(Calendar.MONTH, month);
            return cld.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static Date dateAppendDay(Date date,int day){
        SimpleDateFormat sdf =new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
        try {
            Date dt = sdf.parse(dateFormate(date));
            Calendar cld = Calendar.getInstance();
            cld.setTime(dt);
            cld.add(Calendar.DAY_OF_YEAR, day);
            return cld.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static Date dateAppendYear(Date date,int year){
        SimpleDateFormat sdf =new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
        try {
            Date dt = sdf.parse(dateFormate(date));
            Calendar cld = Calendar.getInstance();
            cld.setTime(dt);
            cld.add(Calendar.YEAR, year);
            return cld.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static Date parser(String formatter){
        SimpleDateFormat sdf =new SimpleDateFormat(formatter);
        try {
            return sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static  void main(String[] args){
//        System.out.println(getCurrentDate());
//        System.out.println(getCurrentDateTime());
//        System.out.println("字符串转Date = "+dateFormate("20150425"));
        System.out.println("日期+月 = "+dateAppendMonth(new Date(),3));
    }
    public static int getMonths(Date date1,Date date2){
        int iMonth=0;
//        int flag = 0;
        try{
            Calendar c1 = Calendar.getInstance();
            c1.setTime(date1);
            Calendar c2 = Calendar.getInstance();
            c2.setTime(date2);
            if (c1.equals(c2)){
                return 0;
            }
            if (c1.after(c2)){
                Calendar temp = c1;
                c1 = c2;
                c2= temp;
            }
//            if (c2.get(Calendar.DAY_OF_MONTH)<c1.get(Calendar.DAY_OF_MONTH)){
//                flag=1;
//            }
            if (c2.get(Calendar.YEAR)>c1.get(Calendar.YEAR)){
                iMonth = ((c2.get(Calendar.YEAR)-c1.get(Calendar.YEAR))*12
                        +c2.get(Calendar.MONTH))
                        -c1.get(Calendar.MONTH);
            }else {
                iMonth = c2.get(Calendar.MONTH)-c1.get(Calendar.MONTH);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return iMonth;
    }
}
