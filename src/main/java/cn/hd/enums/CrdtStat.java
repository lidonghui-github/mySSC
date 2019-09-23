package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;


public enum CrdtStat {

    未生效("01", "未生效"),
    生效("02", "生效"),
    失效("03", "失效");

    public static CrdtStat getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, CrdtStat> map;

    static {
        map = new HashMap<String, CrdtStat>();
        for (CrdtStat e : CrdtStat.values()) {
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

    private CrdtStat(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
