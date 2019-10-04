package cn.hd.service;

import cn.hd.model.BaseConditionVO;
import cn.hd.model.TreeRela;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ITreeRelaService {
	List<TreeRela> queryAll();

	int deleteByPrimaryKey(String id);

	int insert(TreeRela record);

	int insertSelective(TreeRela record);

	TreeRela selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(TreeRela record);

	int updateByPrimaryKey(TreeRela record);
	PageInfo<TreeRela> query(BaseConditionVO vo);

	PageInfo<TreeRela> naruquery(BaseConditionVO vo);

	PageInfo<TreeRela> replacequery(BaseConditionVO vo);

	PageInfo<TreeRela> glquery(BaseConditionVO vo);

}
