package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/13.
 * @Description：.管控客户类型
 */
public enum ManagerCustomerType {
    一般企业("01","一般企业"),//GENE_BUS
    小企业("02","小企业"),//SMA_BUS
    境内同业客户("03","境内同业客户"),//ONS_SMBUS_CUST
    代理行("04","代理行"),//AGEN_BK
    集团客户("05","集团客户"),//SUB_CUST
    集群客户("06","集群客户"),//COL_CUST
    其他("07","其他"),//OTHER
    战略集团客户("08","战略集团客户"),//STRA_SUB_CUST
    股东关联方("09","股东关联方");//SHDER

    public static ManagerCustomerType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, ManagerCustomerType> map;

    static {
        map = new HashMap<String, ManagerCustomerType>();
        for (ManagerCustomerType e : ManagerCustomerType.values()) {
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

    private ManagerCustomerType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
