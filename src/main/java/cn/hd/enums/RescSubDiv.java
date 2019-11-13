package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * 批复细分枚举
 *       01	信审批复
         02	专业化
         0201	A类联合贷款
         0202	B类联合贷款
         0203	类信贷
         0204	同业客户一次切分
         0205	代理行客户一次切分
         0206	集团下同业客户一次?
         03	金融市场自主审批
         04	资管中心自主审批
 */
public enum RescSubDiv {

    信审批复("01", "信审批复"),
    专业化("02", "专业化"),
    A类联合贷款("0201", "A类联合贷款"),
    B类联合贷款("0202", "B类联合贷款"),
    类信贷("0203", "类信贷"),
    同业客户一次切分("0204", "同业客户一次切分"),
    代理行客户一次切分("0205", "代理行客户一次切分"),
    集团下同业客户一次("0206", "集团下同业客户一次"),
    金融市场自主审批("03", "金融市场自主审批"),
    资管中心自主审批("04", "资管中心自主审批");



    public static RescSubDiv getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, RescSubDiv> map;

    static {
        map = new HashMap<String, RescSubDiv>();
        for (RescSubDiv e : RescSubDiv.values()) {
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

    private RescSubDiv(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
