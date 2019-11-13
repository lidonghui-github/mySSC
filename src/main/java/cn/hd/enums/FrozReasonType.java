package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;


public enum FrozReasonType {
    司法冻结("02","司法冻结"),
    股东关联方政策原因("01","股东关联方政策原因"),
    其他("99","其他");
    public static FrozReasonType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, FrozReasonType> map;

    static {
        map = new HashMap<String, FrozReasonType>();
        for (FrozReasonType e : FrozReasonType.values()) {
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

    private FrozReasonType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
