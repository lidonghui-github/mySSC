package cn.hd.controller;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.ContractInfo;

import cn.hd.service.IContractInfoService;

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
@RequestMapping("/contractinfo")
public class ContractInfoController {
    @Resource
    IContractInfoService contractInfoService;
    @Resource
    CommonServiceUtil commonServiceUtil;
    @RequestMapping("/init")
    public String init(HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        return "contractinfo/contractinfo";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        contractInfoService.deleteByPrimaryKey(id);
        return "redirect:/contractinfo/query";
    }

    @RequestMapping("/updatePage/{id}")
    public String updatePage(@PathVariable String id, Model model, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        ContractInfo contractInfo = contractInfoService.selectByPrimaryKey(id);
        model.addAttribute("contractinfo", contractInfo);
        return "contractinfo/contractinfo";
    }

    @RequestMapping("/query")
    public String query(BaseConditionVO vo, Model model, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        PageInfo<ContractInfo> pageInfo = contractInfoService.query(vo);
        model.addAttribute("pageModel", pageInfo);
        model.addAttribute("vo", vo);
        return "contractinfo/contractinfolist";
    }

    @RequestMapping("/save")
    public String save(ContractInfo contractInfo, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
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
