package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum ToParameterFlag {

    成功("S","Successful"),//更新成功
    失败("F","Failed");//更新失败

    private final String code;
    private final String name;

    private ToParameterFlag(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static ToParameterFlag getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, ToParameterFlag> map;

    static {
        map = new HashMap<String, ToParameterFlag>();

        for (ToParameterFlag parameter : ToParameterFlag.values()) {
            map.put(parameter.getCode(), parameter);
        }
    }

    public boolean equals(String code) {
        return this.code.equals(code);
    }
}
