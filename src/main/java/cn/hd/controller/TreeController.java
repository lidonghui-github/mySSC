package cn.hd.controller;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Data;
import cn.hd.model.Tree;
import cn.hd.service.ITreeService;
import cn.hd.utils.StringUtil;
import cn.hd.utils.UUIDUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/tree")
public class TreeController {
    @Resource
    ITreeService treeService;

    @RequestMapping("/init")
    public String init() {
        return "tree/tree";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        treeService.deleteByPrimaryKey(id);
        return "redirect:/tree/query";
    }

    @RequestMapping("/updatePage/{id}")
    public String updatePage(@PathVariable String id, Model model) {
        Tree tree = treeService.selectByPrimaryKey(id);
        model.addAttribute("tree", tree);
        return "tree/tree";
    }

    @RequestMapping("/query")
    public String query(BaseConditionVO vo, Model model) {
        PageInfo<Tree> pageInfo = treeService.query(vo);
        model.addAttribute("pageModel", pageInfo);
        model.addAttribute("vo", vo);
        return "tree/treelist";
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
        return "redirect:/tree/query";

    }
}
