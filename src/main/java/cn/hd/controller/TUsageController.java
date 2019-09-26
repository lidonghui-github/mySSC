package cn.hd.controller;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Tree;
import cn.hd.service.ITreeService;
import cn.hd.utils.StringUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/usage")
public class TUsageController {
    @Resource
    ITreeService treeService;
    @RequestMapping("/query")
    public String query(BaseConditionVO vo, Model model) {
        PageInfo<Tree> pageInfo = treeService.query(vo);
        model.addAttribute("pageModel", pageInfo);
        model.addAttribute("vo", vo);
        return "tusage/usageTreelist";
    }
    @RequestMapping("/init")
    public String init() {
        return "tusage/usageTree";
    }



    @RequestMapping("/save")
    public String save(Tree tree) {
        int k;
        if (StringUtil.isNotNull(tree.getId())) {
            k = treeService.updateByPrimaryKey(tree);
        } else {
            k = treeService.insert(tree);
        }
        System.out.println("**********" + k + "@@@@@@@@@@@@@@@");
        return "redirect:/usage/query";

    }



    @RequestMapping("/usagePage/{treeNo}")
    public String usagePage(@PathVariable String treeNo, Model model) {
        Tree tree = treeService.selectByTreeNo(treeNo);
        treeService.usageTree(tree);
        model.addAttribute("tree", tree);
        return "redirect:/usage/query";
    }


    @RequestMapping("/recovePage/{treeNo}")
    public String recovePage(@PathVariable String treeNo, Model model) {
        Tree tree = treeService.selectByTreeNo(treeNo);
        treeService.recoveTree(tree);
        model.addAttribute("tree", tree);
        return "redirect:/usage/query";
    }
}
