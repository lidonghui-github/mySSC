package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public enum AxDetailStatus {
    已撤销("2", "已撤销"),//ARL_REV
    删除("1", "删除"),//DELE
    正常("0","正常");//NORM

    public static AxDetailStatus getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, AxDetailStatus> map;

    static {
        map = new HashMap<String, AxDetailStatus>();
        for (AxDetailStatus e : AxDetailStatus.values()) {
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

    private AxDetailStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
