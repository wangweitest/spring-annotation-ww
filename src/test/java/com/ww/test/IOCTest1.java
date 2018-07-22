package com.ww.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ww.config.MainConfig;

public class IOCTest1 {
	/**
		 * ����@ComponentScan
		 */
		@Test
		public void test01(){
			AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
			
			//�鿴���������е�bean��getBeanDefinitionNames
			String[] definitionNames = applicationContext.getBeanDefinitionNames();
			for (String name : definitionNames) {
				System.out.println(name);
			}
		}
		
		
		/**
		 * ��@beanע��ʱbean�����֣�@Bean ��������ע��һ��Bean;����Ϊ����ֵ�����ͣ�idĬ�����÷�������Ϊid
		 */
		@Test
		public void test00(){
	//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
	//		Person bean = (Person) applicationContext.getBean("person");
	//		System.out.println(bean);
			
			ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
	//		Person bean = applicationContext.getBean(Person.class);
	//		System.out.println(bean);
			
			//��ȡbean������
	//		String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
	//		for (String name : namesForType) {
	//			System.out.println(name);
	//		}
			
			//�鿴���������е�bean��getBeanDefinitionNames
			String[] definitionNames = applicationContext.getBeanDefinitionNames();
			for (String name : definitionNames) {
				System.out.println(name);
			}
		
		}
}

