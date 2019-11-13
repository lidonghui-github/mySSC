package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum ProductionType {
    供应链金融买方额度("01", "供应链金融买方额度"),//LINK_FIN_BUY_CRDT
    供应链金融卖方额度("02", "供应链金融卖方额度"),//LINK_FIN_SELL_CRDT
    供应链金融监管方额度("03", "供应链金融监管方额度"),//LINK_FIN_SUP_CRDT
    供应链金融保险公司额度("04", "供应链金融保险公司额度"),//LINK_FIN_IRCP_CRDT
    担保公司额度("05", "担保公司额度"),//GUAR_COMP_CRDT
    开发商按揭额度("06", "开发商按揭额度"),//DEVE_MORT_CRDT
    银票承兑行额度("07", "银票承兑行额度"),//NOTE_ACCBK_CRDT
    商票承兑人额度("08", "商票承兑人额度"),//TICK_ACDA_CRDT
    信用证开证行额度("09", "信用证开证行额度"),//CRED_ISSBK_CRDT
    债券发行人额度("10", "债券发行人额度"),//BOND_ISSU_CRDT
    代开委托行额度("11", "代开委托行额度"),//OPEN_PRIBK_CRDT
    代付委托行额度("12", "代付委托行额度");//PAY_PRIBK_CRDT


    public static ProductionType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, ProductionType> map;

    static {
        map = new HashMap<String, ProductionType>();
        for (ProductionType e : ProductionType.values()) {
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

    private ProductionType(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
