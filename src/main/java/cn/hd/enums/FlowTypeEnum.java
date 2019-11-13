package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum FlowTypeEnum {

    文件下载("1","文件下载"),
    文件就绪("2","文件就绪"),
    文件导入("3","文件导入"),
    数据加工("4","数据加工"),
    跑批处理("5","跑批处理"),
    轮循("6","轮循");

    public static FlowTypeEnum getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, FlowTypeEnum> map;

    static {
        map = new HashMap<String, FlowTypeEnum>();
        for (FlowTypeEnum e : FlowTypeEnum.values()) {
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

    private FlowTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
