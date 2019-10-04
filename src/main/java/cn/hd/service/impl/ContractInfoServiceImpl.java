package cn.hd.service.impl;

import cn.hd.mapper.ContractInfoMapper;
import cn.hd.model.BaseConditionVO;

import cn.hd.model.ContractInfo;

import cn.hd.service.IContractInfoService;
import cn.hd.utils.DateUtil;
import cn.hd.utils.MyDateUtil;
import cn.hd.utils.StringUtil;
import cn.hd.utils.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


import java.util.List;

@Service("contractInfoService")
public class ContractInfoServiceImpl implements IContractInfoService {
    @Resource
    ContractInfoMapper contractInfoMapper;

    @Override
    public List<ContractInfo> queryAll() {
        return contractInfoMapper.queryAll();
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return contractInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ContractInfo record) {
        initSaveContractInfo(record);
        return contractInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(ContractInfo record) {
        return contractInfoMapper.insertSelective(record);
    }

    @Override
    public ContractInfo selectByPrimaryKey(String id) {
        return contractInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ContractInfo record) {
        return contractInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ContractInfo record) {
        ContractInfo vo = updateContractInfo(record);
        return contractInfoMapper.updateByPrimaryKey(vo);
    }

    @Override
    public PageInfo<ContractInfo> query(BaseConditionVO vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<ContractInfo> list = contractInfoMapper.query(vo);
        PageInfo<ContractInfo> pageInfo = new PageInfo<ContractInfo>(list);
        return pageInfo;
    }

    //初始化合同节点信息
    public void initSaveContractInfo(ContractInfo contractInfo) {
        if (StringUtil.isNull(contractInfo.getId())) {
            contractInfo.setId(UUIDUtil.getId());
        }
        if (StringUtil.isNull(contractInfo.getCrtTime())) {
            contractInfo.setCrtTime(DateUtil.getCurrentDateTime());
            contractInfo.setCrtTimeFormat(MyDateUtil.dateFormate_YYYY_MM_DD_HH_mm_ss(contractInfo.getCrtTime()));
        }
        if (StringUtil.isNull(contractInfo.getVerNo())) {
            contractInfo.setVerNo(1);
        }
    }

    //更新合同节点信息
    public ContractInfo updateContractInfo(ContractInfo record) {
        ContractInfo contractInfo = contractInfoMapper.selectByPrimaryKey(record.getId());
        contractInfo.setUpdTime(DateUtil.getCurrentDateTime());
        contractInfo.setUpdTimeFormat(MyDateUtil.dateFormate_YYYY_MM_DD_HH_mm_ss(contractInfo.getUpdTime()));
        contractInfo.setVerNo(StringUtil.isNull(contractInfo.getVerNo()) ? 1 : contractInfo.getVerNo() + 1);
        contractInfo.setRemark(record.getRemark());
        contractInfo.setContStat(record.getContStat());
        return contractInfo;
    }
}
