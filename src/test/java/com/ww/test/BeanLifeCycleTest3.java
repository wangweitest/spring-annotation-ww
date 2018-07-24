package com.ww.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ww.config.ConfigOfLifeCycle;

public class BeanLifeCycleTest3 {

	/**
	 * 测试bean的生命周期方法
	 */
	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				ConfigOfLifeCycle.class);

		System.out.println("容器创建完成...");
//		applicationContext.getBean("car");
		
		//查看容器中所有的bean，getBeanDefinitionNames
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
		
		// 关闭容器
		applicationContext.close();
	}

}
