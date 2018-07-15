package com.ww.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.ConfigurableEnvironment;

import com.ww.bean.Blue;
import com.ww.bean.Person;
import com.ww.config.MainConfig;
import com.ww.config.MainConfig2;



public class IOCTest {
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
	
	/**
	 * 测试@Import
	 */
	@Test
	public void testImport(){
		printBeans(applicationContext);
		Blue bean = applicationContext.getBean(Blue.class);
		System.out.println(bean);
		
		//工厂Bean获取的是调用getObject创建的对象
		Object bean2 = applicationContext.getBean("colorFactoryBean");
		Object bean3 = applicationContext.getBean("colorFactoryBean");
		System.out.println("bean的类型："+bean2.getClass());
		System.out.println(bean2 == bean3);
		
		//得到工厂bean本身
		Object bean4 = applicationContext.getBean("&colorFactoryBean");
		System.out.println(bean4.getClass());
	}
	
	private void printBeans(AnnotationConfigApplicationContext applicationContext){
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}
	
	/**
	 * 测试：@Conditional
	 */
	@Test
	public void test03(){
		String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		//动态获取环境变量的值；Windows 10
		String property = environment.getProperty("os.name");
		System.out.println(property);
		for (String name : namesForType) {
			System.out.println(name);
		}
		
		Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
		System.out.println("----" + persons);
		
	}
	
	@Test
	public void test02(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
//		String[] definitionNames = applicationContext.getBeanDefinitionNames();
//		for (String name : definitionNames) {
//			System.out.println(name);
//		}
//		
		System.out.println("ioc容器创建完成....");
		Object bean = applicationContext.getBean("person");
		Object bean2 = applicationContext.getBean("person");
		System.out.println(bean == bean2);
	}

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
		String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
		for (String name : namesForType) {
			System.out.println(name);
		}
	
	}
	
}
