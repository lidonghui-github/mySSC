package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description: 数据字典类型
 */
public enum DictType {

    缓释押品类型("ASSET-COLLATERALTYPE","缓释押品类型"),//RE_ASS_TYPE
    银行承兑汇票出具行("ASSET-ACCEPTANCEBANKS","银行承兑汇票出具行"),//BKAC_BILL_ISSBK
    存单币种("ASSET-ACCOUNTCURRENCY","存单币种"),//DEPO_RECE_CNCY
    维度期限限额("DEADLINE","维度期限限额"),
    主要担保方式("GUARTYPE","主要担保方式"),
    客户标识限额("CUSTOMERFLAG","客户标识限额"),
    币种限额("CNYLIMT","客户标识限额"),
    系统开关("LCMS_SWITCH","系统开关"),
    总行营业部金融同业部("FI_ORG","总行营业部金融同业部"),
    福费廷产品码("LCMS_FFT_PROCODE","福费廷产品码"),//FFT貌似只有一个‘卖断卖出’转卖结清状态
    转卖回购不恢复产品码("BILL_RESALE_NOT_RESTORE", "转卖回购不恢复产品码"),//票据占卖断卖出或回购卖出时不恢复
    转卖回购不恢复到期后延迟恢复天数("BILL_RESALE_RESTORE_day", "转卖回购不恢复到期后延迟恢复天数"),//票据占卖断卖出或回购卖出时不恢复
    保理业务他用额度产品码("LCMS_BL_OTHER","保理业务他用额度产品码"),
    不检查合同起始日期期限产品字典("NOT_CHECK_CONT_STR_DATE","不检查合同起始日期期限产品字典"),
    不检查合同到期日期期限产品字典("NOT_CHECK_CONT_END_DATE","不检查合同到期日期期限产品字典"),
    额度恢复重算开关("BTRECOV_SWITCH","额度恢复重算开关"),
    叶子检查开关("CHECK_NODE","叶子检查开关"),
    合同到期不恢复的产品码("CONT_EXPIRES_NOT_RECOV", "合同到期不恢复的产品码"),
    同业财务公司("03020800", "同业财务公司"),
    代理行财务公司("04030100", "代理行财务公司");

    public static DictType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, DictType> map;

    static {
        map = new HashMap<String, DictType>();
        for (DictType e : DictType.values()) {
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

    private DictType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
