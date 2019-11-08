package cn.hd.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import cn.hd.utils.CommonServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Driver;
import cn.hd.service.IDriverService;
import cn.hd.utils.DateUtil;
import cn.hd.utils.StringUtil;
import cn.hd.utils.UUIDUtil;

@Controller
@RequestMapping("/driver")
public class DriverController {

    @Resource
    IDriverService driverService;
    @Resource
    CommonServiceUtil commonServiceUtil;
    @RequestMapping("/query")
    public String query(BaseConditionVO vo, Model model, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        PageInfo<Driver> pageInfo = driverService.query(vo);
        model.addAttribute("pageModel", pageInfo);
        model.addAttribute("vo", vo);
        return "driver/driverlist";
    }

    @RequestMapping("/save")
    public String save(Driver driver, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        if (StringUtil.isNotNull(driver.getDriverId())) {
            driver.setDriverCrtTime(DateUtil.getCurrentDateTime());
            int k = driverService.updateByPrimaryKey(driver);
            System.out.println("**********" + k + "@@@@@@@@@@@@@@@");
        } else {
            Driver u = new Driver();
            u.setDriverId(UUIDUtil.getNumId().substring(0, 18));
            u.setDriverName(driver.getDriverName());
            u.setDriverSex(driver.getDriverSex());
            u.setDriverAddress(driver.getDriverAddress());
            u.setCancellationTime(driver.getCancellationTime());
            u.setDriverCrtTime(DateUtil.getCurrentDateTime());
            u.setDriverIdcardNumber(driver.getDriverIdcardNumber());
            u.setDriverTelNumber(driver.getDriverTelNumber());
            u.setDriverCurrentOrderNumber(driver.getDriverCurrentOrderNumber());
            u.setDriverFinisedOrderSum(driver.getDriverFinisedOrderSum());
            u.setRemark(driver.getRemark());


            driverService.insert(u);
        }
        return "redirect:/driver/query";

    }

    @RequestMapping("/updatePage/{id}")
    public String updatePage(@PathVariable String id, Model model, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        Driver driver = driverService.selectByPrimaryKey(id);
        model.addAttribute("driver", driver);
        return "driver/driver";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id, HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        driverService.deleteByPrimaryKey(id);

        return "redirect:/driver/query";
    }

    @RequestMapping("/init")
    public String init(HttpSession session) {
        if (!commonServiceUtil.checkSession(session)) {
            return "redirect:/login.jsp";
        }
        return "driver/driver";
    }

}
