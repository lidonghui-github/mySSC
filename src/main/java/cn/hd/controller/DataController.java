package cn.hd.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Data;
import cn.hd.service.IDataService;
import cn.hd.utils.StringUtil;
import cn.hd.utils.UUIDUtil;

@Controller
@RequestMapping("/data")
public class DataController {

	@Resource
	IDataService dataService;

	@RequestMapping("/query")
	public String query(BaseConditionVO vo, Model model) {
		
		PageInfo<Data> pageInfo = dataService.query(vo);
		model.addAttribute("pageModel", pageInfo);
		model.addAttribute("vo", vo);
		return "data/datalist";
	}

	@RequestMapping("/save")
	public String save(Data data) {
		if (StringUtil.isNotNull(data.getDataId())) {
			int k = dataService.updateByPrimaryKey(data);
			System.out.println("**********" + k + "@@@@@@@@@@@@@@@");
		} else {
			Data u = new Data();
			u.setDataId(UUIDUtil.getNumId().substring(0, 18));
			u.setDataName(data.getDataName());

			u.setRemark(data.getRemark());
			dataService.insert(u);
		}
		return "redirect:/data/query";

	}

	@RequestMapping("/updatePage/{id}")
	public String updatePage(@PathVariable String id, Model model) {
		Data data = dataService.selectByPrimaryKey(id);
		model.addAttribute("data", data);
		return "data/data";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id) {

		dataService.deleteByPrimaryKey(id);

		return "redirect:/data/query";
	}

	@RequestMapping("/init")
	public String init() {
		return "data/data";
	}

}
