package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * <p></p>
 * 作者：$ wp
 * 日期：2016/10/24 16:54
 */
public enum ToParameter {

    汇率("P_S_PA_EXCH","CL_O_EXCH"),//汇率
    行业信息("P_S_PA_INDU","CL_O_INDU"),//行业信息
    行业大类("P_S_PA_INDU_TYPE","CL_O_INDU_TYPE"),//行业大类
    币种信息("P_S_PA_CCY","CL_O_CNCY"),//币种信息
    汇率任务("P_S_PA_EXCH","PARAMETER"),//汇率
    行业信息任务("P_S_PA_INDU","PARAMETER"),//行业信息
    行业大类任务("P_S_PA_INDU_TYPE","PARAMETER"),//行业大类
    币种信息任务("P_S_PA_CCY","PARAMETER"),//币种信息
    机构信息("P_S_PA_ORG_INFO","CL_O_PA_ORG_INFO,CL_O_PA_ORG_TREE"),//机构信息
    机构信息任务("P_S_PA_ORG_INFO","ORG");//机构信息
    private final String code;
    private final String name;

    private ToParameter(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static ToParameter getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, ToParameter> map;

    static {
        map = new HashMap<String, ToParameter>();

        for (ToParameter parameter : ToParameter.values()) {
            map.put(parameter.getCode(), parameter);
        }
    }

    public boolean equals(String code) {
        return this.code.equals(code);
    }


}
