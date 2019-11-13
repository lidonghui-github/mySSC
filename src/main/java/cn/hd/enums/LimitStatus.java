package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>额度状态枚举类</p>

 */
public enum LimitStatus {

    未生效("01","未生效"),//NOT_EFF
    生效("02","生效"),//EFF
    失效("03","失效");//INVA

    public static LimitStatus getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, LimitStatus> map;

    static {
        map = new HashMap<String, LimitStatus>();
        for (LimitStatus e : LimitStatus.values()) {
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

    private LimitStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
