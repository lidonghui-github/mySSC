package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：集团客户分类
 */
public enum ChargeDepartment {
    统一授信管理集团("01","统一授信管理集团"),//UNI_APPR_MANGRP
    统一监控管理集团("02","统一监控管理集团");//UNI_MONI_MANGRP
    public static ChargeDepartment getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, ChargeDepartment> map;

    static {
        map = new HashMap<String, ChargeDepartment>();
        for (ChargeDepartment e : ChargeDepartment.values()) {
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

    private ChargeDepartment(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
