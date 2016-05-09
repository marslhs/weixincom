package com.mars.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.mars.db.bean.YunMember;
import com.mars.db.service.IYunMemberService;

@RunWith(SpringJUnit4ClassRunner.class)		//琛ㄧず缁ф壙浜哠pringJUnit4ClassRunner绫�
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
//	private ApplicationContext ac = null;
	@Resource
	private IYunMemberService yunMemberService = null;
//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

	@Test
	public void test1() {
	    YunMember user = yunMemberService.getUserById(1);
		// System.out.println(user.getUserName());
		// logger.info("鍊硷細"+user.getUserName());
		logger.info(JSON.toJSONString(user));
	}
}
