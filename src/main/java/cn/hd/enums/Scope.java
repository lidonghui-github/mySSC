package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum Scope {
    大型企业("01","大型企业"),//LAR_BUS
    中型企业("02","中型企业"),//MED_BUS
    小型企业("03","小型企业"),//SMA_BUS
    微型企业("04","微型企业");//MIC_BUS
    public static Scope getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, Scope> map;

    static {
        map = new HashMap<String, Scope>();
        for (Scope e : Scope.values()) {
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

    private Scope(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
