package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum SteelTradentFlag {
    未知("00","未知"),//UNK
    银监会定义钢贸企业("01","银监会定义钢贸企业"),//CBRC_DEF_STE_TRA_BUS
    我行定义钢贸企业("02","我行定义钢贸企业"),//BKDF_STE_TRA_BUS
    非风险客户("03","非风险客户"),//UNRISK_CUST
    铜贸企业("04","铜贸企业"),//STE_TRA_BUS
    光伏企业("05","光伏企业"),//PV_BUS
    错误("99","错误");//WRONG
    public static SteelTradentFlag getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, SteelTradentFlag> map;

    static {
        map = new HashMap<String, SteelTradentFlag>();
        for (SteelTradentFlag e : SteelTradentFlag.values()) {
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

    private SteelTradentFlag(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
