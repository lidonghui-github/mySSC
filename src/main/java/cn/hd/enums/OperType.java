package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.操作类型
 */
public enum OperType {
    新增("01","新增"),//ADD
    修改("02","修改");//UPD
    public static OperType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, OperType> map;

    static {
        map = new HashMap<String, OperType>();
        for (OperType e : OperType.values()) {
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

    private OperType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
