package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.是否涉农
 */
public enum InspectionYear {
    非涉农("1","非涉农"),//NOT_AGRI
    城市企业组织涉农("2","城市企业/组织涉农"),//CTBUS_ORG_AGRI
    农村企业组织涉农("3","农村企业/组织涉农");//RUBUS_ORG_AGRI
    public static InspectionYear getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, InspectionYear> map;

    static {
        map = new HashMap<String, InspectionYear>();
        for (InspectionYear e : InspectionYear.values()) {
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

    private InspectionYear(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
