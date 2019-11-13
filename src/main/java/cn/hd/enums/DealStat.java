package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public enum DealStat {
    未处理("0","未处理"),//NOT_HAND
    处理中("1","处理中"),//IN_HAND
    已处理("2","已处理"),//ALR_HAND
    失败("3","失败"),
    准实时未处理("5","准实时未处理"),
    //准实时重算计算后仍为负责状态为9，表为CL_B_TO_RE_CAL
    金额异常("9","金额异常");

    public static DealStat getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, DealStat> map;

    static {
        map = new HashMap<String, DealStat>();
        for (DealStat e : DealStat.values()) {
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

    private DealStat(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
