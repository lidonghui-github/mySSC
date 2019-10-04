package cn.hd.service.impl;

import cn.hd.buss.TreeContractUtil;
import cn.hd.mapper.ContractMapper;
import cn.hd.model.BaseConditionVO;
import cn.hd.model.Contract;
import cn.hd.service.IContractService;
import cn.hd.utils.DateUtil;
import cn.hd.utils.MyDateUtil;
import cn.hd.utils.StringUtil;
import cn.hd.utils.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service("contractService")
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
        //初始化合同节点信息
        initSaveContract(record);
        //更新节点金额信息
        treeContractUtil.updateTreeWithInitContract(record);
        //保存合同节点信息
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
        Contract vo = updateContract(record);
        return contractMapper.updateByPrimaryKey(vo);
    }

    @Override
    public PageInfo<Contract> query(BaseConditionVO vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<Contract> list = contractMapper.query(vo);
        PageInfo<Contract> pageInfo = new PageInfo<Contract>(list);
        return pageInfo;
    }

    //初始化合同节点信息
    public void initSaveContract(Contract record) {
        if (StringUtil.isNull(record.getId())) {
            record.setId(UUIDUtil.getId());
        }
        if (StringUtil.isNull(record.getBeginDate())) {
            record.setBeginDate(DateUtil.getCurrentDate());
            record.setBeginDateFormat(MyDateUtil.dateFormate_YYYY_MM_DD(record.getBeginDate()));
        }
        if (StringUtil.isNull(record.getEndData())) {
            record.setEndData(new Date(record.getBeginDate().getTime() + 365 * 24 * 60 * 60 * 1000L));
            record.setEndDateFormat(MyDateUtil.dateFormate_YYYY_MM_DD(record.getEndData()));
        }
        if (StringUtil.isNull(record.getCrtTime())) {
            record.setCrtTime(DateUtil.getCurrentDateTime());
            record.setCrtTimeFormat(MyDateUtil.dateFormate_YYYY_MM_DD_HH_mm_ss(record.getCrtTime()));
        }
        if (StringUtil.isNull(record.getVerNo())) {
            record.setVerNo(1);
        }
    }

    //更新合同节点信息
    public Contract updateContract(Contract record) {
        treeContractUtil.updateTreeWithUpdateContract(record);
        Contract contract = contractMapper.selectByPrimaryKey(record.getId());
        contract.setUpdTime(DateUtil.getCurrentDateTime());
        contract.setUpdTimeFormat(MyDateUtil.dateFormate_YYYY_MM_DD_HH_mm_ss(contract.getUpdTime()));
        contract.setVerNo(StringUtil.isNull(contract.getVerNo()) ? 1 : contract.getVerNo() + 1);
        contract.setContAmt(record.getContAmt());
        contract.setTreeNo(record.getTreeNo());
        contract.setRemark(record.getRemark());
        if (!StringUtil.isEquals(contract.getBeginDateFormat(), record.getBeginDateFormat(), false)) {
            contract.setBeginDateFormat(record.getBeginDateFormat());
            try {
                contract.setBeginDate(MyDateUtil.parseDateFrom_YYYY_MM_DD(contract.getBeginDateFormat()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (!StringUtil.isEquals(contract.getEndDateFormat(), record.getEndDateFormat(), false)) {
            contract.setEndDateFormat(record.getEndDateFormat());
            try {
                contract.setEndData(MyDateUtil.parseDateFrom_YYYY_MM_DD(contract.getEndDateFormat()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return contract;
    }


    @Resource
    TreeContractUtil treeContractUtil;
}
