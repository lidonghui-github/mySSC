package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description: 冻结状态
 */
public enum FrozenStatus {

    未冻结("01","未冻结"),//NOT_FROZ
    部分冻结("02","部分冻结"),//PART_FROZ
    全部冻结("03","全部冻结");//ALL_FROZ

    public static FrozenStatus getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, FrozenStatus> map;

    static {
        map = new HashMap<String, FrozenStatus>();
        for (FrozenStatus e : FrozenStatus.values()) {
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

    private FrozenStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
