package cn.hd.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Data;


public interface IDataService {
	List<Data> queryAll();

	int deleteByPrimaryKey(String userid);

	int insert(Data record);

	int insertSelective(Data record);

	Data selectByPrimaryKey(String userid);

	int updateByPrimaryKeySelective(Data record);

	int updateByPrimaryKey(Data record);
	PageInfo<Data> query(BaseConditionVO vo);

}
