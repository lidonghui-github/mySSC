package cn.hd.controller;

import cn.hd.model.BaseConditionVO;


import cn.hd.model.Tree;
import cn.hd.model.TreeRela;
import cn.hd.service.ITreeRelaService;
import cn.hd.service.ITreeService;
import cn.hd.utils.StringUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/treerela")
public class TreeRelaController {
    @Resource
    ITreeRelaService treeRelaService;

    @Resource
    ITreeService treeService;

    @RequestMapping("/init")
    public String init(HttpSession session) {
        //先初始化缓存信息
        initSessionError(session);
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
    public String save(TreeRela treeRela, HttpSession session) {
        //1.非空检查
        checkNull(treeRela,session);
        if(StringUtil.isNotNull(session.getAttribute("error").toString())){
            return "treerela/treerela";
        }
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
    //非空检查、存在性检查
    public void checkNull(TreeRela treeRela,HttpSession session) {
        //1.先刷新session缓存
        initSessionError(session);
        if (StringUtil.isNull(treeRela.getBigTreeNo())) {
            session.setAttribute("error","纳入额度编号为空...");
            return;

        }
        if (StringUtil.isNull(treeRela.getSmallTreeNo())) {
            session.setAttribute("error","被纳入额度编号为空...");
            return;

        }
        if (StringUtil.isNull(treeRela.getRelaType())) {
            session.setAttribute("error","关系类型为空...");
            return;

        }
        if (StringUtil.isNull(treeRela.getValidFlag())) {
            session.setAttribute("error","关系是否有效为空...");
            return;
        }
        Tree bigTree = treeService.selectByTreeNo(treeRela.getBigTreeNo());
        if (null == bigTree) {
            session.setAttribute("error","纳入额度编号不存在...");
            return;
        }
        Tree smallTree = treeService.selectByTreeNo(treeRela.getSmallTreeNo());
        if(null == smallTree){
            session.setAttribute("error","被纳入额度编号不存在...");
            return;
        }
    }

    public void  initSessionError(HttpSession session){
        session.setAttribute("error","");
    }
}
