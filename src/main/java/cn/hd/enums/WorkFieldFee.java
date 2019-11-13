package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum WorkFieldFee {
    小企业("01","小企业"),//SMA_BUS
    成长型小企业("02","成长型小企业"),//GROW_SMA_BUS
    非小企业("03","非小企业");//NOT_SMA_BUS
    public static WorkFieldFee getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, WorkFieldFee> map;

    static {
        map = new HashMap<String, WorkFieldFee>();
        for (WorkFieldFee e : WorkFieldFee.values()) {
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

    private WorkFieldFee(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
