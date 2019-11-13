package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description :
 */
public enum OrderType {

    ASC("ASC","升序"),//ADD
    DESC("DESC","降序");//UPD
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

    private OrderType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
