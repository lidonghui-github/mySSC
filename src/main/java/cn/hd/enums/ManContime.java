package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.管控时点
 */
public enum ManContime {
    限额生成("01","限额生成"),//LMT_GENE
    授信申请("02","授信申请"),//APPR_APP
    批复生效("03","批复生效"),//APPR_APP
    合同申请("04","合同申请"),//CONT_APP
    合同生效("05","合同生效"),//CONT_EFF
    放款申请("06","放款申请"),//LOAN_APP
    放款("07","放款"),//LOAN
    还款("08","还款"),//REPT
    结清("09","结清"),//CLEAN_UP
    额度切分("10","额度切分");//CRDT_DIM

    public static ManContime getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, ManContime> map;

    static {
        map = new HashMap<String, ManContime>();
        for (ManContime e : ManContime.values()) {
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

    private ManContime(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
