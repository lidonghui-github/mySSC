package cn.hd.controller;

import cn.hd.model.BaseConditionVO;


import cn.hd.model.TreeRela;
import cn.hd.service.ITreeRelaService;
import cn.hd.utils.StringUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@Controller
@RequestMapping("/treerela")
public class TreeRelaController {
   @Resource
    ITreeRelaService treeRelaService;

    @RequestMapping("/init")
    public String init() {
        return "treerela/treerela";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        treeRelaService.deleteByPrimaryKey(id);
        return "redirect:/treerela/query";
    }

    @RequestMapping("/updatePage/{id}")
    public String updatePage(@PathVariable String id, Model model) {
        TreeRela treeRela = treeRelaService.selectByPrimaryKey(id);
        model.addAttribute("treerela", treeRela);
        return "treerela/treerela";
    }

    @RequestMapping("/query")
    public String query(BaseConditionVO vo, Model model) {
        PageInfo<TreeRela> pageInfo = treeRelaService.query(vo);
        model.addAttribute("pageModel", pageInfo);
        model.addAttribute("vo", vo);
        return "treerela/treerelalist";
    }
    @RequestMapping("/naruquery")
    public String naruquery(BaseConditionVO vo, Model model) {
        PageInfo<TreeRela> pageInfo = treeRelaService.naruquery(vo);
        model.addAttribute("pageModel", pageInfo);
        model.addAttribute("vo", vo);
        return "treerela/narulist";
    }
    @RequestMapping("/replacequery")
    public String replacequery(BaseConditionVO vo, Model model) {
        PageInfo<TreeRela> pageInfo = treeRelaService.replacequery(vo);
        model.addAttribute("pageModel", pageInfo);
        model.addAttribute("vo", vo);
        return "treerela/replacelist";
    }
    @RequestMapping("/glquery")
    public String glquery(BaseConditionVO vo, Model model) {
        PageInfo<TreeRela> pageInfo = treeRelaService.glquery(vo);
        model.addAttribute("pageModel", pageInfo);
        model.addAttribute("vo", vo);
        return "treerela/gllist";
    }

    @RequestMapping("/save")
    public String save(TreeRela treeRela) {
        int k;
        if (StringUtil.isNotNull(treeRela.getId())) {
            k = treeRelaService.updateByPrimaryKey(treeRela);
            System.out.println("**********" + k + "@@@@@@@@@@@@@@@");
        } else {
            k = treeRelaService.insert(treeRela);
            System.out.println("**********" + k + "@@@@@@@@@@@@@@@");
        }
        return "redirect:/treerela/query";
    }
}
