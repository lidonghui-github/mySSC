package cn.hd.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Menu;

@Repository
public interface MenuMapper {
    int deleteByPrimaryKey(String menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    List<Menu> queryAll();
    List<Menu> query(BaseConditionVO vo);
}