package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.约束维度类型
 */
public enum DimType {
    机构("001","机构"),//INS
    产品("002","产品"),//PROD
    客户("003","客户"),//CUST
    风险类型("004","风险类型"),//RISK_TYPE
    币种("005","币种"),//CNCY
    担保方式("006","主要担保方式"),//CUAR_TYPE
    时间区间("007","时间区间"),//TIME_ZONE
    保证人("009","保证人"),//GUAR_MAN
    商票承兑人("011","商票承兑人"),//BUSTIC_ACDA
    SCF业务模式("015","SCF业务模式"),//SCF_BUS_MOD
    SCF行业("024","SCF行业"),//SFC_INDU
    SCF他用额度("025","SCF他用额度"),//SCF_OTH_AMT
    期限("026","期限（月）");//TERM



    public static DimType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, DimType> map;

    static {
        map = new HashMap<String, DimType>();
        for (DimType e : DimType.values()) {
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

    private DimType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
