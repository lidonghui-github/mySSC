package cn.hd.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import cn.hd.utils.CommonServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.pagehelper.PageInfo;
import cn.hd.model.BaseConditionVO;
import cn.hd.model.Menu;
import cn.hd.service.IMenuService;
import cn.hd.utils.StringUtil;
import cn.hd.utils.UUIDUtil;

@Controller
@RequestMapping("/menu")
public class MenuController {
    protected static final Logger logger = LoggerFactory.getLogger(MenuController.class);
    @Resource
    IMenuService menuService;


    @Resource
    CommonServiceUtil commonServiceUtil;

    @RequestMapping("/query")
    public String query(BaseConditionVO vo, Model model, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        PageInfo<Menu> pageInfo = menuService.query(vo);
        model.addAttribute("pageModel", pageInfo);
        model.addAttribute("vo", vo);
        return "menu/menulist";
    }

    @RequestMapping("/save")
    public String save(Menu menu, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        if (StringUtil.isNotNull(menu.getMenuId())) {
            int k = menuService.updateByPrimaryKey(menu);
            System.out.println("**********" + k + "@@@@@@@@@@@@@@@");
        } else {
            Menu u = new Menu();
            u.setMenuId(UUIDUtil.getNumId().substring(0, 18));
            u.setMenuName(menu.getMenuName());

            u.setRemark(menu.getRemark());
            menuService.insert(u);
        }
        return "redirect:/menu/query";

    }

    @RequestMapping("/updatePage/{id}")
    public String updatePage(@PathVariable String id, Model model, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        Menu menu = menuService.selectByPrimaryKey(id);
        model.addAttribute("menu", menu);
        return "menu/menu";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        menuService.deleteByPrimaryKey(id);

        return "redirect:/menu/query";
    }

    @RequestMapping("/init")
    public String init(HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        return "menu/menu";
    }


}
