package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：人工恢复页面指令代码
 */
public enum ManualAction {
    查询保证金("1","查询保证金"),
    同步保证金("2","同步保证金"),
    查询押品("3","查询押品"),
    同步押品("4","同步押品"),
    同步表内借据("5","同步表内借据"),
    同步登记簿("6","同步265登记簿"),
    合同重新缓释("7","合同重新缓释"),
    同步表外银承借据("8","同步表外银承借据"),
    同步表外保函借据("9","同步表外保函借据"),
    批复重算("10","批复重算"),
    合同批复("11","合同批复");
    public static ManualAction getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, ManualAction> map;

    static {
        map = new HashMap<String, ManualAction>();
        for (ManualAction e : ManualAction.values()) {
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

    private ManualAction(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
