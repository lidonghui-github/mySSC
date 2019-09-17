package cn.hd.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Role;

public interface IRoleService {
	List<Role> queryAll();

	int deleteByPrimaryKey(String userid);

	int insert(Role record);

	int insertSelective(Role record);

	Role selectByPrimaryKey(String userid);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);
	PageInfo<Role> query(BaseConditionVO vo);

}
