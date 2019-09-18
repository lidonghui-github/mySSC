package cn.hd.service;

import java.util.List;


import com.github.pagehelper.PageInfo;

import cn.hd.model.BaseConditionVO;

import cn.hd.model.Order;


public interface IOrderService {
	List<Order> queryAll();

	int deleteByPrimaryKey(String id);

	int insert(Order record);

	int insertSelective(Order record);

	Order selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Order record);

	int updateByPrimaryKey(Order record);
	PageInfo<Order> query(BaseConditionVO vo);

}
