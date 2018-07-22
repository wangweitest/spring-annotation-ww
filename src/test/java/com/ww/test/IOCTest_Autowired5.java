package com.ww.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ww.bean.Boss;
import com.ww.bean.Car;
import com.ww.bean.Color;
import com.ww.config.ConfigOfAurowired;
import com.ww.service.BookService;

/**
 * �Զ�װ��;
 * 		Spring��������ע�루DI������ɶ�IOC�������и��������������ϵ��ֵ��
 * 
 * 1����@Autowired���Զ�ע�룺
 * 		1����Ĭ�����Ȱ�������ȥ�������Ҷ�Ӧ�����:applicationContext.getBean(BookDao.class);�ҵ��͸�ֵ
 * 		2��������ҵ������ͬ���͵�������ٽ����Ե�������Ϊ�����idȥ�����в���
 * 							applicationContext.getBean("bookDao")
 * 		3����@Qualifier("bookDao")��ʹ��@Qualifierָ����Ҫװ��������id��������ʹ������������@autowiredһ��ʹ�õ�
 * 		4�����Զ�װ��Ĭ��һ��Ҫ�����Ը�ֵ�ã�û�оͻᱨ��
 * 			����ʹ��@Autowired(required=false);
 * 		5����@Primary����Spring�����Զ�װ���ʱ��Ĭ��ʹ����ѡ��bean����@beanһ��ʹ�õ�
 * 				Ҳ���Լ���ʹ��@Qualifierָ����Ҫװ���bean������
 * 		====���ȼ���@Qualifier>@Primary>Ĭ��====
 * 		
 * 		BookService{
 * 			@Autowired
 * 			BookDao  bookDao;
 * 		}
 * 
 * 2����Spring��֧��ʹ��@Resource(JSR250)��@Inject(JSR330)[java�淶��ע��]
 * 		@Resource:
 * 			���Ժ�@Autowiredһ��ʵ���Զ�װ�书�ܣ�Ĭ���ǰ���������ƽ���װ��ģ�
 * 			û����֧��@Primary����û��֧��@Autowired��reqiured=false��;
 * 		@Inject:
 * 			��Ҫ����javax.inject�İ�����Autowired�Ĺ���һ����û��required=false�Ĺ��ܣ�
 *  ===@Autowired:Spring����ģ� @Resource��@Inject����java�淶====
 * 	
 * AutowiredAnnotationBeanPostProcessor:��������Զ�װ�书�ܣ�		
 * 
 * 3���� @Autowired:�����������������������ԣ����Ǵ������л�ȡ���������ֵ
 * 		1����[��ע�ڷ���λ��]��@Bean+���������������������л�ȡ;Ĭ�ϲ�д@AutowiredЧ����һ���ģ������Զ�װ��
 * 		2����[���ڹ�������]��������ֻ��һ���вι�����������вι�������@Autowired����ʡ�ԣ�����λ�õ�������ǿ����Զ��������л�ȡ
 * 		3�������ڲ���λ�ã�
 * 
 * 4�����Զ��������Ҫʹ��Spring�����ײ��һЩ�����ApplicationContext��BeanFactory��xxx����
 * 		�Զ������ʵ��xxxAware���ڴ��������ʱ�򣬻���ýӿڹ涨�ķ���ע����������Aware��
 * 		��Spring�ײ�һЩ���ע�뵽�Զ����Bean�У�
 * 		xxxAware������ʹ��xxxProcessor��
 * 			ApplicationContextAware==��ApplicationContextAwareProcessor��
 * 		===��������ӿ��Կ�Dog��
 * 		
 * 	
 * 		
 *
 */

public class IOCTest_Autowired5 {
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigOfAurowired.class);
	@Test
	public void test01(){
		
		printBeans(applicationContext);
		
		BookService bookService = applicationContext.getBean(BookService.class);
		System.out.println(bookService.getBookDao());
//		
//		//��ע��set�����ϣ���������
//		Boss boss = applicationContext.getBean(Boss.class);
//		System.out.println(boss);
//		Car car = applicationContext.getBean(Car.class);
//		System.out.println(car);
		
		//��ע�ڲ����ϻ��߲���
//		Color color = applicationContext.getBean(Color.class);
//		System.out.println(color.getCar());
//		
//		Car car = applicationContext.getBean(Car.class);
//		System.out.println(car);
		
		applicationContext.close();
	}
	
	private void printBeans(AnnotationConfigApplicationContext applicationContext){
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}

}
