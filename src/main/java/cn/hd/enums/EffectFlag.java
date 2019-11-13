package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Description：.合同有效标志
 */
public enum EffectFlag {
    未生效("00","未生效"),//NOT_EFF
    有效("01","有效"),//EFF
    到期后失效("02","到期后失效"),//EXPI_INVA
    复议后失效("05","复议后失效"),//REVI_INVA
    超出首次提款有效期后失效("06","超出首次提款有效期后失效"),//OVFI_DATM_INVA
    手工终止("08","手工终止"),//MANU_END
    取代后失效("09","取代后失效"),//REPL_INVA
    否决后批复("99","否决后批复");//VETO_REPLY
    public static EffectFlag getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, EffectFlag> map;

    static {
        map = new HashMap<String, EffectFlag>();
        for (EffectFlag e : EffectFlag.values()) {
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

    private EffectFlag(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
