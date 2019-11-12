package cn.hd.mapper;

import java.util.List;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Data;

import org.springframework.stereotype.Repository;

@Repository
public interface DataMapper {
    int deleteByPrimaryKey(String dataId);

    int insert(Data record);

    int insertSelective(Data record);

    Data selectByPrimaryKey(String dataId);

    int updateByPrimaryKeySelective(Data record);

    int updateByPrimaryKey(Data record);
    List<Data> queryAll();
    List<Data> query(BaseConditionVO vo);
}