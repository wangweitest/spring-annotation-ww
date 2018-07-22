package com.ww.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.ww.bean.Person;
import com.ww.config.ConfigOfPropertyValues;

public class IOCTest_PropertyValue4 {
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigOfPropertyValues.class);
	@Test
	public void test01(){
		printBeans(applicationContext);
		System.out.println("=============");
		
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
		
		//配置文件中的值默认都加载到了环境变量中environment，所以这样也可以去到值
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String property = environment.getProperty("person.nickName");
		System.out.println(property);
		applicationContext.close();
	}
	
	private void printBeans(AnnotationConfigApplicationContext applicationContext){
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}

}
