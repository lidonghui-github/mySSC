package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 联机交易查询类型

 */
public enum InlineQueryType { //TODO
    合同保证金关系查询("1", "合同保证金关系查询"),
    合同押品关系查询("2", "合同押品关系查询"),
    交易日志详细查询("3", "交易日志详细查询"),
    交易日志综合查询("4", "交易日志综合查询"),
    sql查询("5", "sql查询"),
    保证金联机查询("6", "保证金联机查询"),
    押品联机查询("7", "押品联机查询"),
    表内借据联机查询("8", "表内借据联机查询"),
    表外银承借据联机查询("8225", "表外银承借据联机查询"),
    表外保函借据联机查询("8025", "表外保函借据联机查询"),
    登记簿联机查询("9", "265登记簿联机查询"),
    押品保证金关系查询("10", "押品保证金关系查询")
    ;

    public static InlineQueryType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, InlineQueryType> map;

    static {
        map = new HashMap<String, InlineQueryType>();
        for (InlineQueryType e : InlineQueryType.values()) {
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

    private InlineQueryType(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
