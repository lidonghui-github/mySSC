package cn.hd.service;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Contract;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IContractService {
	List<Contract> queryAll();

	int deleteByPrimaryKey(String id);

	int insert(Contract record);

	int insertSelective(Contract record);

	Contract selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Contract record);

	int updateByPrimaryKey(Contract record);
	PageInfo<Contract> query(BaseConditionVO vo);

}
