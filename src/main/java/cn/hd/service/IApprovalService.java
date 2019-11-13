package cn.hd.service;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Approval;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface IApprovalService {
	List<Approval> queryAll();

	int deleteByPrimaryKey(String id);

	int insert(Approval record);

	int insertSelective(Approval record);

	Approval selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Approval record);

	int updateByPrimaryKey(Approval record);
	PageInfo<Approval> query(BaseConditionVO vo);

}
