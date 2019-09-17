package cn.hd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hd.mapper.MenuMapper;
import cn.hd.mapper.OrderMapper;
import cn.hd.model.BaseConditionVO;
import cn.hd.model.Order;
import cn.hd.service.IOrderService;
@Service("orderService")
public class OrderServiceImpl implements IOrderService {

	@Resource
	private OrderMapper orderMapper;
	
	@Override
	public int deleteByPrimaryKey(String Menuid) {
		// TODO Auto-generated method stub
		return orderMapper.deleteByPrimaryKey(Menuid);
	}

	@Override
	public int insert(Order record) {
		// TODO Auto-generated method stub
		return orderMapper.insert(record);
	}

	@Override
	public int insertSelective(Order record) {
		// TODO Auto-generated method stub
		return orderMapper.insertSelective(record);
	}

	@Override
	public Order selectByPrimaryKey(String Menuid) {
		// TODO Auto-generated method stub
		return orderMapper.selectByPrimaryKey(Menuid);
	}

	@Override
	public int updateByPrimaryKeySelective(Order record) {
		// TODO Auto-generated method stub
		return orderMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Order record) {
		// TODO Auto-generated method stub
		return orderMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Order> queryAll() {
		// TODO Auto-generated method stub
		return orderMapper.queryAll();
	}

	@Override
	public PageInfo<Order> query(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<Order> list=orderMapper.query(vo);
		PageInfo<Order> pageInfo=new PageInfo<Order>(list);
		return pageInfo;
	}

}
