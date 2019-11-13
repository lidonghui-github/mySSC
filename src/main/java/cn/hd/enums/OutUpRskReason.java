package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

public enum OutUpRskReason {
    未上送敞口("00","未上送敞口"),
    预占("01","预占"),//DEPT
    天信切分子额度("02","天信切分子额度"),
    其他("99","其他");

    public static OutUpRskReason getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, OutUpRskReason> map;

    static {
        map = new HashMap<String, OutUpRskReason>();
        for (OutUpRskReason e : OutUpRskReason.values()) {
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

    private OutUpRskReason(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
