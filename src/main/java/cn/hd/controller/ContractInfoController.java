package cn.hd.controller;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.ContractInfo;

import cn.hd.service.IContractInfoService;

import cn.hd.utils.StringUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@Controller
@RequestMapping("/contractinfo")
public class ContractInfoController {
    @Resource
    IContractInfoService contractInfoService;

    @RequestMapping("/init")
    public String init() {
        return "contractinfo/contractinfo";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        contractInfoService.deleteByPrimaryKey(id);
        return "redirect:/contractinfo/query";
    }

    @RequestMapping("/updatePage/{id}")
    public String updatePage(@PathVariable String id, Model model) {
        ContractInfo contractInfo = contractInfoService.selectByPrimaryKey(id);
        model.addAttribute("contractinfo", contractInfo);
        return "contractinfo/contractinfo";
    }

    @RequestMapping("/query")
    public String query(BaseConditionVO vo, Model model) {
        PageInfo<ContractInfo> pageInfo = contractInfoService.query(vo);
        model.addAttribute("pageModel", pageInfo);
        model.addAttribute("vo", vo);
        return "contractinfo/contractinfolist";
    }

    @RequestMapping("/save")
    public String save(ContractInfo contractInfo) {
        int k;
        if (StringUtil.isNotNull(contractInfo.getId())) {
            k = contractInfoService.updateByPrimaryKey(contractInfo);
            System.out.println("**********" + k + "@@@@@@@@@@@@@@@");
        } else {
            k = contractInfoService.insert(contractInfo);
            System.out.println("**********" + k + "@@@@@@@@@@@@@@@");
        }
        return "redirect:/contractinfo/query";
    }
}
