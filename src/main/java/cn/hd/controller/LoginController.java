package cn.hd.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.LoginLog;
import cn.hd.service.ILoginLogService;
import cn.hd.utils.DateUtil;
import cn.hd.utils.UUIDUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.hd.model.Userbean;
import cn.hd.service.IUserService;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/login")
    public String login(String name, String password, HttpServletRequest request, HttpSession session) {
        List<Userbean> users = userService.findUserByName(name);

        boolean flag = false;
        if (users != null) {
            for (Userbean u : users) {
                if (u.getPassword().equals(password)) {
                    System.out.println("登录成功！");
                    System.out.println(u.toString());
                    insertLoginLog(u, request, session);
                    flag = true;
                    session.setAttribute("username", u.getUsername());
                    break;
                }
            }
        }
        if (!flag) {
            System.out.println("登录失败！");
            return "redirect:/login.jsp";
        } else {
            return "redirect:/index.jsp";
        }

    }

    //记录登录信息
    public void insertLoginLog(Userbean u, HttpServletRequest request, HttpSession session) {
        if (session.getAttribute("username") != null && u.getUsername().equals(session.getAttribute("username").toString())) {
            return;
        }
        LoginLog loginLog = new LoginLog();
        loginLog.setId(UUIDUtil.getId());
        loginLog.setLoginTime(DateUtil.getCurrentDateTime());
        loginLog.setUserName(u.getUsername());
        loginLog.initLoginTimeFormat();
        loginLog.setLoginIp(request.getLocalAddr());
        loginLogService.insert(loginLog);
        session.setAttribute("username", u.getUsername());
    }

    @RequestMapping("/query")
    public String query(BaseConditionVO vo, Model model) {
        PageInfo<LoginLog> pageInfo = loginLogService.query(vo);
        model.addAttribute("pageModel", pageInfo);
        model.addAttribute("vo", vo);
        return "login/loginlist";
    }


    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        loginLogService.deleteByPrimaryKey(id);
        return "redirect:/login/query";
    }


    @Resource
    IUserService userService;

    @Resource
    ILoginLogService loginLogService;
}
