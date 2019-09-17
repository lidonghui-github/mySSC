package cn.hd.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Dept;


public interface IDeptService {
	List<Dept> queryAll();

	int deleteByPrimaryKey(String userid);

	int insert(Dept record);

	int insertSelective(Dept record);

	Dept selectByPrimaryKey(String userid);

	int updateByPrimaryKeySelective(Dept record);

	int updateByPrimaryKey(Dept record);
	PageInfo<Dept> query(BaseConditionVO vo);

}
