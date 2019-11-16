package cn.hd.approvalUtils;

import cn.hd.enums.ErrorCode;
import cn.hd.mapper.ApprovalMapper;
import cn.hd.model.Approval;
import cn.hd.utils.DateUtil;
import cn.hd.utils.MyDateUtil;
import cn.hd.utils.StringUtil;
import cn.hd.utils.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 批复相关工具类
 * ldh  2019、11、16
 */
@Component
public class ApprovalUtil {
    protected static Logger logger = LoggerFactory.getLogger(ApprovalUtil.class);
    @Resource
    ApprovalMapper approvalMapper;

    public void initApprovalInfo(Approval approval) {
        if (null == approval) {
            return;
        }
        checkApprovalBaseInfo(approval);
        if (StringUtil.isNull(approval.getId())) {
            approval.setId(UUIDUtil.getId());
        }
    }

    public void checkApprovalBaseInfo(Approval approval) {
        //1.检查批复存在性
        Approval dbApproval = approvalMapper.findApprovalByApprNo(approval.getRescriptumno());
        if (null != dbApproval) {
            logger.error("批复:" + approval.getRescriptumno() + "已存在，不能再次增加");
            throw new RuntimeException("批复:" + approval.getRescriptumno() + "已存在，不能再次增加");
        }
        if (StringUtil.isNull(approval.getRescriptumno())) {
            logger.error(ErrorCode.批复号不能为空.getName());
            throw new RuntimeException(ErrorCode.批复号不能为空.getName());
        }
        if (StringUtil.isNull(approval.getCustNo())) {
            logger.error(ErrorCode.客户号不能为空.getName());
            throw new RuntimeException(ErrorCode.客户号不能为空.getName());
        }
        if (StringUtil.isNull(approval.getRootNo())) {
            logger.error(ErrorCode.根节点编号不能为空.getName());
            throw new RuntimeException(ErrorCode.根节点编号不能为空.getName());
        }
        if (StringUtil.isNull(approval.getApprAmt())) {
            logger.error(ErrorCode.授信金额不能为空.getName());
            throw new RuntimeException(ErrorCode.授信金额不能为空.getName());
        }
        if (StringUtil.isNull(approval.getCrdtStat())) {
            logger.error(ErrorCode.额度状态不能为空.getName());
            throw new RuntimeException(ErrorCode.额度状态不能为空.getName());
        }
        if (StringUtil.isNull(approval.getCrdtType())) {
            logger.error(ErrorCode.额度类型不能为空.getName());
            throw new RuntimeException(ErrorCode.额度类型不能为空.getName());
        }
        if (StringUtil.isNull(approval.getCrdtValdDate())) {
            logger.error(ErrorCode.额度生效日不能为空.getName());
            throw new RuntimeException(ErrorCode.额度生效日不能为空.getName());
        }
        if (StringUtil.isNotNull(approval.getCrdtEndDate()) && (approval.getCrdtEndDate().before(approval.getCrdtValdDate()))) {
            logger.error(ErrorCode.额度到期日不能在额度生效日之前.getName());
            throw new RuntimeException(ErrorCode.额度到期日不能在额度生效日之前.getName());
        }
    }
}
