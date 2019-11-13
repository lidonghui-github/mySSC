package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.
 */
public enum CustFlag {
    银监会定义钢贸企业("1374000001","银监会定义钢贸企业"),
    我行定义钢贸企业("1374000002","我行定义钢贸企业"),
    光伏企业("1374000004","光伏企业"),

    钢贸("01","钢贸"),
    光伏("03","光伏");
    public static CustFlag getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, CustFlag> map;

    static {
        map = new HashMap<String, CustFlag>();
        for (CustFlag e : CustFlag.values()) {
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

    private CustFlag(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
