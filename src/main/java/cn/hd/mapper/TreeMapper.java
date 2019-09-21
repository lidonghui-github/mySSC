package cn.hd.mapper;

import cn.hd.model.Tree;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Tree record);

    int insertSelective(Tree record);

    Tree selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Tree record);

    int updateByPrimaryKey(Tree record);
}