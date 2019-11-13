package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**


 * @Description: 维度包含排除标识
 */
public enum IncludeFlag {

    包含("1","包含"),
    排除("0","排除");

    public static IncludeFlag getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, IncludeFlag> map;

    static {
        map = new HashMap<String, IncludeFlag>();
        for (IncludeFlag e : IncludeFlag.values()) {
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

    private IncludeFlag(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
