package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.占用类型
 */
public enum UsedType {
    占用登记("01","占用登记"),//USEG_REGI
    预占用("02","预占用"),//PRE_USEG
    占用("03","占用");//USEG
    public static UsedType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, UsedType> map;

    static {
        map = new HashMap<String, UsedType>();
        for (UsedType e : UsedType.values()) {
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

    private UsedType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
