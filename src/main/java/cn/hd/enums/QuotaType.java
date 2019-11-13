package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.限额类型
 */
public enum QuotaType {
    单一客户限额("01","单一客户限额"),//SING_CUST_LMT
    集团客户限额("02","集团客户限额"),//SUB_CUST_LMT
    组合限额("03","组合限额"),//COMB_LMT
    组合交叉("04","组合交叉"),//COMB_ACRO
    他用("05","他用");//OTHER
    public static QuotaType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, QuotaType> map;

    static {
        map = new HashMap<String, QuotaType>();
        for (QuotaType e : QuotaType.values()) {
            map.put(e.getCode(), e);
        }
    }

    public boolean equals(String code) {
        return this.code.equals(code);
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    private final String code;
    private final String name;

    private QuotaType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
