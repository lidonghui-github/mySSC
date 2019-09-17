package cn.hd.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.hd.model.BaseConditionVO;

import cn.hd.model.Driver;
@Repository
public interface DriverMapper {
    int deleteByPrimaryKey(String driverId);

    int insert(Driver record);

    int insertSelective(Driver record);

    Driver selectByPrimaryKey(String driverId);

    int updateByPrimaryKeySelective(Driver record);

    int updateByPrimaryKey(Driver record);
    List<Driver> queryAll();
    List<Driver> query(BaseConditionVO vo);
}