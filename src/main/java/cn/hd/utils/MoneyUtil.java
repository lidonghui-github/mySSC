package cn.hd.utils;

import java.math.BigDecimal;

/**
 * @Author :Created by
 * @Date : 2016/4/14 10:12
 * @Description: 关于交易金额的工具类
 */
public class MoneyUtil {

    /**
     * @param :double
     * @return
     */
    public static boolean isNull(double money) {
        if (0 == money) return true;
        else return false;
    }

    /**
     * @param :BigDecimal
     * @return
     */
    public static boolean isNull(BigDecimal money) {
        if (money == null || 0 == money.doubleValue()) return true;
        else return false;
    }


//    public getMoneyStyle(BigDecimal bigDecimal,){
//
//       return bigDecimal.setScale(6, BigDecimal.ROUND_HALF_UP);
//
//    }

    /**
     * 当金额为空时替换为0
     *
     * @param money
     * @return
     */
    public static BigDecimal ifNull(BigDecimal money) {
        if (money == null) {
            money = new BigDecimal(0.00);
        }
        return money;
    }

    /**
     * 判断输入金额是否无效
     *
     * @param money
     * @return
     */
    public static boolean isNotVald(BigDecimal money) {
        if (money != null && money.doubleValue() < 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断金额是否为0
     *
     * @param money
     * @return
     */
    public static boolean isZero(BigDecimal money) {
        if (money != null && money.doubleValue() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 比较2个数的大小
     * @param a
     * @param b
     * @return
     */
    public static boolean compareWith(BigDecimal a, BigDecimal b) {
        if (a == null || b == null) {
            return false;
        } else {
            if (a.compareTo(b) >= 0) {
                return true;
            }
        }
        return false;
    }
}
