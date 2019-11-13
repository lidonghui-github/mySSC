package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/13.
 * @Description：.组合限额维度类型
 */
public enum GroupType {
    贷款投向行业("01","贷款投向行业"),//LOAN_INV_IND
    客户所属行业("02","客户所属行业"),//CUST_BEL_IND
    区域("03","区域"),//AREA
    客户("04","客户"),//CUST
    产品("05","产品"),//PROD
    期限("06","期限"),//TERM
    担保方式("07","担保方式");//CUAR_TYPE
    public static GroupType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, GroupType> map;

    static {
        map = new HashMap<String, GroupType>();
        for (GroupType e : GroupType.values()) {
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

    private GroupType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
