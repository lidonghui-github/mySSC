package cn.hd.service.impl;

import cn.hd.approvalUtils.ApprovalUtil;
import cn.hd.mapper.ApprovalMapper;
import cn.hd.model.Approval;
import cn.hd.model.BaseConditionVO;


import cn.hd.service.IApprovalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;
@Service
public class ApprovalServiceImpl implements IApprovalService {
    @Resource
    ApprovalMapper approvalMapper;
    @Resource
    ApprovalUtil approvalUtil;
    @Override
    public List<Approval> queryAll() {
        return null;
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return approvalMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Approval record) {
        approvalUtil.initApprovalInfo(record);
        return approvalMapper.insert(record);
    }

    @Override
    public int insertSelective(Approval record) {
        return approvalMapper.insertSelective(record);
    }

    @Override
    public Approval selectByPrimaryKey(String id) {
        return approvalMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Approval record) {
        return approvalMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Approval record) {
        return approvalMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Approval> query(BaseConditionVO vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<Approval> list=approvalMapper.query(vo);
        System.out.println(list.size());
        PageInfo<Approval> pageInfo = new PageInfo<Approval>(list);
        return pageInfo;
    }
}
