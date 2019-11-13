package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum Status {
    删除("1", "删除"),//DELE
    正常("0","正常");//NORM

    public static Status getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, Status> map;

    static {
        map = new HashMap<String, Status>();
        for (Status e : Status.values()) {
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

    private Status(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
