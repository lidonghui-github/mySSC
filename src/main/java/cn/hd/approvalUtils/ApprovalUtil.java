package cn.hd.approvalUtils;

import cn.hd.enums.AxCode;
import cn.hd.enums.ErrorCode;
import cn.hd.enums.FrozStat;
import cn.hd.enums.IsIf;
import cn.hd.mapper.ApprovalMapper;
import cn.hd.model.Approval;
import cn.hd.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 批复相关工具类
 * ldh  2019、11、16
 */
@Component
public class ApprovalUtil {
    protected static Logger logger = LoggerFactory.getLogger(ApprovalUtil.class);
    @Resource
    ApprovalMapper approvalMapper;

    //初始化批复信息
    public void initApprovalInfo(Approval approval, String axCode) {
        if (null == approval) {
            return;
        }
        checkApprovalBaseInfo(approval, axCode);
        if (StringUtil.isNull(approval.getId())) {
            approval.setId(UUIDUtil.getId());
        }
        approval.setCovIntoFlag(IsIf.否.getCode());
        approval.setCovReplFlag(IsIf.否.getCode());
        approval.setCrtTime(DateUtil.getCurrentDateTime());
        approval.setEnabApprAmt(approval.getApprAmt());
        approval.setFrozApprAmt(0L);
        approval.setFrozStat(FrozStat.未冻结.getCode());
        approval.setUseApprAmt(0L);
        approval.setVerNo(1);
    }

    public void checkApprovalBaseInfo(Approval approval, String axcode) {
        if (StringUtil.isNull(approval.getRescriptumno())) {
            logger.error(ErrorCode.批复号不能为空.getName());
            throw new RuntimeException(ErrorCode.批复号不能为空.getName());
        }
        //1.检查批复存在性
        Approval dbApproval = approvalMapper.findApprovalByApprNo(approval.getRescriptumno());
        if (null != dbApproval) {
            if (AxCode.额度新增.getCode().equals(axcode)) {
                logger.error("批复:" + approval.getRescriptumno() + "已存在，不能再次增加");
                throw new RuntimeException("批复:" + approval.getRescriptumno() + "已存在，不能再次增加");
            }
        } else {
            if (AxCode.额度修改.getCode().equals(axcode)) {
                logger.error(ErrorCode.批复号不能修改.getName());
                throw new RuntimeException(ErrorCode.批复号不能修改.getName());
            }
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
        //检查客户存在性，之后再补充

        //检查根节点是否已经属于其他批复
        List<Approval> dbApprByRoots = approvalMapper.findApprovalByRootNo(approval.getRootNo());

        if (null != dbApprByRoots && dbApprByRoots.size() > 0) {
            boolean flag = false;
            if (AxCode.额度新增.getCode().equals(axcode)) {
                flag = true;
            } else if (AxCode.额度修改.getCode().equals(axcode)) {
                if (dbApprByRoots.size() > 1) {
                    flag = true;
                } else if (dbApprByRoots.size() == 1) {
                    if (!StringUtil.isEquals(dbApprByRoots.get(0).getRescriptumno(), approval.getRescriptumno(), false)) {
                        flag = true;
                    }
                }
            }
            if (flag) {
                logger.error(ErrorCode.根节点编号已属于其他批复.getName());
                throw new RuntimeException(ErrorCode.根节点编号已属于其他批复.getName());
            }
        }
    }


    public void updateApprovalInfo(Approval approval, String axcode) {
        checkApprovalBaseInfo(approval, axcode);
        Approval dbApproval = approvalMapper.selectByPrimaryKey(approval.getId());
        approval.setFrozStat(dbApproval.getFrozStat());
        approval.setUseApprAmt(dbApproval.getUseApprAmt());
        approval.setFrozApprAmt(dbApproval.getFrozApprAmt());
        approval.setCrtTime(dbApproval.getCrtTime());
        approval.setUpdTime(DateUtil.getCurrentDateTime());
        approval.setVerNo(StringUtil.isNull(dbApproval.getVerNo()) ? 1 : dbApproval.getVerNo() + 1);
        approval.setCovReplFlag(dbApproval.getCovReplFlag());
        approval.setCovIntoFlag(dbApproval.getCovIntoFlag());
        approval.setEnabApprAmt(BigDecimalUtil.subtract2(BigDecimalUtil.subtract2(approval.getApprAmt(), approval.getFrozApprAmt()), approval.getUseApprAmt()));
    }
}
