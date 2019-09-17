package cn.hd.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Userbean;

public interface IUserService {
	List<Userbean> queryAll();

	int deleteByPrimaryKey(String userid);

	int insert(Userbean record);

	int insertSelective(Userbean record);

	Userbean selectByPrimaryKey(String userid);

	int updateByPrimaryKeySelective(Userbean record);

	int updateByPrimaryKey(Userbean record);
	PageInfo<Userbean> query(BaseConditionVO vo);
	
	List<Userbean> findUserByName(String userName);

}
