package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum LimitRelationType {
    总量纳入("01","总量纳入"),//TOT_INTO
    总量和期限纳入("02","总量和期限纳入"),//TOT_TERM_INTO
    全部纳入("03", "全部纳入"),//ALL_INTO
    替换("04","替换"),//REP
    关联("05","关联"),//RELA
    全部和期限纳入("06","全部和期限纳入");

    public static LimitRelationType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, LimitRelationType> map;

    static {
        map = new HashMap<String, LimitRelationType>();
        for (LimitRelationType e : LimitRelationType.values()) {
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

    private LimitRelationType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
