package cn.hd.service;

import cn.hd.model.BaseConditionVO;

import cn.hd.model.ContractInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IContractInfoService {
    List<ContractInfo> queryAll();

    int deleteByPrimaryKey(String id);

    int insert(ContractInfo record);

    int insertSelective(ContractInfo record);

    ContractInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ContractInfo record);

    int updateByPrimaryKey(ContractInfo record);

    PageInfo<ContractInfo> query(BaseConditionVO vo);

}
