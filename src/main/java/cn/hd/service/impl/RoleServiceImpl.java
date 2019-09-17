package cn.hd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hd.mapper.RoleMapper;
import cn.hd.model.BaseConditionVO;
import cn.hd.model.Role;
import cn.hd.service.IRoleService;
@Service("roleService")
public class RoleServiceImpl implements IRoleService {

	@Resource
	private RoleMapper roleMapper;
	
	@Override
	public int deleteByPrimaryKey(String Roleid) {
		// TODO Auto-generated method stub
		return roleMapper.deleteByPrimaryKey(Roleid);
	}

	@Override
	public int insert(Role record) {
		// TODO Auto-generated method stub
		return roleMapper.insert(record);
	}

	@Override
	public int insertSelective(Role record) {
		// TODO Auto-generated method stub
		return roleMapper.insertSelective(record);
	}

	@Override
	public Role selectByPrimaryKey(String Roleid) {
		// TODO Auto-generated method stub
		return roleMapper.selectByPrimaryKey(Roleid);
	}

	@Override
	public int updateByPrimaryKeySelective(Role record) {
		// TODO Auto-generated method stub
		return roleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Role record) {
		// TODO Auto-generated method stub
		return roleMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Role> queryAll() {
		// TODO Auto-generated method stub
		return roleMapper.queryAll();
	}

	@Override
	public PageInfo<Role> query(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<Role> list=roleMapper.query(vo);
		PageInfo<Role> pageInfo=new PageInfo<Role>(list);
		return pageInfo;
	}

}
