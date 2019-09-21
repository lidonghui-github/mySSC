package cn.hd.mapper;

import java.util.List;

import cn.hd.model.BaseConditionVO;

import cn.hd.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(String orderNo);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderNo);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    List<Order> queryAll();
    List<Order> query(BaseConditionVO vo);
}