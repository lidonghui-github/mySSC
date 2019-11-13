package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 *
 * 维护合同缓释关系检查通过类型
 * 根据不同的通过类型，
 * 维护合同缓释关系调用不同的代码
 */
public enum TChgFCSuccessType {
    新缓释物缓释后敞口为0("01","新缓释物缓释后敞口为0"),
    没有占用记录("02","没有占用记录"),
    节点敞口满足("03","节点敞口满足"),
    强制执行("04","强制执行"),
    合同敞口变小("05","合同敞口变小")
    ;
    public static TChgFCSuccessType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, TChgFCSuccessType> map;

    static {
        map = new HashMap<String, TChgFCSuccessType>();
        for (TChgFCSuccessType e : TChgFCSuccessType.values()) {
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

    private TChgFCSuccessType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
