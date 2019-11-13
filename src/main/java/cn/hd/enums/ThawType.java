package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description: 解冻类型
 */
public enum ThawType {

    未解冻("01","未解冻"),//NOT_THAW
    部分解冻("02","部分解冻"),//PART_THAW
    全部解冻("03","全部解冻");//ALL_THAW

    public static ThawType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, ThawType> map;

    static {
        map = new HashMap<String, ThawType>();
        for (ThawType e : ThawType.values()) {
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

    private ThawType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
