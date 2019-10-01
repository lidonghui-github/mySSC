package cn.hd.mapper;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Contract;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractMapper {
    int deleteByPrimaryKey(String id);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);

    List<Contract> queryAll();
    List<Contract> query(BaseConditionVO vo);
}