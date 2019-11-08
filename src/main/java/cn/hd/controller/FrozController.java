package cn.hd.controller;

import cn.hd.enums.FrozStat;
import cn.hd.model.Tree;
import cn.hd.service.ITreeService;
import cn.hd.utils.CommonServiceUtil;
import cn.hd.utils.DateUtil;
import cn.hd.utils.MyDateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/froz")
public class FrozController {
    @Resource
    ITreeService treeService;
    @Resource
    CommonServiceUtil commonServiceUtil;
    @RequestMapping("/frozPage/{frozTreeNo}")
    public String updatePage(@PathVariable String frozTreeNo, Model model, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        Tree tree = treeService.selectByTreeNo(frozTreeNo);
        treeService.frozTree(tree);
        model.addAttribute("tree", tree);
        return "redirect:/tree/query";
    }


    @RequestMapping("/tthawPage/{frozTreeNo}")
    public String tthawPage(@PathVariable String frozTreeNo, Model model, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        Tree tree = treeService.selectByTreeNo(frozTreeNo);
        treeService.tthawTree(tree);
        model.addAttribute("tree", tree);
        return "redirect:/tree/query";
    }
}
