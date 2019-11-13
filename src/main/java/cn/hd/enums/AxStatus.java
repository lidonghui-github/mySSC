package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 * @Description：.交易状态
 */
public enum AxStatus {
    待处理("00","待处理"),//待处理
    处理中("01","处理中"),//IN_HAND
    成功("02","成功"),//SUCC
    失败("03","失败"),//FAIL
    文件上传失败("04","文件上传失败"),//SUSP
    归档("05","归档"),
    联机批量文件已回传("08","联机批量文件已回传"),
    异步轮询任务已经获取("09","异步轮询任务已经获取") //由于以前的任务状态 00 01 两个状态瞎用，所以逼不得已添加此状态，用来记录已经被异步轮询线程获取过的任务以防止重复获取任务
    ;//FILE
    public static AxStatus getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, AxStatus> map;

    static {
        map = new HashMap<String, AxStatus>();
        for (AxStatus e : AxStatus.values()) {
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

    private AxStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
