package cn.hd.cl;


import javax.annotation.Resource;

import org.jboss.logging.Logger;
import org.junit.After;

import org.junit.Before;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;

import cn.hd.mapper.TreeMapper;
import cn.hd.model.Role;
import cn.hd.service.IRoleService;

import cn.hd.utils.UUIDUtil;

public class test001 {
	private static final Logger log = Logger.getLogger(test001.class);

	private ApplicationContext ac;
	@Resource
	TreeMapper treeMapper;

	@Before
	public void setUpBeforeClass() throws Exception {
		ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		
	}

	@After
	public void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		IRoleService roleService = (IRoleService) ac.getBean("roleService");
		System.out.println(roleService.toString());
		for (int i = 0; i < 1000; i++) {
			Role role = new Role();
			role.setRoleId(UUIDUtil.getNumId().substring(0, 18) + i);
			role.setRoleName("管理员" + i);
			role.setRemark("自动生成数据" + i);
			// roleService.insert(role);
			System.out.println(role.toString() + "******"
					+ JSON.toJSONString(role));
		}
	}



}
