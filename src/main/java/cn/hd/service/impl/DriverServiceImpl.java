package cn.hd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


import cn.hd.mapper.DriverMapper;
import cn.hd.model.BaseConditionVO;

import cn.hd.model.Driver;

import cn.hd.service.IDriverService;

@Service("driverService")
public class DriverServiceImpl implements IDriverService {

	@Resource
	private DriverMapper driverMapper;
	
	@Override
	public int deleteByPrimaryKey(String Dataid) {
		// TODO Auto-generated method stub
		return driverMapper.deleteByPrimaryKey(Dataid);
	}

	@Override
	public int insert(Driver record) {
		// TODO Auto-generated method stub
		return driverMapper.insert(record);
	}

	@Override
	public int insertSelective(Driver record) {
		// TODO Auto-generated method stub
		return driverMapper.insertSelective(record);
	}

	@Override
	public Driver selectByPrimaryKey(String Dataid) {
		// TODO Auto-generated method stub
		return driverMapper.selectByPrimaryKey(Dataid);
	}

	@Override
	public int updateByPrimaryKeySelective(Driver record) {
		// TODO Auto-generated method stub
		return driverMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Driver record) {
		// TODO Auto-generated method stub
		return driverMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Driver> queryAll() {
		// TODO Auto-generated method stub
		return driverMapper.queryAll();
	}

	@Override
	public PageInfo<Driver> query(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<Driver> list=driverMapper.query(vo);
		PageInfo<Driver> pageInfo=new PageInfo<Driver>(list);
		return pageInfo;
	}

}
