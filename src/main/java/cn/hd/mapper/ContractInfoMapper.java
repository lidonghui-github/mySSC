package cn.hd.mapper;

import cn.hd.model.BaseConditionVO;

import cn.hd.model.ContractInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ContractInfo record);

    int insertSelective(ContractInfo record);

    ContractInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ContractInfo record);

    int updateByPrimaryKey(ContractInfo record);

    List<ContractInfo> queryAll();
    List<ContractInfo> query(BaseConditionVO vo);
}