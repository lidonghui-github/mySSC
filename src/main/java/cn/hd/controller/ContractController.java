package cn.hd.controller;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Contract;
import cn.hd.service.IContractService;
import cn.hd.utils.CommonServiceUtil;
import cn.hd.utils.StringUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/contract")
public class ContractController {
    @Resource
    IContractService contractService;
    @Resource
    CommonServiceUtil commonServiceUtil;
    @RequestMapping("/init")
    public String init(HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        return "contract/contract";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        contractService.deleteByPrimaryKey(id);
        return "redirect:/contract/query";
    }

    @RequestMapping("/updatePage/{id}")
    public String updatePage(@PathVariable String id, Model model, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        Contract contract = contractService.selectByPrimaryKey(id);
        model.addAttribute("contract", contract);
        return "contract/contract";
    }

    @RequestMapping("/query")
    public String query(BaseConditionVO vo, Model model, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        PageInfo<Contract> pageInfo = contractService.query(vo);
        model.addAttribute("pageModel", pageInfo);
        model.addAttribute("vo", vo);
        return "contract/contractlist";
    }

    @RequestMapping("/save")
    public String save(Contract contract, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
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
