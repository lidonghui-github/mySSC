package cn.hd.mapper;

import cn.hd.model.LoginLog;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(LoginLog record);

    int insertSelective(LoginLog record);

    LoginLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LoginLog record);

    int updateByPrimaryKey(LoginLog record);
}