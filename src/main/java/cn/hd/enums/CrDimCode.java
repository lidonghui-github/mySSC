package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum CrDimCode {
    客户("003","CUSTOMERFLAG"),//CUST
    风险类型("004","RISKTYPE"),//RISK_TYPE
    担保方式("006","GUARTYPE"),//CUAR_TYPE
    时间区间("007","TIMEZONETYPE"),//TIME_ZONE
    保证人("009","保证人"),//GUAR_MAN
    商票承兑人("011","商票承兑人"),//BUSTIC_ACDA
    SCF业务模式("015","SCFBUSSTYPE"),//SCF_BUS_MOD
    期限("026","DEADLINE");//TERM
    public static CrDimCode getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, CrDimCode> map;

    static {
        map = new HashMap<String, CrDimCode>();
        for (CrDimCode e : CrDimCode.values()) {
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

    private CrDimCode(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
