package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum TransResultCode {
    处理成功("01","处理成功"),//DEAL_SUCC
    处理失败("02","处理失败"),//DEAL_FAIL
    可疑交易("03","可疑交易");//SUSP_TRAN

    public static TransResultCode getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, TransResultCode> map;

    static {
        map = new HashMap<String, TransResultCode>();
        for (TransResultCode e : TransResultCode.values()) {
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

    private TransResultCode(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
