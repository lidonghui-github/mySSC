package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum RiskType {
    低风险("01","低风险"),//LOW_RISK
    非低风险("09","非低风险");//NOLOW_RISK
    //中期流贷（1-3年）一般固定资产贷款（5年以内）("04","中期流贷（1-3年）、一般固定资产贷款（5年以内）");
    public static RiskType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, RiskType> map;

    static {
        map = new HashMap<String, RiskType>();
        for (RiskType e : RiskType.values()) {
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

    private RiskType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
