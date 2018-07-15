package com.ww.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ww.config.ConfigOfLifeCycle;

public class BeanLifeCycleTest {

	/**
	 * ����bean���������ڷ���
	 */
	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				ConfigOfLifeCycle.class);

		System.out.println("�����������...");
		applicationContext.getBean("car");
		
		//�鿴���������е�bean��getBeanDefinitionNames
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
		
		// �ر�����
		applicationContext.close();
	}

}
