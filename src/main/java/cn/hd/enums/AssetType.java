package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 缓释押品类型名称
 */
public enum AssetType {

    银行存单("1","银行存单"),//BAR_BILL
    国债("2","国债"),//DEPT
    银行承兑汇票("3","银行承兑汇票"),//BAR_ACPT_DRA
    票据池质押("4","票据池质押"),//BAR_ACPT_DRA
    商业承兑汇票("5","商业承兑汇票");//BAR_ACPT_DRA

    public static AssetType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, AssetType> map;

    static {
        map = new HashMap<String, AssetType>();
        for (AssetType e : AssetType.values()) {
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

    private AssetType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
