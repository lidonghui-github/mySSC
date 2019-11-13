package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>组合限额维度</p>

 */
public enum CombDimCode {
    投向行业限额("01","投向行业限额"),//INV_IND_LMT
    产品限额("02","产品限额"),//PROD_LMT
    期限限额("03","期限限额"),//TERM_LMT
    机构限额("04","机构限额"),//ORG_LMT
    客户限额("05","客户标识限额"),//CUST_LMT
    担保限额("06","担保限额"),//GUAR_LMT
    所属行业限额("07","所属行业限额"),//BEL_IND_LMT
    币种限额("08","币种限额"),
    关联方类别("09","关联方类别"),
    监管口径("10","监管口径");

    public static CombDimCode getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, CombDimCode> map;

    static {
        map = new HashMap<String, CombDimCode>();
        for (CombDimCode e : CombDimCode.values()) {
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

    private CombDimCode(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
