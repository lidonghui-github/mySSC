package cn.hd.service;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.LoginLog;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ILoginLogService {
	List<LoginLog> queryAll();

	int deleteByPrimaryKey(String userid);

	int insert(LoginLog record);

	int insertSelective(LoginLog record);

	LoginLog selectByPrimaryKey(String userid);

	int updateByPrimaryKeySelective(LoginLog record);

	int updateByPrimaryKey(LoginLog record);
	PageInfo<LoginLog> query(BaseConditionVO vo);
	
	List<LoginLog> findLoginLog(String userName);

}
