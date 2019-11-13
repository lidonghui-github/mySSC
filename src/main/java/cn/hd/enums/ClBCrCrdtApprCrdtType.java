package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**


 *  批复表  额度类型
 */
public enum ClBCrCrdtApprCrdtType {

    /*
    01	综合授信额度
    02	同业综合授信额度
    03	专项授信额度
    04	供应链网络间接额度
    05	供应链直接授信额度
    06	低风险授信额度
    07	综合融资业务额度

    */
    综合授信额度("01","综合授信额度"),
    同业综合授信额度("02","同业综合授信额度"),
    专项授信额度("03","专项授信额度"),
    供应链网络间接额度("04","供应链网络间接额度"),
    供应链直接授信额度("05","供应链直接授信额度"),
    低风险授信额度("06","低风险授信额度"),
    综合融资业务额度("07","综合融资业务额度");

    public static ClBCrCrdtApprCrdtType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, ClBCrCrdtApprCrdtType> map;

    static {
        map = new HashMap<String, ClBCrCrdtApprCrdtType>();
        for (ClBCrCrdtApprCrdtType e : ClBCrCrdtApprCrdtType.values()) {
            map.put(e.getCode(), e);
        }
    }

    public boolean equals(String code) {
        return code != null && this.code.equals(code.trim());
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    private final String code;
    private final String name;

    private ClBCrCrdtApprCrdtType(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
