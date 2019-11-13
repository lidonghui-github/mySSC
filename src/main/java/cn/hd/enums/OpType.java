package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.额度处理标识
 */
public enum OpType {
    占用("U","占用"),//USEG
    预占("P","预占"),//PRE_USEG
    恢复("R","恢复"),//RECOV
    占用和恢复("A","占用和恢复"),//USEG_RECOV
    汇率和产品系数重算("E","汇率和产品系数重算"),//RATE_PRO_COE_RET
    冻结("F","冻结"),//FROZ
    解冻("T","解冻");//THAW
    public static OpType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, OpType> map;

    static {
        map = new HashMap<String, OpType>();
        for (OpType e : OpType.values()) {
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

    private OpType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
