package com.ww.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ww.bean.Yellow;
import com.ww.config.ConfigOfProfile;

public class IOCTest_Profile {
	
	//1、使用命令行动态参数: 在虚拟机参数位置加载 -Dspring.profiles.active=test
	//2、代码的方式激活某种环境；
	
	//===切换环境的做法一般不会在生产环境用，这就会让每个人知道生产环境的密码，一般都会在配置中心进行配置
	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext();
		//1、创建一个applicationContext
		//2、设置需要激活的环境
//		applicationContext.getEnvironment().setActiveProfiles("test");
		//3、注册主配置类
		applicationContext.register(ConfigOfProfile.class);
		//4、启动刷新容器
		applicationContext.refresh();
		
		
		String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
		for (String string : namesForType) {
			System.out.println(string);
		}
		
		Yellow bean = applicationContext.getBean(Yellow.class);
		System.out.println(bean);
		applicationContext.close();
	}

}
