package cn.hd.mapper;

import cn.hd.model.Approval;

public interface ApprovalMapper {
    int deleteByPrimaryKey(String id);

    int insert(Approval record);

    int insertSelective(Approval record);

    Approval selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Approval record);

    int updateByPrimaryKey(Approval record);
}