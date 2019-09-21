package cn.hd.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.UUID;

/**
 * @Author :Created by
 * @Date : 2016/4/13 19:55
 * @Description: 获取交易流水号 或唯一主键
 */
public class UUIDUtil {

    public static String getId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String args[]) {
        String s = UUID.randomUUID().toString();
        System.out.println(s);
        Double a = 0.00;
        System.out.println(s);
        System.out.println(new Date(System.currentTimeMillis()));

    }

    public static String getNumId() {
        //系统名称 4位字符串
        String apid = "LCMS";
        //时间戳 17位字符串
        String s = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
        //随机数 7位字符串，补足11位用0补齐
        String str = String.valueOf(new Random().nextInt(10000000));
        String rannum = StringUtil.getSubString(str, 0, 11);
        //32位字符串
        s = apid + s + rannum;
        return s;
    }
}
