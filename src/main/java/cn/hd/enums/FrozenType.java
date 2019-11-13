package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description: 冻结操作类型
 */
public enum FrozenType {

    部分冻结("01","部分冻结"),//PART_FROZ
    全部冻结("02","全部冻结");//ALL_FROZ

    public static FrozenType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, FrozenType> map;

    static {
        map = new HashMap<String, FrozenType>();
        for (FrozenType e : FrozenType.values()) {
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

    private FrozenType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
