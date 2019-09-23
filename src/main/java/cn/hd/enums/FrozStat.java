package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;


public enum FrozStat {

    全部冻结("03", "全部冻结"),
    未冻结("01", "未冻结"),
    部分冻结("02", "部分冻结");

    public static FrozStat getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, FrozStat> map;

    static {
        map = new HashMap<String, FrozStat>();
        for (FrozStat e : FrozStat.values()) {
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

    private FrozStat(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
