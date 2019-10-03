package cn.hd.buss;

import cn.hd.mapper.ContractMapper;
import cn.hd.mapper.TreeMapper;
import cn.hd.model.Contract;
import cn.hd.model.Tree;
import cn.hd.utils.BigDecimalUtil;
import cn.hd.utils.DateUtil;
import cn.hd.utils.MyDateUtil;
import cn.hd.utils.StringUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TreeContractUtil {
    @Resource
    TreeMapper treeMapper;

    @Resource
    ContractMapper contractMapper;

    //合同节点信息初始化时，更新节点信息
    public Tree updateTreeWithInitContract(Contract contract) {
        Tree tree = treeMapper.selectByTreeNo(contract.getTreeNo());
        if (tree == null) {
            return null;
        }
        tree.setUsedAmt(BigDecimalUtil.add(tree.getApprAmt(), contract.getContAmt()));
        tree.setEnabAmt(BigDecimalUtil.subtract1(tree.getEnabAmt(), contract.getContAmt()));
        tree.setUpdTime(DateUtil.getCurrentDateTime());
        tree.setUpdTimeFormat(MyDateUtil.dateFormate_YYYY_MM_DD_HH_mm_ss(tree.getUpdTime()));
        tree.setVerNo(StringUtil.isNull(tree.getVerNo()) ? 1 : tree.getVerNo() + 1);
        tree.setRemark("合同"+contract.getContNo()+"发生占用");
        treeMapper.updateByPrimaryKeySelective(tree);
        return tree;
    }

    //合同节点信息更新时，更新节点信息
    public Tree updateTreeWithUpdateContract(Contract contract) {
        Tree tree = treeMapper.selectByTreeNo(contract.getTreeNo());
        if (tree == null) {
            return null;
        }
        //1.查出之前的合同节点信息
        Contract beforeContract = contractMapper.selectByPrimaryKey(contract.getId());
        //2.先把之前占用的钱还回去
        tree.setUsedAmt(BigDecimalUtil.subtract1(tree.getUsedAmt(),beforeContract.getContAmt()));
        tree.setEnabAmt(BigDecimalUtil.add(tree.getEnabAmt(),beforeContract.getContAmt()));
        //3.再把合同节点更新后的钱重新占用上
        tree.setUsedAmt(BigDecimalUtil.add(tree.getUsedAmt(),contract.getContAmt()));
        tree.setEnabAmt(BigDecimalUtil.subtract1(tree.getEnabAmt(),contract.getContAmt()));
        //4.更新时间等信息
        tree.setUpdTime(DateUtil.getCurrentDateTime());
        tree.setUpdTimeFormat(MyDateUtil.dateFormate_YYYY_MM_DD_HH_mm_ss(tree.getUpdTime()));
        tree.setVerNo(StringUtil.isNull(tree.getVerNo()) ? 1 : tree.getVerNo() + 1);
        tree.setRemark("合同:"+contract.getContNo()+"发生信息变更");
        treeMapper.updateByPrimaryKeySelective(tree);
        return tree;
    }
}
