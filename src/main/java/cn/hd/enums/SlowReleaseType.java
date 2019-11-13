package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.缓释物类型
 */
public enum SlowReleaseType {
    保证金("1","保证金"),//GUAR
    押品("2","押品");//ASSE
    public static SlowReleaseType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, SlowReleaseType> map;

    static {
        map = new HashMap<String, SlowReleaseType>();
        for (SlowReleaseType e : SlowReleaseType.values()) {
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

    private SlowReleaseType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
