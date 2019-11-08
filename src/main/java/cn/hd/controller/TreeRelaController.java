package cn.hd.controller;
import cn.hd.model.BaseConditionVO;


import cn.hd.model.Tree;
import cn.hd.model.TreeRela;
import cn.hd.service.ITreeRelaService;
import cn.hd.service.ITreeService;
import cn.hd.utils.CommonServiceUtil;
import cn.hd.utils.StringUtil;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/treerela")
public class TreeRelaController {

    protected static final Logger logger = LoggerFactory.getLogger(TreeRelaController.class);
    @Resource
    ITreeRelaService treeRelaService;
    @Resource
    CommonServiceUtil commonServiceUtil;
    @Resource
    ITreeService treeService;

    @RequestMapping("/init")
    public String init(HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        //先初始化缓存信息
        initSessionError(session);
        return "treerela/treerela";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        treeRelaService.deleteByPrimaryKey(id);
        return "redirect:/treerela/query";
    }

    @RequestMapping("/updatePage/{id}")
    public String updatePage(@PathVariable String id, Model model, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        TreeRela treeRela = treeRelaService.selectByPrimaryKey(id);
        model.addAttribute("treerela", treeRela);
        return "treerela/treerela";
    }

    @RequestMapping("/query")
    public String query(BaseConditionVO vo, Model model, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        PageInfo<TreeRela> pageInfo = treeRelaService.query(vo);
        model.addAttribute("pageModel", pageInfo);
        model.addAttribute("vo", vo);
        return "treerela/treerelalist";
    }

    @RequestMapping("/naruquery")
    public String naruquery(BaseConditionVO vo, Model model, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        PageInfo<TreeRela> pageInfo = treeRelaService.naruquery(vo);
        model.addAttribute("pageModel", pageInfo);
        model.addAttribute("vo", vo);
        return "treerela/narulist";
    }

    @RequestMapping("/replacequery")
    public String replacequery(BaseConditionVO vo, Model model, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        PageInfo<TreeRela> pageInfo = treeRelaService.replacequery(vo);
        model.addAttribute("pageModel", pageInfo);
        model.addAttribute("vo", vo);
        return "treerela/replacelist";
    }

    @RequestMapping("/glquery")
    public String glquery(BaseConditionVO vo, Model model, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        PageInfo<TreeRela> pageInfo = treeRelaService.glquery(vo);
        model.addAttribute("pageModel", pageInfo);
        model.addAttribute("vo", vo);
        return "treerela/gllist";
    }

    @RequestMapping("/save")
    public String save(TreeRela treeRela, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        initSessionError(session);
        //1.非空检查
        checkNull(treeRela, session);
        if (StringUtil.isNotNull(session.getAttribute("error").toString())) {
            return "treerela/treerela";
        }
        checkExistTreeRela(treeRela, session);
        if (session.getAttribute("samerela") !=null && (boolean) session.getAttribute("samerela")) {
            //啥也不做
        } else {
            if (StringUtil.isNotNull(treeRela.getId())) {
                treeRelaService.updateByPrimaryKey(treeRela);
            } else {
                treeRelaService.insert(treeRela);
            }

        }
        return "redirect:/treerela/query";
    }

    //非空检查、存在性检查
    public void checkNull(TreeRela treeRela, HttpSession session) {
        //1.先刷新session缓存

        if (StringUtil.isNull(treeRela.getBigTreeNo())) {
            session.setAttribute("error", "纳入额度编号为空...");
            return;

        }
        if (StringUtil.isNull(treeRela.getSmallTreeNo())) {
            session.setAttribute("error", "被纳入额度编号为空...");
            return;

        }
        if (StringUtil.isNull(treeRela.getRelaType())) {
            session.setAttribute("error", "关系类型为空...");
            return;

        }
        if (StringUtil.isNull(treeRela.getValidFlag())) {
            session.setAttribute("error", "关系是否有效为空...");
            return;
        }
        Tree bigTree = treeService.selectByTreeNo(treeRela.getBigTreeNo());
        if (null == bigTree) {
            session.setAttribute("error", "纳入额度编号不存在...");
            return;
        }
        Tree smallTree = treeService.selectByTreeNo(treeRela.getSmallTreeNo());
        if (null == smallTree) {
            session.setAttribute("error", "被纳入额度编号不存在...");
            return;
        }
    }

    //初始化session错误信息缓存
    public void initSessionError(HttpSession session) {
        session.setAttribute("error", "");
    }

    //检查关系是否存在
    public void checkExistTreeRela(TreeRela treeRela, HttpSession session) {
        List<TreeRela> dbTreeRelas = treeRelaService.findTreeRelaByBigAndSmallTreeNo(treeRela.getBigTreeNo(), treeRela.getSmallTreeNo());
        if (null == dbTreeRelas) {
            return;
        }
        if (dbTreeRelas.size() == 1) {
            TreeRela dbTreeRela = dbTreeRelas.get(0);
            if (StringUtil.isEquals(dbTreeRela.getRelaType(), treeRela.getRelaType(), false) && StringUtil.isEquals(dbTreeRela.getValidFlag(), treeRela.getValidFlag(), false)) {
                session.setAttribute("samerela", true);//关系一致不必再更新
                logger.error("关系一致不必再更新。。。。。。。");
            }
            if (!StringUtil.isEquals(dbTreeRela.getRelaType(), treeRela.getRelaType(), false) || !StringUtil.isEquals(dbTreeRela.getValidFlag(), treeRela.getValidFlag(), false)) {
                session.setAttribute("samerela", false);//关系不一致需要更新
                logger.error("关系不一致需要更新。。。。。。。");
            }
        }
    }
}
