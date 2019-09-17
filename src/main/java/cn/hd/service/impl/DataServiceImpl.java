package cn.hd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hd.mapper.DataMapper;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Data;

import cn.hd.service.IDataService;

@Service("dataService")
public class DataServiceImpl implements IDataService {

	@Resource
	private DataMapper dataMapper;
	
	@Override
	public int deleteByPrimaryKey(String Dataid) {
		// TODO Auto-generated method stub
		return dataMapper.deleteByPrimaryKey(Dataid);
	}

	@Override
	public int insert(Data record) {
		// TODO Auto-generated method stub
		return dataMapper.insert(record);
	}

	@Override
	public int insertSelective(Data record) {
		// TODO Auto-generated method stub
		return dataMapper.insertSelective(record);
	}

	@Override
	public Data selectByPrimaryKey(String Dataid) {
		// TODO Auto-generated method stub
		return dataMapper.selectByPrimaryKey(Dataid);
	}

	@Override
	public int updateByPrimaryKeySelective(Data record) {
		// TODO Auto-generated method stub
		return dataMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Data record) {
		// TODO Auto-generated method stub
		return dataMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Data> queryAll() {
		// TODO Auto-generated method stub
		return dataMapper.queryAll();
	}

	@Override
	public PageInfo<Data> query(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<Data> list=dataMapper.query(vo);
		PageInfo<Data> pageInfo=new PageInfo<Data>(list);
		return pageInfo;
	}

}
