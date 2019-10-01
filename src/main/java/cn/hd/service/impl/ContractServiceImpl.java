package cn.hd.service.impl;

import cn.hd.mapper.ContractMapper;
import cn.hd.model.BaseConditionVO;
import cn.hd.model.Contract;
import cn.hd.service.IContractService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ContractServiceImpl implements IContractService {

    @Resource
    ContractMapper contractMapper;

    @Override
    public List<Contract> queryAll() {
        return contractMapper.queryAll();
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return contractMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Contract record) {
        return contractMapper.insert(record);
    }

    @Override
    public int insertSelective(Contract record) {
        return contractMapper.insertSelective(record);
    }

    @Override
    public Contract selectByPrimaryKey(String id) {
        return contractMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Contract record) {
        return contractMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Contract record) {
        return contractMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Contract> query(BaseConditionVO vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<Contract> list=contractMapper.query(vo);
        PageInfo<Contract> pageInfo=new PageInfo<Contract>(list);
        return pageInfo;
    }
}
