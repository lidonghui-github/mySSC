package cn.hd.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Menu;

public interface IMenuService {
	List<Menu> queryAll();

	int deleteByPrimaryKey(String userid);

	int insert(Menu record);

	int insertSelective(Menu record);

	Menu selectByPrimaryKey(String userid);

	int updateByPrimaryKeySelective(Menu record);

	int updateByPrimaryKey(Menu record);
	PageInfo<Menu> query(BaseConditionVO vo);

}
