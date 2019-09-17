package cn.hd.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.hd.model.BaseConditionVO;

import cn.hd.model.Driver;


public interface IDriverService {
	List<Driver> queryAll();

	int deleteByPrimaryKey(String id);

	int insert(Driver record);

	int insertSelective(Driver record);

	Driver selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Driver record);

	int updateByPrimaryKey(Driver record);
	PageInfo<Driver> query(BaseConditionVO vo);

}
