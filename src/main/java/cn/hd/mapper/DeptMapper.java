package cn.hd.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Dept;

@Repository
public interface DeptMapper {
    int deleteByPrimaryKey(String deptId);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(String deptId);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
    List<Dept> queryAll();
    List<Dept> query(BaseConditionVO vo);
}