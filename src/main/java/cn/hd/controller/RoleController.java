package cn.hd.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import cn.hd.utils.CommonServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Role;
import cn.hd.service.IRoleService;
import cn.hd.utils.StringUtil;
import cn.hd.utils.UUIDUtil;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Resource
    IRoleService roleService;
    @Resource
    CommonServiceUtil commonServiceUtil;
    @RequestMapping("/query")
    public String query(BaseConditionVO vo, Model model, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        PageInfo<Role> pageInfo = roleService.query(vo);
        model.addAttribute("pageModel", pageInfo);
        model.addAttribute("vo", vo);
        return "role/rolelist";
    }

    @RequestMapping("/save")
    public String save(Role role, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        if (StringUtil.isNotNull(role.getRoleId())) {
            int k = roleService.updateByPrimaryKey(role);
            System.out.println("**********" + k + "@@@@@@@@@@@@@@@");
        } else {
            Role u = new Role();
            u.setRoleId(UUIDUtil.getNumId().substring(0, 18));
            u.setRoleName(role.getRoleName());

            u.setRemark(role.getRemark());
            roleService.insert(u);
        }
        return "redirect:/role/query";

    }

    @RequestMapping("/updatePage/{id}")
    public String updatePage(@PathVariable String id, Model model, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        Role role = roleService.selectByPrimaryKey(id);
        model.addAttribute("role", role);
        return "role/role";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        roleService.deleteByPrimaryKey(id);

        return "redirect:/role/query";
    }

    @RequestMapping("/init")
    public String init(HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        return "role/role";
    }

}
