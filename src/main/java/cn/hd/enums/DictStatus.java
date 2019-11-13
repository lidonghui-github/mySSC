package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description: 数据字典状态
 */
public enum DictStatus {

    已删除("0","已删除"),//ALR_DELE
    生效("1","生效");//EFF

    public static DictStatus getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, DictStatus> map;

    static {
        map = new HashMap<String, DictStatus>();
        for (DictStatus e : DictStatus.values()) {
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

    private DictStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
