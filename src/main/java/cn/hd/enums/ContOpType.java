package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description: 缓释押品类型名称
 */
public enum ContOpType {

    重算("C","重算"),//BAR_BILL
    恢复("R","恢复");//BAR_ACPT_DRA

    public static ContOpType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, ContOpType> map;

    static {
        map = new HashMap<String, ContOpType>();
        for (ContOpType e : ContOpType.values()) {
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

    private ContOpType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
