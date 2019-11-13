package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 *
 *  批复表  打包申请标识
 */
public enum ClBCrCrdtApprPackageFlag {
  /*  01	主批复
    02	子批复
    03	非打包
    04	集团批复*/


    主批复("01","主批复"),
    子批复("02","子批复"),
    非打包("03","非打包"),
    集团批复("04","集团批复");


    public static ClBCrCrdtApprPackageFlag getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, ClBCrCrdtApprPackageFlag> map;

    static {
        map = new HashMap<String, ClBCrCrdtApprPackageFlag>();
        for (ClBCrCrdtApprPackageFlag e : ClBCrCrdtApprPackageFlag.values()) {
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

    private ClBCrCrdtApprPackageFlag(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
