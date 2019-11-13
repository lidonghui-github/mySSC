package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 撤销类型枚举

 */
public enum  RevokeType {
    预占撤销("01", "预占撤销"),
    放款或合同撤销("02", "放款或合同撤销"),
    票据撤销("03", "票据撤销"),
    借新还旧撤销("05", "借新还旧撤销"),
    垫款合同撤销("04", "垫款合同撤销");

    public static RevokeType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, RevokeType> map;

    static {
        map = new HashMap<>();
        for (RevokeType e : RevokeType.values()) {
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

    private RevokeType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    }

