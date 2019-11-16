package cn.hd.utils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2016/4/11.
 */
public class StringUtil {
    public final static BigDecimal ZERO = new BigDecimal("0.000001");

    public static void main(String[] args) {
        Exception ex = new Exception("aaa");
        System.out.println(StringUtil.getExStackTrace(ex));

        System.out.println(StringUtil.isEquals(null, null, true));
        System.out.println(StringUtil.isEquals(null, "", true));
        System.out.println(StringUtil.isEquals("", null, true));
        System.out.println(StringUtil.isEquals(null, null, false));
        System.out.println(StringUtil.isEquals(null, "", false));
        System.out.println(StringUtil.isEquals("", null, false));
        System.out.println(StringUtil.isEquals("", "", true));
        System.out.println(StringUtil.isEquals("", "", false));
    }

    public static String getExStackTrace(Throwable ex) {
        StringBuffer sb = new StringBuffer(1000);
        sb.append(ex.getClass().getName());
        sb.append(":");
        sb.append(ex.getMessage());
        StackTraceElement[] stackTrace = ex.getStackTrace();
        for (StackTraceElement st : stackTrace) {
            sb.append("\r\n    ");
            sb.append("at ");
            sb.append(st.getMethodName());
            sb.append("(");
            sb.append(st.getClassName());
            sb.append(".java:");
            sb.append(st.getLineNumber());
            sb.append(")");
        }
        return sb.toString();
    }

    public static boolean isNull(String s) {
        return s == null || s.equals("null") || s.trim().length() < 1 || s.equalsIgnoreCase("undefine") || s.equalsIgnoreCase("undefined");
    }

    public static boolean isNull(Double d) {
        return d == null;
    }

    public static boolean isNull(Date d) {
        return d == null;
    }

    public static boolean isNull(Integer d) {
        return d == null;
    }
    public static boolean isNull(Long d) {
        return d == null;
    }
    public static boolean isNotNull(String s) {
        return s != null && s.trim().length() > 0 && (!"null".equals(s.trim()));
    }

    public static boolean isNull(BigDecimal apprAmt) {
        return apprAmt == null;
    }

    public static int ifNull1(Integer verNo) {
        return verNo == null ? 1 : verNo;
    }

    public static BigDecimal min(BigDecimal d1, BigDecimal d2) {
        if (d1 == null) {
            return d2;
        } else {
            if (d1.doubleValue() < 0.0000001) {
                if (d2 == null) {
                    return d1;
                } else {
                    return d2;
                }
            } else {
                if (d2 == null) {
                    return d1;
                } else {
                    if (d2.doubleValue() < 0.000001) {
                        return d1;
                    } else {
                        return d1.doubleValue() < d2.doubleValue() ? d1 : d2;
                    }
                }
            }
        }
    }

    public static String ifNullSpace(BigDecimal d) {
        if (d == null) {
            return "";
        }
        return d.toPlainString();
    }


    public static BigDecimal max(BigDecimal d1, BigDecimal d2) {
        if (d1 == null) {
            return d2;
        } else {
            if (d1.doubleValue() < 0.0000001) {
                return d2;
            } else {
                if (d2 == null) {
                    return d1;
                } else {
                    if (d2.doubleValue() < 0.000001) {
                        return d1;
                    } else {
                        return d1.doubleValue() > d2.doubleValue() ? d1 : d2;
                    }
                }
            }
        }
    }

    public static boolean isNotNull(Double d) {
        return d != null;
    }

    public static boolean isNotNull(Date d) {
        return d != null;
    }

    public static boolean isNotNull(BigDecimal d) {
        return d != null;
    }

    public static String getSubString(String d ,int index1,int index2){
        if (d!=null) {
            if (d.length() < index2+1) {
                return d;
            }else {
                return d.substring(index1,index2);
            }
        }else {
            return "";
        }
    }

    public static String nvlString(String word,String def){
        if (word==null){
            return def;
        }else {
            return word;
        }
    }

    public static boolean isEquals(String str1, String str2, boolean isNullToSpace){
        if(str1 == null){
            if(str2 == null || (isNullToSpace && isNull(str2)))
                return true;
            else
                return false;
        }
        if(str2 == null){
            if(isNullToSpace && isNull(str1)){
                return true;
            }else
                return false;
        }

        return str1.equals(str2);
    }


}
