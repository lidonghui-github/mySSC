package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;


public enum IouStatus {
    未卖出("1","未卖出"),
    卖断卖出("2","卖断卖出"),
    回购卖出("3","回购卖出"),
    已返售("4","已返售"),
    已回购("5","已回购")
    ;
    public static IouStatus getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, IouStatus> map;

    static {
        map = new HashMap<String, IouStatus>();
        for (IouStatus e : IouStatus.values()) {
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

    private IouStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
