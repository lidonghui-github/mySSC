package cn.hd.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateUtil {

	public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
	public static final String DATE_FORMAT_YYYY_MM_DD_HH = "yyyy-MM-dd HH";
	public static final String DATE_FORMAT_YYYY_MM_DD_hh = "yyyy-MM-dd hh";
	public static final String DATE_FORMAT_YYYY_MM_DD_HH_mm = "yyyy-MM-dd HH:mm";
	public static final String DATE_FORMAT_YYYY_MM_DD_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
	/**
	 * ������ת�����ַ���:��-��-��
	 * @param date
	 * @return
	 */
	public static String dateFormate_YYYY_MM_DD(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
		return sdf.format(date);
	}
	/**
	 * ������ת�����ַ���:��-��-�� ʱ (24ʱ)
	 * @param date
	 * @return
	 */
	public static String dateFormate_YYYY_MM_DD_HH(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD_HH);
		return sdf.format(date);
	}
	/**
	 * ������ת�����ַ���:��-��-�� ʱ (12ʱ)
	 * @param date
	 * @return
	 */
	public static String dateFormate_YYYY_MM_DD_hh(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD_hh);
		return sdf.format(date);
	}
	/**
	 * ������ת�����ַ���:��-��-�� ʱ : ��
	 * @param date
	 * @return
	 */
	public static String dateFormate_YYYY_MM_DD_HH_mm (Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD_HH_mm);
		return sdf.format(date);
	}
	
	
	/**
	 * ������ת�����ַ���:��-��-�� ʱ :��:��
	 * @param date
	 * @return
	 */
	public static String dateFormate_YYYY_MM_DD_HH_mm_ss (Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD_HH_mm_ss);
		return sdf.format(date);
	}
    /**
     * ���ַ���ת��������
     * @param sorce
     * @return
     * @throws ParseException
     */
	public static Date dateFrom_YYYY_MM_DD(String sorce)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(sorce);

		return sdf.parse(sdf.format(new Date()));

	}

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.println(date);
		System.out.println(dateFormate_YYYY_MM_DD(date));
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
		String dateStr="2019-08-13";
		System.out.println(sdf.parse(dateStr));
		System.out.println(dateFormate_YYYY_MM_DD_HH(date));
		System.out.println(dateFormate_YYYY_MM_DD_hh(date));
		System.out.println(dateFormate_YYYY_MM_DD_HH_mm(date));
		System.out.println(dateFormate_YYYY_MM_DD_HH_mm_ss(date));
	}

}
