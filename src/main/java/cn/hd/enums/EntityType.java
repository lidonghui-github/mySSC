package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum EntityType {
    合同("C", "合同"),
    批复("A", "批复");

    public static EntityType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, EntityType> map;

    static {
        map = new HashMap<String, EntityType>();
        for (EntityType e : EntityType.values()) {
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

    private EntityType(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
