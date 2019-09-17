package cn.hd.mapper;

import java.util.List;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.Userbean;
import org.springframework.stereotype.Repository;
@Repository
public interface UserbeanMapper {
   
    int deleteByPrimaryKey(String userid);

    int insert(Userbean record);

    int insertSelective(Userbean record);

    
    Userbean selectByPrimaryKey(String userid);

   
    int updateByPrimaryKeySelective(Userbean record);

   
    int updateByPrimaryKey(Userbean record);
    
    List<Userbean> queryAll();
    List<Userbean> query(BaseConditionVO vo);
    
    List<Userbean> findUserByName(String userName);
}