package cn.hd.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import cn.hd.mapper.LoginLogMapper;
import cn.hd.model.LoginLog;
import cn.hd.utils.DateUtil;
import cn.hd.utils.UUIDUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hd.model.Userbean;
import cn.hd.service.IUserService;


@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/login")
    public String login(String name, String password, HttpServletRequest request) {
        List<Userbean> users = userService.findUserByName(name);
        boolean flag = false;
        if (users != null) {
            for (Userbean u : users) {
                if (u.getPassword().equals(password)) {
                    System.out.println("登录成功！");
                    System.out.println(u.toString());
                    insertLoginLog(u,request);
                    flag = true;
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
    public void insertLoginLog(Userbean u, HttpServletRequest request) {
        LoginLog loginLog = new LoginLog();
        loginLog.setId(UUIDUtil.getId());
        loginLog.setLoginTime(DateUtil.getCurrentDateTime());
        loginLog.setUserName(u.getUsername());
        loginLog.setLoginIp(request.getLocalAddr());
        loginLog.initLoginTimeFormat();
        loginLogMapper.insert(loginLog);
    }

    @Resource
    IUserService userService;

    @Resource
    LoginLogMapper loginLogMapper;
}
