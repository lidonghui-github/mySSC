package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.交易状态
 */
public enum RiskCalcType {
    额度("01","额度"),//CRDT
    限额("02","限额") ;//LMT
    public static RiskCalcType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, RiskCalcType> map;

    static {
        map = new HashMap<String, RiskCalcType>();
        for (RiskCalcType e : RiskCalcType.values()) {
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

    private RiskCalcType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
