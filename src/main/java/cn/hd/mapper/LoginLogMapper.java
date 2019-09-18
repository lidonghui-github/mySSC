package cn.hd.mapper;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.LoginLog;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(LoginLog record);

    int insertSelective(LoginLog record);

    LoginLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LoginLog record);

    int updateByPrimaryKey(LoginLog record);

    List<LoginLog> query(BaseConditionVO vo);

    List<LoginLog> queryAll();

}