package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**

 */
public enum GuardBatchQueryStatus {
    步骤成功("B","步骤成功"),
    提交异步作业失败("C","提交异步作业失败"),//
    下传文件失败("D","下传文件失败"),//
    作业失败("E","作业失败"),//
    上传文件失败("F","上传文件失败"),//
    文件重新下传成功("J","文件重新下传成功"),//
    断点续跑成功("K","断点续跑成功"),//
    断点续跑失败("L","断点续跑失败"),//
    MSGWAIT("M","MSGWAIT"),//
    批量作业成功("N","批量作业成功"),//
    作业处理开始("P","作业处理开始"),//
    冲正成功("R","冲正成功"),//
    作业处理中("T","作业处理中"),//
    冲正失败("U","冲正失败"),//
    文件重新下传失败("V","文件重新下传失败"),//
    异常("X","异常");//
    public static GuardBatchQueryStatus getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, GuardBatchQueryStatus> map;

    static {
        map = new HashMap<String, GuardBatchQueryStatus>();
        for (GuardBatchQueryStatus e : GuardBatchQueryStatus.values()) {
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

    private GuardBatchQueryStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
