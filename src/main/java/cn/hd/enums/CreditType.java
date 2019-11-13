package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum CreditType {
    个人客户("1","个人客户"),
    单位客户("2","单位客户");
    public static CreditType getByCode(String code) {
        return map.get(code);
    }
    

    private static Map<String, CreditType> map;

    static {
        map = new HashMap<String, CreditType>();
        for (CreditType e : CreditType.values()) {
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

    private CreditType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
