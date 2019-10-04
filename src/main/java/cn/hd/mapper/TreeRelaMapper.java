package cn.hd.mapper;

import cn.hd.model.BaseConditionVO;

import cn.hd.model.TreeRela;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TreeRelaMapper {
    int deleteByPrimaryKey(String id);

    int insert(TreeRela record);

    int insertSelective(TreeRela record);

    TreeRela selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TreeRela record);

    int updateByPrimaryKey(TreeRela record);

    List<TreeRela> queryAll();
    List<TreeRela> query(BaseConditionVO vo);
}