package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum  LimitType {
    综合授信额度("01", "综合授信额度"),//COMP_APPR_CRDT
    单项授信额度("02", "单项授信额度"),//SING_APPR_CRDT
    供应链厂商网络额度("03", "供应链厂商网络额度");//LINK_MAN_NET_CRDT

    public static LimitType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, LimitType> map;

    static {
        map = new HashMap<String, LimitType>();
        for (LimitType e : LimitType.values()) {
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

    private LimitType(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
