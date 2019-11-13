package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum UsegBusChkTime {

    授信申请("02","授信申请"),//APPR_APP
    授信审批("03","授信审批"),//APPR_APP
    合同申请("04","合同申请"),//CONT_APP
    合同生效("05","合同生效"),//CONT_EFF
    放款申请("06","放款申请"),//LOAN_APP
    放款("07","放款");//LOAN


    public static UsegBusChkTime getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, UsegBusChkTime> map;

    static {
        map = new HashMap<String, UsegBusChkTime>();
        for (UsegBusChkTime e : UsegBusChkTime.values()) {
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

    private UsegBusChkTime(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
