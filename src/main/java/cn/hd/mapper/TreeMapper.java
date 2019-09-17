package cn.hd.mapper;



import java.util.List;

import org.springframework.stereotype.Repository;

import cn.hd.model.Tree;
@Repository
public interface TreeMapper {
    int deleteByPrimaryKey(String nodeNo);

    int insert(Tree record);

    int insertSelective(Tree record);

    Tree selectByPrimaryKey(String nodeNo);

    int updateByPrimaryKeySelective(Tree record);

    int updateByPrimaryKey(Tree record);
    
    List<Tree> findTrees(Tree record);
}