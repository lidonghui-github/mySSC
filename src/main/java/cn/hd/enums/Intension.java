package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.管控强度
 */
public enum Intension {
    刚性("01","刚性"), //STIFF
    柔性("02","柔性");//FLEXI
    public static Intension getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, Intension> map;

    static {
        map = new HashMap<String, Intension>();
        for (Intension e : Intension.values()) {
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

    private Intension(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
