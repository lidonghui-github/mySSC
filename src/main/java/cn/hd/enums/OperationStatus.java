package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.
 */
public enum OperationStatus {
    待处理("2","待处理"),//PEND
    处理中("3","处理中"),//IN_HAND
    处理完成("4","处理完成");//HAND_COMP
    public static OperationStatus getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, OperationStatus> map;

    static {
        map = new HashMap<String, OperationStatus>();
        for (OperationStatus e : OperationStatus.values()) {
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

    private OperationStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
