package cn.hd.service;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Driver;
import cn.hd.model.LoginLog;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ILoginLogService {
    int deleteByPrimaryKey(String id);

    int insert(LoginLog record);

    int insertSelective(LoginLog record);

    LoginLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LoginLog record);

    int updateByPrimaryKey(LoginLog record);

    List<LoginLog> queryAll();
    PageInfo<LoginLog> query(BaseConditionVO vo);


}
