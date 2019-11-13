package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.机构属性
 */
public enum OrgProperty {
    一般机构("00","一般机构"),//GENE_INS
    公司部("01","公司部"),//COMP_DEPA
    资保部("02","资保部"),//ENINS_DEPA
    票据中心("03","票据中心"),//BILL_CENT
    国际部("04","国际部"),//INTER_DEPA
    小企业专营机构("05","小企业专营机构");//SMA_BUS_SPAGE
    public static OrgProperty getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, OrgProperty> map;

    static {
        map = new HashMap<String, OrgProperty>();
        for (OrgProperty e : OrgProperty.values()) {
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

    private OrgProperty(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
