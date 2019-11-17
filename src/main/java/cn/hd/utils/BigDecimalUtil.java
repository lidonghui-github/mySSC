package cn.hd.utils;

import java.math.BigDecimal;

/**
 * Created by on 2016/7/11.
 */
public class BigDecimalUtil {
    public static BigDecimal add(BigDecimal a, BigDecimal b) {
        if (a == null) {
            return b;
        } else {
            if (b == null) {
                return a;
            } else {
                return a.add(b);
            }
        }
    }

    public static BigDecimal multiply(BigDecimal a, BigDecimal b) {
        if (a == null) {
            return new BigDecimal(0);
        } else {
            if (b == null) {
                return new BigDecimal(0);
            } else {
                return a.multiply(b);
            }
        }
    }

    public static BigDecimal subtract(BigDecimal a, BigDecimal b) {
        if (a == null) {
            if (b == null) {
                return new BigDecimal(0);
            } else {
                return b.negate();
            }
        } else {
            if (b == null) {
                return a;
            } else {
                return a.subtract(b);
            }
        }
    }

    public static BigDecimal subtract1(BigDecimal a, BigDecimal b) {
        if (a == null) {
            return null;
        } else {
            return a.subtract(b);
        }
    }

    public static BigDecimal divide(BigDecimal a, BigDecimal b, int doubleLength) {
        if (null == b) {
            return null;
        } else {
            if (null == a) {
                return new BigDecimal("0.00");
            } else {
                return a.divide(b, doubleLength);
            }
        }
    }


    public static boolean bigger(BigDecimal a1, BigDecimal a2) {
        if (a1 == null) {
            return false;
        }
        if (a2 == null) {
            return false;
        }
        return a1.compareTo(a2) > 0;
    }

    /**
     * 比较金额的大小，当金额为null时，将金额设置为0.00，防止空指针的发生
     *
     * @param a1
     * @param a2
     * @return
     */
    public static boolean biggerWithNull(BigDecimal a1, BigDecimal a2) {
        if (a1 == null) {
            a1 = new BigDecimal(0.00);
        }
        if (a2 == null) {
            a2 = new BigDecimal(0.00);
        }
        return a1.compareTo(a2) > 0;
    }

    public static Integer add(Integer a1, Integer a2) {
        return a1.intValue() + a2.intValue();
    }

    public static Integer subtract1(Integer a1, Integer a2) {
        return a1.intValue()-a2.intValue();
    }

    public static Long subtract2(Long a1, Long a2) {
        return a1.longValue()-a2.longValue();
    }
}
