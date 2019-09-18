package cn.hd.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import cn.hd.model.OrderExtend;
import cn.hd.utils.VoUtil;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
        List<Order> list = orderMapper.query(vo);
        PageInfo<Order> pageInfo = new PageInfo<Order>(list);
        return pageInfo;
    }

    //将时间格式化成特定格式的字符串   ldh   20190917
    public void dateToString(List<Order> list, List<OrderExtend> orderExtendList) {
        if (null != orderExtendList) {
            orderExtendList.clear();
        }
        if (null == list || list.size() == 0) {
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (Order order : list) {
            OrderExtend orderExtend = new OrderExtend();
            VoUtil.copyVO2POJO(order, orderExtend);
            orderExtend.setOrderCrtTime2(simpleDateFormat.format(order.getOrderCrtTime()));
            orderExtend.setOrderUpdTime2(simpleDateFormat.format(order.getOrderUpdTime()));
            orderExtendList.add(orderExtend);
        }
    }


}
