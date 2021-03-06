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
import cn.hd.model.Order;
import cn.hd.service.IOrderService;
import cn.hd.utils.DateUtil;
import cn.hd.utils.StringUtil;
import cn.hd.utils.UUIDUtil;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Resource
	IOrderService orderService;
	@Resource
	CommonServiceUtil commonServiceUtil;
	@RequestMapping("/query")
	public String query(BaseConditionVO vo, Model model, HttpSession session) {
		if (!commonServiceUtil.checkSession(session)) {
			return "redirect:/login.jsp";
		}
		PageInfo<Order> pageInfo = orderService.query(vo);
		model.addAttribute("pageModel", pageInfo);
		model.addAttribute("vo", vo);
		return "order/orderlist";
	}

	@RequestMapping("/save")
	public String save(Order order, HttpSession session) {
		if (!commonServiceUtil.checkSession(session)) {
			return "redirect:/login.jsp";
		}
		if (StringUtil.isNotNull(order.getOrderNo())) {
			order.setOrderUpdTime(DateUtil.getCurrentDateTime());
			order.setOrderUpdUserNo(order.getOrderUpdUserNo());
			int k = orderService.updateByPrimaryKey(order);
			System.out.println("**********" + k + "@@@@@@@@@@@@@@@");
		} else {
			Order u = new Order();
		    u.setOrderNo(UUIDUtil.getId().substring(0,32));
		    u.setOrderCrtTime(DateUtil.getCurrentDateTime());
		    u.setOrderAppointmenTime(DateUtil.getCurrentDateTime());
		    u.setOrderOrigin(order.getOrderOrigin());
		    u.setOrderDestination(order.getOrderDestination());
			u.setRemark(order.getRemark());
			u.setOrderCrtUserNo(order.getOrderCrtUserNo());			
			u.setOrderCustomerNo(order.getOrderCustomerNo());
			u.setOrderStatus(order.getOrderStatus());
			u.setOrderOperateStatus(order.getOrderOperateStatus());
			u.setOrderDriverNo(order.getOrderDriverNo());

		
			orderService.insert(u);
		}
		return "redirect:/order/query";

	}

	@RequestMapping("/updatePage/{id}")
	public String updatePage(@PathVariable String id, Model model, HttpSession session) {
		if (!commonServiceUtil.checkSession(session)) {
			return "redirect:/login.jsp";
		}
		Order order = orderService.selectByPrimaryKey(id);
		model.addAttribute("order", order);
		return "order/order";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id, HttpSession session) {
		if (!commonServiceUtil.checkSession(session)) {
			return "redirect:/login.jsp";
		}
		orderService.deleteByPrimaryKey(id);

		return "redirect:/order/query";
	}

	@RequestMapping("/init")
	public String init(HttpSession session) {
		if (!commonServiceUtil.checkSession(session)) {
			return "redirect:/login.jsp";
		}
		return "order/order";
	}

}
