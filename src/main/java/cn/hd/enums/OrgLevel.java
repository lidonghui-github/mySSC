package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.机构级别
 */
public enum OrgLevel {
    总行级别("0","总行级别"),//HDOF_LEV
    一级分行级别("3","一级分行级别"),//FIS_BRA_LEV
    二级分行异地支行级别("6","二级分行/异地支行级别"),//SECB_SUBRA_LEV
    支行级别("9","支行级别");//BRA_LEV
    public static OrgLevel getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, OrgLevel> map;

    static {
        map = new HashMap<String, OrgLevel>();
        for (OrgLevel e : OrgLevel.values()) {
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

    private OrgLevel(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
