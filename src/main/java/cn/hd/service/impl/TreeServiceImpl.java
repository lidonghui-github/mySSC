package cn.hd.service.impl;

import cn.hd.enums.CrdtStat;
import cn.hd.enums.FrozStat;
import cn.hd.mapper.TreeMapper;
import cn.hd.model.BaseConditionVO;
import cn.hd.model.Tree;
import cn.hd.service.ITreeService;
import cn.hd.utils.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TreeServiceImpl implements ITreeService {
    @Resource
    TreeMapper treeMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return treeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Tree record) {
        record.setId(UUIDUtil.getId());
        record.setCrtTime(DateUtil.getCurrentDateTime());
        record.setCrtTimeFormat(MyDateUtil.dateFormate_YYYY_MM_DD_HH_mm_ss(record.getCrtTime()));
        record.setVerNo(1);
        record.setUsedAmt(0);
        record.setFrozAmt(0);
        record.setEnabAmt(record.getApprAmt());
        record.setFrozStat(FrozStat.未冻结.getCode());
        return treeMapper.insert(record);
    }

    @Override
    public int insertSelective(Tree record) {
        return treeMapper.insertSelective(record);
    }

    @Override
    public Tree selectByPrimaryKey(String id) {
        return treeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Tree record) {
        return treeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Tree record) {
        //1.先查出有没有该节点
        Tree tree = treeMapper.selectByPrimaryKey(record.getId());
        //2.如果存在就更新tree的相关值
        tree.setApprAmt(record.getApprAmt());
        tree.setUpdTime(DateUtil.getCurrentDateTime());
        tree.setVerNo(StringUtil.isNull(tree.getVerNo()) ? 1 : tree.getVerNo() + 1);
        tree.setUpdTimeFormat(MyDateUtil.dateFormate_YYYY_MM_DD_HH_mm_ss(tree.getUpdTime()));
        tree.setApprNo(record.getApprNo());
        tree.setTreeNo(record.getTreeNo());
        tree.setCrdtStat(record.getCrdtStat());
        tree.setUpTreeNo(record.getUpTreeNo());
        tree.setTreeName(record.getTreeName());
        if (StringUtil.isNull(tree.getUsedAmt())) {
            tree.setUsedAmt(0);
        }
        if (StringUtil.isNull(tree.getFrozAmt())) {
            tree.setFrozAmt(0);
        }
        tree.setEnabAmt(tree.getApprAmt() - tree.getUsedAmt() - tree.getFrozAmt());
        tree.setRemark(record.getRemark());
        return treeMapper.updateByPrimaryKey(tree);
    }

    @Override
    public List<Tree> queryAll() {
        return treeMapper.queryAll();
    }

    @Override
    public PageInfo<Tree> query(BaseConditionVO vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<Tree> list = treeMapper.query(vo);
        PageInfo<Tree> pageInfo = new PageInfo<Tree>(list);
        return pageInfo;
    }

    @Override
    public Tree selectByTreeNo(String treeNo) {
        return treeMapper.selectByTreeNo(treeNo);
    }

    @Override
    public int frozTree(Tree tree) {
        tree.setFrozAmt(tree.getApprAmt());
        tree.setFrozStat(FrozStat.全部冻结.getCode());
        tree.setEnabAmt(tree.getApprAmt() - tree.getUsedAmt() - tree.getFrozAmt());
        tree.setVerNo(tree.getVerNo() + 1);
        tree.setUpdTime(DateUtil.getCurrentDateTime());
        tree.setUpdTimeFormat(MyDateUtil.dateFormate_YYYY_MM_DD_HH_mm_ss(tree.getUpdTime()));
        return treeMapper.updateByPrimaryKey(tree);

    }

    @Override
    public int tthawTree(Tree tree) {
        tree.setFrozAmt(0);
        tree.setFrozStat(FrozStat.未冻结.getCode());
        tree.setEnabAmt(tree.getApprAmt() - tree.getUsedAmt() - tree.getFrozAmt());
        tree.setVerNo(tree.getVerNo() + 1);
        tree.setUpdTime(DateUtil.getCurrentDateTime());
        tree.setUpdTimeFormat(MyDateUtil.dateFormate_YYYY_MM_DD_HH_mm_ss(tree.getUpdTime()));
        return treeMapper.updateByPrimaryKey(tree);
    }
}
