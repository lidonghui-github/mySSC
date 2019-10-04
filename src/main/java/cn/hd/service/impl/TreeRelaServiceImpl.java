package cn.hd.service.impl;

import cn.hd.mapper.TreeRelaMapper;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.TreeRela;
import cn.hd.service.ITreeRelaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("treeRelaService")
public class TreeRelaServiceImpl implements ITreeRelaService {
    @Resource
    TreeRelaMapper treeRelaMapper;

    @Override
    public List<TreeRela> queryAll() {
        return treeRelaMapper.queryAll();
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return treeRelaMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TreeRela record) {
        return treeRelaMapper.insert(record);
    }

    @Override
    public int insertSelective(TreeRela record) {
        return treeRelaMapper.insertSelective(record);
    }

    @Override
    public TreeRela selectByPrimaryKey(String id) {
        return treeRelaMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TreeRela record) {
        return treeRelaMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TreeRela record) {
        return treeRelaMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<TreeRela> query(BaseConditionVO vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<TreeRela> list = treeRelaMapper.query(vo);
        PageInfo<TreeRela> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
