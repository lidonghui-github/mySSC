package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.客户标识
 */
public enum CustomerFlag {
    钢贸行业("01","钢贸行业"),//STE_TRA_INDU
    政府融资平台("02","政府融资平台"),//GOV_FP
    光伏行业("03","光伏行业"),//PV_INDU
    中信股东关联方("04","中信股东关联方"),//CITIC_SHDER
    涉农行业("05","涉农行业");//AGRI_INDU
    public static CustomerFlag getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, CustomerFlag> map;

    static {
        map = new HashMap<String, CustomerFlag>();
        for (CustomerFlag e : CustomerFlag.values()) {
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

    private CustomerFlag(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
