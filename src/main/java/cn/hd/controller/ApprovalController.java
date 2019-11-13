package cn.hd.controller;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Approval;
import cn.hd.service.IApprovalService;
import cn.hd.utils.CommonServiceUtil;
import cn.hd.utils.StringUtil;
import cn.hd.utils.UUIDUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/approval")
public class ApprovalController {

	@Resource
	IApprovalService approvalService;
	@Resource
	CommonServiceUtil commonServiceUtil;
	@RequestMapping("/query")
	public String query(BaseConditionVO vo, Model model, HttpSession session) {
		if (!commonServiceUtil.checkSession(session)) {
			return "redirect:/login.jsp";
		}
		PageInfo<Approval> pageInfo = approvalService.query(vo);
		model.addAttribute("pageModel", pageInfo);
		model.addAttribute("vo", vo);
		return "approval/approvallist";
	}

	@RequestMapping("/save")
	public String save(Approval approval, HttpSession session) {
		if (!commonServiceUtil.checkSession(session)) {
			return "redirect:/login.jsp";
		}
		if (StringUtil.isNotNull(approval.getId())) {
			int k = approvalService.updateByPrimaryKey(approval);
			System.out.println("**********" + k + "@@@@@@@@@@@@@@@");
		} else {
			Approval approval1 = new Approval();
			approval1.setId(UUIDUtil.getNumId().substring(0, 18));



			approvalService.insert(approval1);
		}
		return "redirect:/approval/query";

	}

	@RequestMapping("/updatePage/{id}")
	public String updatePage(@PathVariable String id, Model model, HttpSession session) {
		if (!commonServiceUtil.checkSession(session)) {
			return "redirect:/login.jsp";
		}
		Approval approval = approvalService.selectByPrimaryKey(id);
		model.addAttribute("approval", approval);
		return "approval/approval";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id, HttpSession session) {
		if (!commonServiceUtil.checkSession(session)) {
			return "redirect:/login.jsp";
		}
		approvalService.deleteByPrimaryKey(id);

		return "redirect:/approval/query";
	}

	@RequestMapping("/init")
	public String init(HttpSession session) {
		if (!commonServiceUtil.checkSession(session)) {
			return "redirect:/login.jsp";
		}
		return "approval/approval";
	}

}
