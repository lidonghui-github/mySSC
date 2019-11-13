package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.缓释关系类型
 */
public enum CsrelaType {
    首笔保证金("1","首笔保证金"),//FIS_GUAR
    回款保证金("2","回款保证金"),//COL_GUAR
    押品("5","押品"),//ASS

    押品保证金("53","押品保证金"),//ASS_GUAR
    专用押品("51","专用押品"),//ASS
    共享押品("52","共享押品");//ASS
    public static CsrelaType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, CsrelaType> map;

    static {
        map = new HashMap<String, CsrelaType>();
        for (CsrelaType e : CsrelaType.values()) {
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

    private CsrelaType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
