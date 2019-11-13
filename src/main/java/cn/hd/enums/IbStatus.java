package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：借据状态
 */
public enum IbStatus {
    正常("A","正常"),//NORM
    逾期("O","逾期"),//OVERDUE
    核销("V","核销"),//REV
    撤销冲正("R","撤销（冲正）"),//REV_COR
    结清("C","结清"),//CLEAN_UP
    新开立未放款("I","新开立未放款");//NEW_NOT_LOAN
    public static IbStatus getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, IbStatus> map;

    static {
        map = new HashMap<String, IbStatus>();
        for (IbStatus e : IbStatus.values()) {
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

    private IbStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
