package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 交易码，
 */
public enum AxCode {
    价值变动("NAssetChange", "价值变动"),//CRDT_ADD
    额度新增("TCrAdd", "额度新增"),//CRDT_ADD
    额度修改("TCrUpd", "额度修改"),//CRDT_UPD
    额度树检查("TCrChk", "额度树检查"),//CRDT_CHK
    额度纳入替换("TCrRep", "额度纳入替换"),//CRDT_INTO_REPL
    额度纳入("0004", "额度纳入"),//CRDT_INTO
    额度取消纳入("TCnRep", "额度取消纳入"),//CRDT_CANC_INTO
    额度删除("TCrDel", "额度删除"),//CRDT_DELE
    额度替换("0006", "额度替换"),//CRDT_REPL
    额度占用检查("TUgChk", "额度占用检查"),//CRDT_USEG_CHK
    额度占用("TUsage", "额度占用"),//CRDT_USEG
    额度占用修改("TUsMdf", "额度占用修改"),//CRDT_USEG_MDF
    额度预占用转实占用("0009", "额度预占用转实占用"),//CRDT_PTR_USEG
    额度恢复("TRecov", "额度恢复"),//CRDT_RECOV
    额度冻结("TFrozz", "额度冻结"),//CRDT_FROZ
    额度解冻("TThaww", "额度解冻"),//CRDT_THAW
    额度提前生效("TValid", "额度提前生效"),//CRDT_ADV_VALD
    额度提前终止("TUnVal", "额度提前终止"),//CRDT_ADV_END
    缓释价值减少试算("TFreee", "缓释价值减少试算"),//REVAL_RED_TRI
    解除缓释关联关系("TUnFre", "解除缓释关联关系"),//REM_RE_ASSRE
    新增缓释关联关系("TAddFr", "新增缓释关联关系"),//ADD_RE_ASSRE
    额度白名单设置("TWhite", "额度白名单设置"),//CRDT_WHI_SET
    额度白名单查询("TWhtQr", "额度白名单查询"),//CRDT_WHI_INQ
    单一限额新增("TSglAd", "单一限额新增"),//SIQU_ADD
    单一限额修改("TSglUp", "单一限额修改"),//SIQU_UPD
    单一限额查询("TSglQr", "单一限额查询"),//SIQU_INQ
    组合限额新增("TLmtAd", "组合限额新增"),//COMB_ADD
    组合限额修改("TLmtUp", "组合限额修改"),//COMB_UPD
    组合限额查询("TLmtQr", "组合限额查询"),//COMB_INQ
    限额占用检查("TLmtCk", "限额占用检查"),//LMT_USEG_CHK
    限额占用("TLmtUg", "限额占用"),//LMT_USEG
    限额占用修改检查("TLUMCk", "限额占用修改检查"),
    限额占用修改("TLUMdf", "限额占用修改"),
    限额恢复("TLmtRv", "限额恢复"),//LMT_RECOV
    限额白名单设置("TLmWhS", "限额白名单设置"),
    占用关联方限额查询("TLAffQ", "占用关联方限额查询"),
    放款指令编号查询("TOCNQr", "放款指令编号查询"),
    放款指令编号变更("TOCNCh", "放款指令编号变更"),
    冲账交易("TReverse","冲账交易"),
    额度列表查询("TLstQr", "额度列表查询"),//CRDT_LIST_INQ
    额度明细查询("TDetQr", "额度明细查询"),//CRDT_DETA_INQ
    额度使用明细查询("TUsgQr", "额度使用明细查询"),//CRDT_USEDE_INQ
    额度关系查询("TRelQr", "额度关系查询"),//CRDT_RELA
    额度台账查询("0032", "额度台账查询"),//CRDT_BOOK_INQ
    限额台账查询("0033", "限额台账查询"),//LMT_BOOK_INQ
    客户总额度查询("TCrdQr", "客户总额度查询"),//CUST_TCRDT_INQ
    交易日志查询("TLogQr", "交易日志查询"),//AX_LOG_INQ
    查证交易("TAxQry", "查证交易"),//INQ_AX
    垫款合同("TPyCon", "垫款合同"),//FORPAY_CONT
    押品关系维护("TAssRl", "押品关系维护"),//ASS_RELA_MATN
    合同缓释敞口查询("TContQ", "合同缓释敞口查询"),//CONT_RE_RSK_INQ
    额度占用明细查询("0036", "额度占用明细查询"),//CRDT_USEG_DEINQ
    限额占用明细查询("0037", "限额占用明细查询"),//LMT_USEG_DEINQ
    保存合同协议信息("0038", "保存合同协议信息"),//KPCONT_PROINF
    客户信息("NCustm", "客户信息"),//CUST_INF
    客户附属信息("NCustA", "客户附属信息"),//CUST_ANC_INF
    客户关系("NCustR", "客户关系"),//CUST_RELA
    集团客户信息("NGroup", "集团客户信息"),//GRP_CUST_INF
    集团客户关系("NGrpRe", "集团客户关系"),//GRP_CUST_RELA
    合同信息("N005", "合同信息"),//CUST_INF
    借据信息("N006", "借据信息"),//IOU_INF
    保证金余额("N007", "保证金余额"),//GUAR_AMT
    保证金关系("N008", "保证金关系"),//GUAR_RELA
    押品信息("NAsset", "押品信息"),//ASS_INF
    押品关系("N010", "押品关系"),//ASS_RELA
    产品信息("N011", "产品信息"),//PROD_INF
    还款流水("N012", "还款流水"),//OUT_SEQ
    保证金账户余额查询("1001103", "保证金账户余额查询"),//GUAR_ACT_BAL_INQ
    批量业务申请交易("9992000", "批量业务申请交易"),//
    批量业务处理结果查询交易("9992008", "批量业务处理结果查询交易"),//
    保证金联机批服务代码("DP1103T", "保证金联机批服务代码"),//
    登记簿查询("2108255", "265登记簿查询"),//REBK_INQ
    表内借据查询("2102025", "表内借据查询"),//T_IOU_INQ
    表外银承借据查询("2108225", "表外银承借据查询"),//T_IOU_INQ
    表外保函借据查询("2108025", "表外保函借据查询"),//T_IOU_INQ
    组合交易("TCombi", "组合交易"),//COMB_AX
    押品价值查询("YP13", "押品价值查询"),//ASS_VAL_INQ
    批量保证金押品变动("FGuarAssetChange", "批量保证金押品变动"),//ASS_VAL_INQ
    额度手动恢复("TRePage", "额度手动恢复"),
    批量准实时首保变动("FNFirstGuarValChange", "批量准实时首保变动"),//ASS_VAL_INQ
    准实时押品价值变动("NAssetValChange", "准实时押品价值变动"),//ASS_VAL_INQ
    准实时回保价值变动("NGuarValChange", "准实时回保价值变动"),//ASS_VAL_INQ
    查询交易响应("TAxRes", "查询交易响应"),//ASS_VAL_INQ
    额度批量业务申请交易("TBatAx", "额度批量业务申请交易"),
    交易日志更新("LogUp", "交易日志更新"),
    额度批量业务处理交易("TBatPr", "额度批量业务处理交易"),//ASS_VAL_INQ
    批量解除缓释关联关系("FTUnFre", "批量解除缓释关联关系"),
    票据额度占用检查交易("TBlUCk", "票据额度占用检查交易"),
    票据额度占用交易("TBilUs", "票据额度占用交易"),
    额度批量占用交易("TUsReg", "额度批量占用交易"), //同业额度批量占用交易
    借新还旧交易("TReBor", "借新还旧交易"), //同业额度批量占用交易
    修改表数据("UpdTab", "修改表数据"),
    节点冻结解冻信息("FreThaQ", "节点冻结解冻信息"),
    批复重算("CleanA", "批复重算"),
    合同票据占用明细查询("TCBUQr", "合同票据占用明细查询"),
    查询合同当前占用的批复编号("TCrAQr", "查询合同当前占用的批复编号");

    public static AxCode getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, AxCode> map;

    static {
        map = new HashMap<String, AxCode>();
        for (AxCode e : AxCode.values()) {
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

    private AxCode(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
