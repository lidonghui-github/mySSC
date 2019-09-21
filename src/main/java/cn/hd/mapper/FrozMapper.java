package cn.hd.mapper;

import cn.hd.model.Froz;

public interface FrozMapper {
    int deleteByPrimaryKey(String id);

    int insert(Froz record);

    int insertSelective(Froz record);

    Froz selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Froz record);

    int updateByPrimaryKey(Froz record);
}