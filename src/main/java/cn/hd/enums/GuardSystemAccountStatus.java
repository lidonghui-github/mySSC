package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：保证金系统账户状态
 */
public enum GuardSystemAccountStatus {
    在用("1","在用"),
    待核准("2","待核准"),
    待支付("3","待支付"),
    预销户("4","预销户"),
    销户("5","销户"),
    作废("6","作废"),
    结清("7","结清"),
    睡眠("8","睡眠");
    public static GuardSystemAccountStatus getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, GuardSystemAccountStatus> map;

    static {
        map = new HashMap<String, GuardSystemAccountStatus>();
        for (GuardSystemAccountStatus e : GuardSystemAccountStatus.values()) {
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

    private GuardSystemAccountStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
