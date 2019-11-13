package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.
 */
public enum MessageType {
    押品信息("AssetMessage","押品信息"),
    客户附属信息("OrgauxMessage","客户附属信息"),
    客户关系("NCustRMessage","客户关系"),
    集团客户("NGroupMessage","集团客户"),
    集团客户关系("NGrpReMessage","集团客户关系"),
    客户信息("OrgMessage","客户信息");
    public static MessageType getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, MessageType> map;

    static {
        map = new HashMap<String, MessageType>();
        for (MessageType e : MessageType.values()) {
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

    private MessageType(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
