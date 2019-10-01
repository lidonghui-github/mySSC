package cn.hd.controller;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Contract;
import cn.hd.service.IContractService;
import cn.hd.utils.StringUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@Controller
@RequestMapping("/contract")
public class ContractController {
    @Resource
    IContractService contractService;

    @RequestMapping("/init")
    public String init() {
        return "contract/contract";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        contractService.deleteByPrimaryKey(id);
        return "redirect:/contract/query";
    }

    @RequestMapping("/updatePage/{id}")
    public String updatePage(@PathVariable String id, Model model) {
        Contract contract = contractService.selectByPrimaryKey(id);
        model.addAttribute("contract", contract);
        return "contract/contract";
    }

    @RequestMapping("/query")
    public String query(BaseConditionVO vo, Model model) {
        PageInfo<Contract> pageInfo = contractService.query(vo);
        model.addAttribute("pageModel", pageInfo);
        model.addAttribute("vo", vo);
        return "contract/contractlist";
    }

    @RequestMapping("/save")
    public String save(Contract contract) {
        int k;
        if (StringUtil.isNotNull(contract.getId())) {
            k = contractService.updateByPrimaryKey(contract);
            System.out.println("**********" + k + "@@@@@@@@@@@@@@@");
        } else {
            k = contractService.insert(contract);
            System.out.println("**********" + k + "@@@@@@@@@@@@@@@");
        }
        return "redirect:/contract/query";

    }
}
