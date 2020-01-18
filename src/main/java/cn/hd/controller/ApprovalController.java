package cn.hd.controller;

import cn.hd.enums.ClBCrCrdtApprCrdtType;
import cn.hd.enums.CreditStatus;
import cn.hd.enums.FrozStat;
import cn.hd.enums.IsIf;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/approval")
public class ApprovalController {

    @Resource
    IApprovalService approvalService;
    @Resource
    CommonServiceUtil commonServiceUtil;

    @RequestMapping("/query")
    public String query(BaseConditionVO vo, Model model, HttpSession session) {

        PageInfo<Approval> pageInfo = approvalService.query(vo);
        model.addAttribute("pageModel", pageInfo);
        model.addAttribute("vo", vo);
        model.addAttribute("ClBCrCrdtApprCrdtType", ClBCrCrdtApprCrdtType.values());//额度类型
        model.addAttribute("CreditStatus", CreditStatus.values());//额度状态
        model.addAttribute("FrozStat", FrozStat.values());//冻结状态
        model.addAttribute("IsIf", IsIf.values());//是、否
        return "approval/approvallist";
    }

    @RequestMapping("/save")
    public String save(Approval approval, HttpSession session) {

        if (StringUtil.isNotNull(approval.getId())) {
            approvalService.updateByPrimaryKey(approval);
        } else {
            approvalService.insert(approval);
        }
        return "redirect:/approval/query";

    }

    @RequestMapping("/updatePage/{id}")
    public String updatePage(@PathVariable String id, Model model, HttpSession session) {

        Approval approval = approvalService.selectByPrimaryKey(id);
        model.addAttribute("approval", approval);
        model.addAttribute("ClBCrCrdtApprCrdtType", ClBCrCrdtApprCrdtType.values());
        model.addAttribute("CreditStatus", CreditStatus.values());
        return "approval/approval";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id, HttpSession session) {

        approvalService.deleteByPrimaryKey(id);

        return "redirect:/approval/query";
    }

    @RequestMapping("/init")
    public String init(Approval approval, HttpSession session, Map<String, Object> map) {

        map.put("approval", approval);
        map.put("ClBCrCrdtApprCrdtType", ClBCrCrdtApprCrdtType.values());
        map.put("CreditStatus", CreditStatus.values());
        return "approval/approval";
    }

}
