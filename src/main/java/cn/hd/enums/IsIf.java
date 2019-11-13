package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum IsIf {
    是("1", "是"),//YES
    否("0", "否");//NO

    public static IsIf getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, IsIf> map;

    static {
        map = new HashMap<String, IsIf>();
        for (IsIf e : IsIf.values()) {
            map.put(e.getCode(), e);
        }
    }

    public boolean equals(String code) {
        return code != null && this.code.equals(code.trim());
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    private final String code;
    private final String name;

    private IsIf(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
