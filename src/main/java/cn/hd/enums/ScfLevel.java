package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.网络级别
 */
public enum ScfLevel {
    总行级("01","总行级"),//HDOF_LEV
    分行级("02","分行级");//BRA_LEV
    public static ScfLevel getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, ScfLevel> map;

    static {
        map = new HashMap<String, ScfLevel>();
        for (ScfLevel e : ScfLevel.values()) {
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

    private ScfLevel(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
