package cn.hd.test;


import cn.hd.enums.FrozStat;
import cn.hd.mapper.TreeMapper;
import cn.hd.model.Role;

import cn.hd.model.Tree;
import cn.hd.service.ITreeService;
import cn.hd.utils.DateUtil;
import cn.hd.utils.MyDateUtil;
import cn.hd.utils.UUIDUtil;
import com.alibaba.fastjson.JSON;
import org.jboss.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class testTree001 {
	private static final Logger log = Logger.getLogger(testTree001.class);

	private ApplicationContext ac;


	@Before
	public void setUpBeforeClass() throws Exception {
		ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		
	}



	@Test
	public void test() {
		ITreeService treeService = (ITreeService) ac.getBean("treeService");
		System.out.println(treeService.toString());
		for (int i = 0; i < 10000; i++) {
			Tree tree = new Tree();
			tree.setId(UUIDUtil.getId());
			tree.setApprNo((new Integer((int)(Math.random()*100000000+i+1))).toString());
			tree.setApprAmt(new Integer((int)(Math.random()*1000000+i+1)));
			tree.setTreeNo((new Integer((int)(Math.random()*1000000+i+99))).toString());
			tree.setCrtTime(DateUtil.getCurrentDateTime());
			tree.setCrtTimeFormat(MyDateUtil.dateFormate_YYYY_MM_DD_HH_mm_ss(tree.getCrtTime()));
			tree.setVerNo(1);
			tree.setUsedAmt(0);
			tree.setFrozAmt(0);
			tree.setEnabAmt(tree.getApprAmt());
			tree.setFrozStat(FrozStat.未冻结.getCode());
			treeService.insertSelective(tree);
			System.out.println(tree.toString() + "******"
					+ JSON.toJSONString(tree));
		}
	}



}
