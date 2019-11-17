package cn.hd.mapper;

import cn.hd.model.Approval;
import cn.hd.model.BaseConditionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApprovalMapper {
    int deleteByPrimaryKey(String id);

    int insert(Approval record);

    int insertSelective(Approval record);

    Approval selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Approval record);

    int updateByPrimaryKey(Approval record);

    List<Approval> query(BaseConditionVO vo);

    Approval findApprovalByApprNo(@Param("apprNo") String apprNo);

    List<Approval> findApprovalByRootNo(@Param("rootNo") String rootNo);
}