package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.限额处理标识
 */
public enum QuotaopType {
    占用("01","占用"),//USEG
    恢复("02","恢复"),//RECOV
    汇率重算("03","汇率重算");//RATE_RET
    public static QuotaopType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, QuotaopType> map;

    static {
        map = new HashMap<String, QuotaopType>();
        for (QuotaopType e : QuotaopType.values()) {
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

    private QuotaopType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
