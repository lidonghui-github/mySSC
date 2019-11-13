package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description: 缓释押品类型名称
 */
public enum SystemUser {

    准实时用户("LCMS-FIRETASK","准实时用户"),//BAR_BILL
    MQ用户("LCMS-MQ","MQ用户"),//DEPT
    批量处理用户("LCMS-PL","批量处理用户"),//BAR_ACPT_DRA
    LCMS联机用户("LCMS-ONLINE","LCMS联机用户"),//BAR_ACPT_DRA用于联机查询核心、押品系统
    WEB联机用户("LCMT","WEB联机用户");//BAR_ACPT_DRA// 可以不用web有登录用户

    public static SystemUser getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, SystemUser> map;

    static {
        map = new HashMap<String, SystemUser>();
        for (SystemUser e : SystemUser.values()) {
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

    private SystemUser(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
