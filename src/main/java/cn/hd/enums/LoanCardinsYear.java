package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.企业规模细分
 */
public enum LoanCardinsYear {
    规模限额以上("01","规模/限额以上"),//SCA_LMT_ABO
    规模限额以下("02","规模/限额以下");//SCA_LMT_BEL
    public static LoanCardinsYear getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, LoanCardinsYear> map;

        static {
        map = new HashMap<String, LoanCardinsYear>();
        for (LoanCardinsYear e : LoanCardinsYear.values()) {
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

    private LoanCardinsYear(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
