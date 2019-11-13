package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description： 配置文件枚举
 */
public enum PropertiesEnum {
    代保管业务编号格式("cdbs_biz_no","代保管业务编号格式"),//CUS_SERNO_FORM
    归档("source_name","归档");//FILE
    public static PropertiesEnum getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, PropertiesEnum> map;

    static {
        map = new HashMap<String, PropertiesEnum>();
        for (PropertiesEnum e : PropertiesEnum.values()) {
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

    private PropertiesEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
