package cn.hd.mapper;

import java.util.List;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Role;

import org.springframework.stereotype.Repository;
@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role> queryAll();
    List<Role> query(BaseConditionVO vo);
}