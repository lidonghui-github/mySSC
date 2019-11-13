package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum OrgStatus {
    正常("1","正常"),//NORM
    注销("2","注销"),//CANC
    停用("3","停用"),//BLOCK_UP
    待生效("4","待生效"),//STAY_EFF
    冻结("5","冻结");//FROZ
    public static OrgStatus getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, OrgStatus> map;

    static {
        map = new HashMap<String, OrgStatus>();
        for (OrgStatus e : OrgStatus.values()) {
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

    private OrgStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
