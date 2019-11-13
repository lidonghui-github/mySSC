package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum OrgArea {
    长江三角洲("01","长江三角洲"),//YRD
    珠江三角洲及海峡西岸("02","珠江三角洲及海峡西岸"),//ZJD_WSTRA
    环渤海地区("03","环渤海地区"),//CEN_BH_AREA
    中部地区("04","中部地区"),//MID_AREA
    西部地区("05","西部地区"),//WEST_AREA
    东北地区("06","东北地区"),//NE_AREA
    总行("08","总行");//HEAD_OFFI
    public static OrgArea getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, OrgArea> map;

    static {
        map = new HashMap<String, OrgArea>();
        for (OrgArea e : OrgArea.values()) {
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

    private OrgArea(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
