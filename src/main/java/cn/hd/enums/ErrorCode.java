package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;


public enum ErrorCode {
    //公共错误：
    成功("AAAAAAA", "成功"),
    批复号不能为空("10000", "批复号不能为空"),
    客户号不能为空("10001", "客户号不能为空"),
    根节点编号不能为空("10002", "根节点编号不能为空"),
    授信金额不能为空("10003", "授信金额不能为空"),
    额度状态不能为空("10004", "额度状态不能为空"),
    额度类型不能为空("10005", "额度类型不能为空"),
    额度生效日不能为空("10006", "额度生效日不能为空"),
    额度到期日不能在额度生效日之前("10007","额度到期日不能在额度生效日之前");


    public static ErrorCode getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, ErrorCode> map;

    static {
        map = new HashMap<String, ErrorCode>();
        for (ErrorCode e : ErrorCode.values()) {
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

    private ErrorCode(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
