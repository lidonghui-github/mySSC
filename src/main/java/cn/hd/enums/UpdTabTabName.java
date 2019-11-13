package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 表名枚举，修改表数据 的表名
 *
 */
public enum UpdTabTabName {
    批复表("CL_B_CR_CRDT_APPR", "批复表"),
    批复节点表("CL_B_CR_TREE", "批复节点表"),
    合同表("CL_B_PR_CONTRACT", "合同表"),
    合同累计表("CL_B_PR_CONTRACT_SUM", "合同累计表"),
    日志表("CL_B_LO_AXLOG", "日志表"),
    维度值表("CL_B_CR_DIM_VALUE", "维度值表"),
    节点交易明细表("CL_B_CR_NODE_AX_DETAIL", "节点交易明细表"),
    企业额度占用情况表("CL_B_EP_CRDT_USE_RESULT", "企业额度占用情况表"),
    单一限额表("CL_B_LI_SINGLE", "单一限额表"),
    组合限额表("CL_B_LI_COMB", "组合限额表"),
    组合限额管控参数表("CL_B_LI_COMB_CTR", "组合限额管控参数表");




     static UpdTabTabName getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, UpdTabTabName> map;

    static {
        map = new HashMap<String, UpdTabTabName>();
        for (UpdTabTabName e : UpdTabTabName.values()) {
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

    private UpdTabTabName(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
