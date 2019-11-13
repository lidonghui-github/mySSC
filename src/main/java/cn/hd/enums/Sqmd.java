package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：结清方式
 */
public enum Sqmd {
    正常结清("1","正常结清"),//NORM_CLEAN_UP
    未用退回票据("2","未用退回（票据）"),//UNUSE_RETU_NOTE
    撤消结清冲账("3","撤消结清（冲账）"),//REV_CLEUP_STRBA
    垫款结清("4","垫款结清"),//ADV_REC_CLEUP
    赔付结清("5","赔付结清");//PAYM_CLEUP
    public static Sqmd getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, Sqmd> map;

    static {
        map = new HashMap<String, Sqmd>();
        for (Sqmd e : Sqmd.values()) {
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

    private Sqmd(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
