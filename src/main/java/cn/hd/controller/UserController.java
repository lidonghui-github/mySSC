package cn.hd.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Userbean;
import cn.hd.service.IUserService;
import cn.hd.utils.DateUtil;
import cn.hd.utils.StringUtil;
import cn.hd.utils.UUIDUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	IUserService userService;

	@RequestMapping("/query")
	public String query(BaseConditionVO vo, Model model, HttpSession session) {
		PageInfo<Userbean> pageInfo = userService.query(vo);
		model.addAttribute("pageModel", pageInfo);
		model.addAttribute("vo", vo);
		return "user/userlist";
	}

	@RequestMapping("/save")
	public String save(Userbean user, HttpSession session) {
		if (StringUtil.isNotNull(user.getUserid())) {
			int k = userService.updateByPrimaryKeySelective(user);
			System.out.println("**********" + k + "@@@@@@@@@@@@@@@");
		} else {
			Userbean u = new Userbean();
			u.setUserid(UUIDUtil.getNumId().substring(0, 18));
			u.setUsername(user.getUsername());
			u.setPassword(user.getPassword());
			u.setAge(user.getAge());
			u.setInsertdate(DateUtil.getCurrentDate());
			userService.insert(u);
		}
		return "redirect:/user/query";

	}

	@RequestMapping("/updatePage/{id}")
	public String updatePage(@PathVariable String id, Model model, HttpSession session) {
		Userbean user = userService.selectByPrimaryKey(id);
		model.addAttribute("user", user);
		return "user/user";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id, HttpSession session) {

		userService.deleteByPrimaryKey(id);

		return "redirect:/user/query";
	}

	@RequestMapping("/init")
	public String init() {
		return "user/user";
	}

}
