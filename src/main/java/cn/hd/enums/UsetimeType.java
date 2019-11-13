package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.占用时点
 */
public enum UsetimeType {
    批复占用("1","批复占用"),//APPR_USEG
    合同占用("2","合同占用"),//CONT_USEG
    放款占用("3","放款占用"),//LOAN_USEG
    切分占用("4","切分占用"),//DIM_USEG
    放款预占("5", "放款预占"),//DIM_USEG
    关联方限额占用("6", "关联方限额占用");//LOAN_PRE_USEG
    public static UsetimeType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, UsetimeType> map;

    static {
        map = new HashMap<String, UsetimeType>();
        for (UsetimeType e : UsetimeType.values()) {
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

    private UsetimeType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
