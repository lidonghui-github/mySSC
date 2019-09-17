package cn.hd.cl;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.hd.mapper.TreeMapper;
import cn.hd.model.Tree;

@Component
public class CompareTwoTrees {
	Logger logger = LoggerFactory.getLogger(CompareTwoTrees.class);
	//比较两棵树形结构是否能够对应得上
	public void checkTwoTree(String oldApprNo,String newApprNo){
		/*Tree tree = new Tree();
		tree.setRescriptumno(oldApprNo);
		List<Tree> oldTrees = treeMapper.findTrees(tree);
		tree.setRescriptumno(newApprNo);
		List<Tree> newTrees = treeMapper.findTrees(tree);*/
		System.out.println("jjjjjjj");
		
	}		
	
	@Resource
	TreeMapper treeMapper;
	
	@Test
	public void fun(){
		checkTwoTree("111","222");
	}

}
