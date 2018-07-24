package com.ww.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ww.config.MainConfig;

public class IOCTest1 {
	/**
		 * 测试@ComponentScan
		 */
		@Test
		public void test01(){
			AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
			
			//查看容器中所有的bean，getBeanDefinitionNames
			String[] definitionNames = applicationContext.getBeanDefinitionNames();
			for (String name : definitionNames) {
				System.out.println(name);
			}
		}
		
		
		/**
		 * 用@bean注册时bean的名字：@Bean 给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
		 */
		@Test
		public void test00(){
	//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
	//		Person bean = (Person) applicationContext.getBean("person");
	//		System.out.println(bean);
			
			ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
	//		Person bean = applicationContext.getBean(Person.class);
	//		System.out.println(bean);
			
			//获取bean的名字
	//		String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
	//		for (String name : namesForType) {
	//			System.out.println(name);
	//		}
			
			//查看容器中所有的bean，getBeanDefinitionNames
			String[] definitionNames = applicationContext.getBeanDefinitionNames();
			for (String name : definitionNames) {
				System.out.println(name);
			}
		
		}
}

