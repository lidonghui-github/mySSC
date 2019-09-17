package cn.hd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hd.mapper.UserbeanMapper;
import cn.hd.model.BaseConditionVO;
import cn.hd.model.Userbean;
import cn.hd.service.IUserService;
@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private UserbeanMapper userMapper;
	
	@Override
	public int deleteByPrimaryKey(String userid) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(userid);
	}

	@Override
	public int insert(Userbean record) {
		// TODO Auto-generated method stub
		return userMapper.insert(record);
	}

	@Override
	public int insertSelective(Userbean record) {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(record);
	}

	@Override
	public Userbean selectByPrimaryKey(String userid) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(userid);
	}

	@Override
	public int updateByPrimaryKeySelective(Userbean record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Userbean record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Userbean> queryAll() {
		// TODO Auto-generated method stub
		return userMapper.queryAll();
	}

	@Override
	public PageInfo<Userbean> query(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<Userbean> list=userMapper.query(vo);
		PageInfo<Userbean> pageInfo=new PageInfo<Userbean>(list);
		return pageInfo;
	}

	@Override
	public List<Userbean> findUserByName(String userName) {
		// TODO Auto-generated method stub
		return userMapper.findUserByName(userName);
	}

}
