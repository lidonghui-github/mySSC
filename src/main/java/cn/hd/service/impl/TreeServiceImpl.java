package cn.hd.service.impl;

import cn.hd.enums.FrozStat;
import cn.hd.mapper.TreeMapper;
import cn.hd.model.BaseConditionVO;
import cn.hd.model.Tree;
import cn.hd.service.ITreeService;
import cn.hd.utils.DateUtil;
import cn.hd.utils.MyDateUtil;
import cn.hd.utils.StringUtil;
import cn.hd.utils.UUIDUtil;
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
        record.setUpdTime(DateUtil.getCurrentDateTime());
        record.setVerNo(StringUtil.isNull(record.getVerNo()) ? 1 : record.getVerNo() + 1);
        record.setUpdTimeFormat(MyDateUtil.dateFormate_YYYY_MM_DD_HH_mm_ss(record.getUpdTime()));

        return treeMapper.updateByPrimaryKey(record);
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
}
