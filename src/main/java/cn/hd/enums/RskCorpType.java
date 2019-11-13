package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author :Created by 贡宏才 .
 * @Date : 2017/4/18 10:49
 * @Description :
 */
public enum RskCorpType {
    //01银监会定义钢贸企业02我行定义钢贸企业03铜贸企业04光伏企业05非风险客户
    银监会定义钢贸企业("01","银监会定义钢贸企业"),
    我行定义钢贸企业("02","我行定义钢贸企业"),
    铜贸企业("03","铜贸企业"),
    光伏企业("04","光伏企业"),
    非风险客户("05","非风险客户");//
    public static RskCorpType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, RskCorpType> map;

    static {
        map = new HashMap<String, RskCorpType>();
        for (RskCorpType e : RskCorpType.values()) {
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

    private RskCorpType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
