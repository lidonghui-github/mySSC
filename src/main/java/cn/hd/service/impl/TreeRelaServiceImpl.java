package cn.hd.service.impl;

import cn.hd.mapper.TreeRelaMapper;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.TreeRela;
import cn.hd.service.ITreeRelaService;
import cn.hd.utils.DateUtil;
import cn.hd.utils.MyDateUtil;
import cn.hd.utils.StringUtil;
import cn.hd.utils.UUIDUtil;
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
        initSaveTreeRela(record);
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
        TreeRela treeRela = updateTreeRela(record);
        return treeRelaMapper.updateByPrimaryKey(treeRela);
    }

    @Override
    public PageInfo<TreeRela> query(BaseConditionVO vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<TreeRela> list = treeRelaMapper.query(vo);
        PageInfo<TreeRela> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<TreeRela> naruquery(BaseConditionVO vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<TreeRela> list = treeRelaMapper.naruquery(vo);
        PageInfo<TreeRela> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<TreeRela> replacequery(BaseConditionVO vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<TreeRela> list = treeRelaMapper.replacequery(vo);
        PageInfo<TreeRela> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<TreeRela> glquery(BaseConditionVO vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<TreeRela> list = treeRelaMapper.glquery(vo);
        PageInfo<TreeRela> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


    //初始化额度关系信息
    public void initSaveTreeRela(TreeRela record) {
        if (StringUtil.isNull(record.getId())) {
            record.setId(UUIDUtil.getId());
        }
        if (StringUtil.isNull(record.getCrtTime())) {
            record.setCrtTime(DateUtil.getCurrentDateTime());
            record.setCrtTimeFormat(MyDateUtil.dateFormate_YYYY_MM_DD_HH_mm_ss(record.getCrtTime()));
        }
        if (StringUtil.isNull(record.getVerNo())) {
            record.setVerNo(1);
        }
    }

    //更新额度关系信息
    public TreeRela updateTreeRela(TreeRela record) {
        TreeRela treeRela = treeRelaMapper.selectByPrimaryKey(record.getId());
        treeRela.setUpdTime(DateUtil.getCurrentDateTime());
        treeRela.setUpdTimeFromat(MyDateUtil.dateFormate_YYYY_MM_DD_HH_mm_ss(treeRela.getUpdTime()));
        treeRela.setVerNo(StringUtil.isNull(treeRela.getVerNo()) ? 1 : treeRela.getVerNo() + 1);
        treeRela.setRemark(record.getRemark());
        treeRela.setRelaType(record.getRelaType());
        treeRela.setValidFlag(record.getValidFlag());
        return treeRela;
    }
}
