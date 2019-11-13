package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.网络类型
 */
public enum ScfType {
    开放型("01","开放型"),//OP_TYPE
    封闭型("02","封闭型");//CLOS_TYPE
    public static ScfType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, ScfType> map;

    static {
        map = new HashMap<String, ScfType>();
        for (ScfType e : ScfType.values()) {
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

    private ScfType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
