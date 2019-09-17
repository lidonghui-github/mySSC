package cn.hd.controller;


import java.util.List;

import javax.annotation.Resource;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hd.model.Userbean;
import cn.hd.service.IUserService;




@Controller
@RequestMapping("/login")
public class LoginController {
	@RequestMapping("/login")
	public String login(String name,String password) {
		 List<Userbean> users = userService.findUserByName(name);
		 boolean flag = false;
		 if(users != null){
			for(Userbean u : users){
				if(u.getPassword().equals(password)){
					System.out.println("登录成功！");
					System.out.println(u.toString());
					flag = true;					
					break;
				}
			}
		 }
		 if(!flag){
			 System.out.println("登录失败！");
			 return "redirect:/login.jsp";
		 }else{
			 return "redirect:/index.jsp";
		 }
				
	

	}
	
	
	@Resource
	IUserService userService;
}
