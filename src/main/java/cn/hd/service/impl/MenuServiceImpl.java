package cn.hd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hd.mapper.MenuMapper;
import cn.hd.model.BaseConditionVO;
import cn.hd.model.Menu;
import cn.hd.service.IMenuService;
@Service("menuService")
public class MenuServiceImpl implements IMenuService {

	@Resource
	private MenuMapper menuMapper;
	
	@Override
	public int deleteByPrimaryKey(String Menuid) {
		// TODO Auto-generated method stub
		return menuMapper.deleteByPrimaryKey(Menuid);
	}

	@Override
	public int insert(Menu record) {
		// TODO Auto-generated method stub
		return menuMapper.insert(record);
	}

	@Override
	public int insertSelective(Menu record) {
		// TODO Auto-generated method stub
		return menuMapper.insertSelective(record);
	}

	@Override
	public Menu selectByPrimaryKey(String Menuid) {
		// TODO Auto-generated method stub
		return menuMapper.selectByPrimaryKey(Menuid);
	}

	@Override
	public int updateByPrimaryKeySelective(Menu record) {
		// TODO Auto-generated method stub
		return menuMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Menu record) {
		// TODO Auto-generated method stub
		return menuMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Menu> queryAll() {
		// TODO Auto-generated method stub
		return menuMapper.queryAll();
	}

	@Override
	public PageInfo<Menu> query(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<Menu> list=menuMapper.query(vo);
		PageInfo<Menu> pageInfo=new PageInfo<Menu>(list);
		return pageInfo;
	}

}
