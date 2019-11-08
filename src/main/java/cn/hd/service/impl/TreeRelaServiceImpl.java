package cn.hd.service.impl;

import cn.hd.mapper.TreeRelaMapper;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Tree;
import cn.hd.model.TreeRela;
import cn.hd.service.ITreeRelaService;
import cn.hd.service.ITreeService;
import cn.hd.utils.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("treeRelaService")
public class TreeRelaServiceImpl implements ITreeRelaService {
    @Resource
    TreeRelaMapper treeRelaMapper;
    @Resource
    ITreeService treeService;

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
        //组织额度关系
        initSaveTreeRela(record);
        //更新纳入额度数据
        updateBigTreeMoneyByTreeRela(record);
        //插入额度关系
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

    @Override
    public List<TreeRela> findTreeRelaByBigAndSmallTreeNo(String bigTreeNo, String smallTreeNo) {
        return treeRelaMapper.findTreeRelaByBigAndSmallTreeNo(bigTreeNo, smallTreeNo);
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

    //更新纳入额度的已用、可用金额
    public void updateBigTreeMoneyByTreeRela(TreeRela treeRela) {
        Tree bigTree = treeService.selectByTreeNo(treeRela.getBigTreeNo());
        Tree smallTree = treeService.selectByTreeNo(treeRela.getSmallTreeNo());
        bigTree.setUsedAmt(BigDecimalUtil.add(bigTree.getUsedAmt(), smallTree.getUsedAmt()));
        bigTree.setEnabAmt(BigDecimalUtil.subtract1(bigTree.getEnabAmt(), smallTree.getUsedAmt()));
        bigTree.setUpdTime(DateUtil.getCurrentDateTime());
        bigTree.setUpdTimeFormat(MyDateUtil.dateFormate_YYYY_MM_DD_HH_mm_ss(bigTree.getUpdTime()));
        bigTree.setVerNo(StringUtil.isNull(bigTree.getVerNo()) ? 1 : treeRela.getVerNo() + 1);
        bigTree.setRemark("额度关系:["+bigTree.getTreeNo()+" 关系类型:"+treeRela.getRelaType()+" "+smallTree.getTreeNo()+"]所致");
        try {
            treeService.updateByPrimaryKeySelective(bigTree);
        } catch (Exception ex) {
            throw new RuntimeException("更新额度:" + bigTree.getTreeNo() + "失败....");
        }
    }
}
