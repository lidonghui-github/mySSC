package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description 集群类别
 */
public enum Grp_Type1 {

    集团关系("001","集团关系"),
    股东("002","股东"),
    家庭成员("003","家庭成员"),
    交易对手("004","交易对手"),
    总分关系("005","总分关系"),
    高管("006","高管"),
    其他关联方("007","其他关联方"),
    实际控制人("008","实际控制人"),
    同业关系("009","同业关系");

    public static Grp_Type1 getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, Grp_Type1> map;

    static {
        map = new HashMap<String, Grp_Type1>();
        for (Grp_Type1 e : Grp_Type1.values()) {
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

    private Grp_Type1(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
