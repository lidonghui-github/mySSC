package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum IouType {
    表内("1", "表内"),//YES
    表外银承("2", "表外银承"),//YES
    表外保函("3", "表外保函"),//NO
    贷款借据("4", "贷款借据");

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

    private IouType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
