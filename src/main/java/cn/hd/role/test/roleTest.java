package cn.hd.role.test;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.hd.mapper.RoleMapper;
import cn.hd.model.Role;
import cn.hd.utils.UUIDUtil;

public class roleTest {

	@Resource
	private  RoleMapper roleMapper;

	 RoleMapper mapper;

	@PostConstruct
	public  void initRoleTest(Role role ) {
		mapper = roleMapper;
		mapper.insert(role);
	}
	
	public static void main(String[] args) throws IOException {
	
		fun();
	}
	@PostConstruct
	 static void fun() throws IOException {
	
		for (int i = 0; i < 1000; i++) {
			Role role = new Role();
			role.setRoleId(UUIDUtil.getNumId().substring(0, 18));
			role.setRoleName("管理员" + i);
			role.setRemark("自动生成数据" + i);
			String configFile = "mybatis-config.xml";
			InputStream configStream = Resources.getResourceAsStream(configFile);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(configStream);
			SqlSession session = factory.openSession();
			session.insert("insert", role);
			

		}
	}

}
