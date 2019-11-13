package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>额度恢复类型枚举</p>

 */
public enum RecoverCause {
    垫款撤销("09", "垫款撤销"),
    撤销("01", "撤销"),//RECOV
    还款("02", "还款"),//REPT
    合同到期("03", "合同到期"),//CONT_EXPI
    合同结清("04", "合同结清"),//CONT_CLEAN_UP
    终止提款("05", "终止提款"),//STOP_DRAW
    /*垫款流水("05", "垫款流水"),
    票据未用退回("06", "票据未用退回"),*/
    部分占用释放("10","部分占用释放"),
    其他("99", "其他");//OTHER

    public static RecoverCause getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, RecoverCause> map;

    static {
        map = new HashMap<String, RecoverCause>();
        for (RecoverCause e : RecoverCause.values()) {
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

    private RecoverCause(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
