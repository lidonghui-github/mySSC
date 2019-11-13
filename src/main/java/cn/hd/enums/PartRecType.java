package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum  PartRecType {
    占用部分恢复("1","占用部分恢复"),
    预占部分恢复("2","预占部分恢复"),
    预占全部恢复("3","预占全部恢复");
    public static PartRecType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, PartRecType> map;

    static {
        map = new HashMap<String, PartRecType>();
        for (PartRecType e : PartRecType.values()) {
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

    private PartRecType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
