package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description: 保证金冻结状态
 */
public enum GuardFrozenStatus {

    正常("1","正常"),//NORM
    全部冻结("2","全部冻结"),//ALL_FROZ
    部分冻结("3","部分冻结");//PART_FROZ

    public static GuardFrozenStatus getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, GuardFrozenStatus> map;

    static {
        map = new HashMap<String, GuardFrozenStatus>();
        for (GuardFrozenStatus e : GuardFrozenStatus.values()) {
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

    private GuardFrozenStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
