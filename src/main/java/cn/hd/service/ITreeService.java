package cn.hd.service;

import cn.hd.model.BaseConditionVO;

import cn.hd.model.Tree;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ITreeService {
    int deleteByPrimaryKey(String id);

    int insert(Tree record);

    int insertSelective(Tree record);

    Tree selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Tree record);

    int updateByPrimaryKey(Tree record);
    List<Tree> queryAll();
    PageInfo<Tree> query(BaseConditionVO vo);
}
