package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：单表查询指令
 */
public enum SingleQueryAction {
    垫款合同表查询("1", "垫款合同表查询"),
    额度树关系表查询("2", "额度树关系表查询"),
    额度管控白名单("3", "额度管控白名单"),
    额度替换("4", "额度替换"),
    额度状态("5", "额度状态"),
    对公客户信息("6", "对公客户信息"),
    股东关联方信息("7", "股东关联方"),
    币种信息("8", "币种信息"),
    汇率信息("9", "汇率信息"),
    行业信息("10", "行业信息"),
    机构信息("11", "机构信息"),
    产品信息("12", "产品信息"),
    表内借据("13", "表内借据"),
    表外银承借据("14", "表外银承借据"),
    表外保函借据("15", "表外保函借据"),
    二六五登记薄("16", "265登记薄"),
    押品("17", "押品"),
    法透登记薄("18", "法透登记薄"),
    保证金信息("19", "保证金信息"),
    批量解除缓释("20", "批量解除缓释"),
    查询所有表名("21", "查询所有表名"),
    查询表的结构信息("22", "查询表的结构信息"),
    合同累计信息("23", "合同累计信息"),
    分行白名单("24","分行白名单"),
    批复("25","批复"),
    节点("26","节点"),
    节点明细("27","节点明细"),
    合同("28","合同"),
    企业额度占用("29","企业额度占用"),
    额度恢复("30","额度恢复"),
    同业额度占用("31","同业额度占用"),
    跑批信息("32","跑批信息"),
    跑批情况("33","跑批情况"),
    维度值("34", "维度值"),
    单一限额("35", "单一限额"),
    组合限额("36", "组合限额"),
    组合限额维度("37", "组合限额维度"),
    组合限额刚柔性("38", "组合限额刚柔性"),
    限额占用实体("39", "限额占用实体"),
    限额占用实体维度("40", "限额占用实体维度"),
    限额占用流水("41", "限额占用流水"),
    限额占用流水明细("42", "限额占用流水明细"),
    日志("43", "日志"),
    客户关系("44","客户关系"),
    批量任务错误信息表("45","批量任务错误信息表"),
    合同保证金关系("46","合同保证金关系"),
    准实时MQ("47","准实时MQ"),
    准实时FT("48","准实时FT");

    public static SingleQueryAction getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, SingleQueryAction> map;

    static {
        map = new HashMap<String, SingleQueryAction>();
        for (SingleQueryAction e : SingleQueryAction.values()) {
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

    private SingleQueryAction(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
