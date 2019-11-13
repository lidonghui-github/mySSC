package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.合同状态
 */
public enum BcStatus {
    未生效("N","未生效"),//NOT_EFF
    正常("A","正常"),//NORM
    停息("S","停息"),//STOP
    撤消冲账("R","撤消（冲账）"),//REV_STRBA
    结清("C","结清");//CLEAN_UP


    public static BcStatus getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, BcStatus> map;

    static {
        map = new HashMap<String, BcStatus>();
        for (BcStatus e : BcStatus.values()) {
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

    private BcStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
