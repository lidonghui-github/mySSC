package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 占用类型枚举,不是借口，请注意

 */
public enum UsageType {
    预占用("01", "预占用"),
    实占用("02", "实占用"),
    预占转实占("03", "预占转实占"),
    占用登记("04", "占用登记");

    public static UsageType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, UsageType> map;

    static {
        map = new HashMap<>();
        for (UsageType e : UsageType.values()) {
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

    private UsageType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    }

