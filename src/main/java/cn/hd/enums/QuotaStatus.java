package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum QuotaStatus {
    未生效("01","未生效"),//NOT_EFF
    生效("02","生效"),//EFF
    失效("03","失效");//INVA
    public static QuotaStatus getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, QuotaStatus> map;

    static {
        map = new HashMap<String, QuotaStatus>();
        for (QuotaStatus e : QuotaStatus.values()) {
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

    private QuotaStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
