package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum FlowCodeEnum {

    CL_O_ASSET("CL_O_ASSET","押品文件就绪"),
    CL_O_ASSET_DRT("CL_O_ASSET_DRT","押品目录文件就绪"),
    CL_O_FIRETIME("CL_O_FIRETIME","核心准实时文件就绪"),
    CL_O_IOU_IN("CL_O_IOU_IN","借据表内文件就绪"),
    CL_O_IOU_OUT("CL_O_IOU_OUT","表外银承借据文件就绪"),
    CL_O_IOU_OUT_PRT("CL_O_IOU_OUT_PRT","表外保函借据文件就绪"),
    CL_O_LFCORA("CL_O_LFCORA","表外贷款借据文件就绪"),
    CL_O_LFCRINF("CL_O_LFCRINF","信用证登记信息文件就绪"),
    CL_O_GUAR_ACT("CL_O_GUAR_ACT","保证金账户文件就绪"),
    CL_O_CONTRACT("CL_O_CONTRACT","表内协议文件就绪"),
    CL_O_CONTRACT_O("CL_O_CONTRACT_O","表外银承协议文件就绪"),
    CL_O_CONTRACT_B("CL_O_CONTRACT_B","表外保函协议文件就绪"),
    CL_O_LFCLAT("CL_O_LFCLAT","表外贷款协议文件就绪"),
    CL_O_REG("CL_O_REG","265登记簿文件就绪"),
    CL_O_FT("CL_O_FT","法透登记薄文件就绪"),
    CL_O_FC_LNGTAA("CL_O_FC_LNGTAA","首保变动文件就绪"),
    CL_O_FC_LNRLAA("CL_O_FC_LNRLAA","跨模块关联账户登记薄文件就绪"),
    CL_O_IB_CRDT_USE_INFO("CL_O_IB_CRDT_USE_INFO","同业额度占用情况文件就绪"),
    CL_O_EP_CRDT_USE("CL_O_EP_CRDT_USE","企业额度占用文件就绪"),
    CL_O_EP_CRDT_RECOV("CL_O_EP_CRDT_RECOV文件就绪","额度恢复文件就绪"),
    CL_O_EP_TLMTRV("CL_O_EP_TLMTRV","限额恢复"),
    CL_O_CRM_SML("CL_O_CRM_SML","小企业项目信息文件就绪"),
    CL_O_CRM_NOT("CL_O_CRM_NOT","虚拟非法人信息文件就绪"),
    CL_O_CRM_GRP("CL_O_CRM_GRP","集团客户信息文件就绪"),
    CL_O_CRM_CUST("CL_O_CRM_CUST","对公客户基本信息文件就绪"),
    CL_O_CRM_CUST_AUX("CL_O_CRM_CUST_AUX","对公客户附属信息文件就绪"),
    CL_O_CRM_CUST_RELA("CL_O_CRM_CUST_RELA","客户关系信息文件就绪"),
    CL_O_CUST_LIST_INF("CL_O_CUST_LIST_INF","客户名单信息文件就绪"),
    CL_O_LIST_CUST_MBR("CL_O_LIST_CUST_MBR","名单客户成员文件就绪"),
    CL_O_EXCH("CL_O_EXCH","汇率文件就绪"),
    CL_O_INDU("CL_O_INDU","行业信息文件就绪"),
    CL_O_INDU_TYPE("CL_O_INDU_TYPE","行业大类文件就绪"),
    CL_O_CNCY("CL_O_CNCY","币种信息文件就绪"),
    CL_O_PA_PRODUCT_INFO("CL_O_PA_PRODUCT_INFO","产品文件就绪"),
    CL_O_CRDT_STAT("CL_O_CRDT_STAT","额度状态文件就绪"),
    CL_O_CRDT_REPL("CL_O_CRDT_REPL","额度替换文件就绪"),
    CL_O_FRE("CL_O_FRE","解除缓释文件就绪"),
    CL_O_PA_ORG_INFO("CL_O_PA_ORG_INFO","机构表文件就绪"),
    CL_O_PA_ORG_TREE("CL_O_PA_ORG_TREE","机构关系表文件就绪");

    public static FlowCodeEnum getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, FlowCodeEnum> map;

    static {
        map = new HashMap<String, FlowCodeEnum>();
        for (FlowCodeEnum e : FlowCodeEnum.values()) {
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

    private FlowCodeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
