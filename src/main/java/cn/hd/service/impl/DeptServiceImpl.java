package cn.hd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hd.mapper.DeptMapper;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Dept;

import cn.hd.service.IDeptService;

@Service("deptService")
public class DeptServiceImpl implements IDeptService {

	@Resource
	private DeptMapper deptMapper;
	
	@Override
	public int deleteByPrimaryKey(String Deptid) {
		// TODO Auto-generated method stub
		return deptMapper.deleteByPrimaryKey(Deptid);
	}

	@Override
	public int insert(Dept record) {
		// TODO Auto-generated method stub
		return deptMapper.insert(record);
	}

	@Override
	public int insertSelective(Dept record) {
		// TODO Auto-generated method stub
		return deptMapper.insertSelective(record);
	}

	@Override
	public Dept selectByPrimaryKey(String Deptid) {
		// TODO Auto-generated method stub
		return deptMapper.selectByPrimaryKey(Deptid);
	}

	@Override
	public int updateByPrimaryKeySelective(Dept record) {
		// TODO Auto-generated method stub
		return deptMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Dept record) {
		// TODO Auto-generated method stub
		return deptMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Dept> queryAll() {
		// TODO Auto-generated method stub
		return deptMapper.queryAll();
	}

	@Override
	public PageInfo<Dept> query(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<Dept> list=deptMapper.query(vo);
		PageInfo<Dept> pageInfo=new PageInfo<Dept>(list);
		return pageInfo;
	}

}
