package cn.hd.service.impl;

import cn.hd.mapper.LoginLogMapper;
import cn.hd.model.BaseConditionVO;
import cn.hd.model.LoginLog;
import cn.hd.service.ILoginLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.List;

public class LoginLogServiceImpl implements ILoginLogService {
    @Resource
    LoginLogMapper loginLogMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return loginLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(LoginLog record) {
        return loginLogMapper.insert(record);
    }

    @Override
    public int insertSelective(LoginLog record) {
        return loginLogMapper.insertSelective(record);
    }

    @Override
    public LoginLog selectByPrimaryKey(String id) {
        return loginLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(LoginLog record) {
        return loginLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LoginLog record) {
        return loginLogMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<LoginLog> queryAll() {
        return loginLogMapper.queryAll();
    }

    @Override
    public PageInfo<LoginLog> query(BaseConditionVO vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<LoginLog> list = loginLogMapper.query(vo);
        PageInfo<LoginLog> pageInfo = new PageInfo<LoginLog>(list);
        return pageInfo;
    }
}
