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
import cn.hd.model.Dept;
import cn.hd.service.IDeptService;

import cn.hd.utils.StringUtil;
import cn.hd.utils.UUIDUtil;

@Controller
@RequestMapping("/dept")
public class DeptController {

	@Resource
	IDeptService deptService;
	@Resource
	CommonServiceUtil commonServiceUtil;
	@RequestMapping("/query")
	public String query(BaseConditionVO vo, Model model, HttpSession session) {
		if (!commonServiceUtil.checkSession(session)) {
			return "redirect:/login.jsp";
		}
		PageInfo<Dept> pageInfo = deptService.query(vo);
		model.addAttribute("pageModel", pageInfo);
		model.addAttribute("vo", vo);
		return "dept/deptlist";
	}

	@RequestMapping("/save")
	public String save(Dept dept, HttpSession session) {
		if (!commonServiceUtil.checkSession(session)) {
			return "redirect:/login.jsp";
		}
		if (StringUtil.isNotNull(dept.getDeptId())) {
			int k = deptService.updateByPrimaryKey(dept);
			System.out.println("**********" + k + "@@@@@@@@@@@@@@@");
		} else {
			Dept u = new Dept();
			u.setDeptId(UUIDUtil.getNumId().substring(0, 18));
			u.setDeptName(dept.getDeptName());

			u.setRemark(dept.getRemark());
			deptService.insert(u);
		}
		return "redirect:/dept/query";

	}

	@RequestMapping("/updatePage/{id}")
	public String updatePage(@PathVariable String id, Model model, HttpSession session) {
		if (!commonServiceUtil.checkSession(session)) {
			return "redirect:/login.jsp";
		}
		Dept dept = deptService.selectByPrimaryKey(id);
		model.addAttribute("dept", dept);
		return "dept/dept";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id, HttpSession session) {
		if (!commonServiceUtil.checkSession(session)) {
			return "redirect:/login.jsp";
		}
		deptService.deleteByPrimaryKey(id);

		return "redirect:/dept/query";
	}

	@RequestMapping("/init")
	public String init(HttpSession session) {
		if (!commonServiceUtil.checkSession(session)) {
			return "redirect:/login.jsp";
		}
		return "dept/dept";
	}

}
