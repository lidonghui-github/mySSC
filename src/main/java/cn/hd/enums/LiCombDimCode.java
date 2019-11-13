package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>组合限额维度</p>

 */
public enum LiCombDimCode {

    期限限额("03","DEADLINE"),//TERM_LMT
    客户限额("05","CUSTOMERFLAG"),//CUST_LMT
    担保限额("06","GUARTYPE"),//GUAR_LMT
    关联方类别("09","AFFILIATEDTYPE"),//GUAR_LMT
    监管口径("10","AFFILIATEDCALI");//GUAR_LMT


    public static LiCombDimCode getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, LiCombDimCode> map;

    static {
        map = new HashMap<String, LiCombDimCode>();
        for (LiCombDimCode e : LiCombDimCode.values()) {
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

    private LiCombDimCode(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
