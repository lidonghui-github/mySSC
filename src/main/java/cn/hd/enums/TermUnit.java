package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum TermUnit {
    年("01","年"), //YEAR
    月("02","月"), //MONTH
    日("03","日");//DAY
    public static TermUnit getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, TermUnit> map;

    static {
        map = new HashMap<String, TermUnit>();
        for (TermUnit e : TermUnit.values()) {
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

    private TermUnit(String code, String name) {
        this.code = code;
        this.name = name;
    }

    }
