package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description: 数据字典查询类型
 */
public enum DictQueryType {

    查询押品类型数据("0","查询押品类型数据"),//INQ_ASS_TPDT
    查询非押品类型数据("00","查询非押品类型数据"),//INQ_NASS_TPDT
    查询字典详细数据("1","查询字典详细数据"),//INQ_DICT_DETA_DATA
    查询字典信息回显("2","查询字典信息回显"),//INQ_DICT_INF_ECHO
    查询字典类型回显("3","查询字典类型回显");//INQ_DICT_TYPE_ECHO

    public static DictQueryType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, DictQueryType> map;

    static {
        map = new HashMap<String, DictQueryType>();
        for (DictQueryType e : DictQueryType.values()) {
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

    private DictQueryType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
