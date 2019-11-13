package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum SingleQuotaType {
    单一客户限额("01","单一客户限额"),//SING_CUST_LMT
    集团客户限额("02","集团客户限额");//SUB_CUST_LMT
    public static SingleQuotaType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, SingleQuotaType> map;

    static {
        map = new HashMap<String, SingleQuotaType>();
        for (SingleQuotaType e : SingleQuotaType.values()) {
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

    private SingleQuotaType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
