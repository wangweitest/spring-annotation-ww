package com.ww.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.ww.bean.Car;
import com.ww.bean.Cat;
import com.ww.bean.Dog;
import com.ww.bean.MyBeanPostProcessor;

/**
 * bean���������ڣ�
 * 		bean����---��ʼ��----���ٵĹ���
 * ��������bean���������ڣ�
 * ���ǿ����Զ����ʼ�������ٷ�����������bean���е���ǰ�������ڵ�ʱ�������������Զ���ĳ�ʼ�������ٷ���
 * 
 * ���죨���󴴽���
 * 		��ʵ����������������ʱ�򴴽�����
 * 		��ʵ������ÿ�λ�ȡ��ʱ�򴴽�����\
 * 
 * BeanPostProcessor.postProcessBeforeInitialization
 * ��ʼ����
 * 		���󴴽���ɣ�����ֵ�ã����ó�ʼ������������
 * BeanPostProcessor.postProcessAfterInitialization
 * ���٣�
 * 		��ʵ���������رյ�ʱ��
 * 		��ʵ������������������bean����������������ٷ�����
 * 
 * 
 * �����õ����������е�BeanPostProcessor������ִ��beforeInitialization��
 * һ������null������forѭ��������ִ�к����BeanPostProcessor.postProcessorsBeforeInitialization
 * 
 * BeanPostProcessorԭ��
 * populateBean(beanName, mbd, instanceWrapper);��bean�������Ը�ֵ
 * initializeBean
 * {
 * applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 * invokeInitMethods(beanName, wrappedBean, mbd);ִ���Զ����ʼ��
 * applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 *}
 * 
 * 
 * 
 * 1����ָ����ʼ�������ٷ�����
 * 		ͨ��@Beanָ��init-method��destroy-method��
 * 2����ͨ����Beanʵ��InitializingBean�������ʼ���߼�����
 * 				DisposableBean�����������߼���;
 * 3��������ʹ��JSR250��
 * 		@PostConstruct����bean������ɲ������Ը�ֵ��ɣ���ִ�г�ʼ������
 * 		@PreDestroy������������bean֮ǰ֪ͨ���ǽ���������
 * 4����BeanPostProcessor��interface����bean�ĺ��ô�������
 * 		��bean��ʼ��ǰ�����һЩ��������
 * 		postProcessBeforeInitialization:�ڳ�ʼ��֮ǰ���������Ƕ�bean���Գ�ʼ��֮ǰ
 * 		postProcessAfterInitialization:�ڳ�ʼ��֮����
 * 
 * Spring�ײ�� BeanPostProcessor ��ʹ�ã�
 * 		bean��ֵ��ע�����������@Autowired����������ע�⹦�ܣ�@Async,xxx BeanPostProcessor;
 * 
 * @author lfy
 *
 */
//@ComponentScan("com.ww.bean")
@Configuration
public class ConfigOfLifeCycle {
	
	//1ָ����ʼ�������ٷ���
	//@Scope("prototype")
	@Bean(initMethod="init",destroyMethod="detory")
	public Car car(){
		return new Car();
	}
	
	//2ͨ����Beanʵ��InitializingBean�������ʼ���߼�����DisposableBean�����������߼���;
	@Bean
	public Cat cat(){
		return new Cat();
	}
	
	//3ʹ��JSR250��
	//	@PostConstruct����bean������ɲ������Ը�ֵ��ɣ���ִ�г�ʼ������
	//	@PreDestroy������������bean֮ǰ֪ͨ���ǽ���������
	@Bean
	public Dog dog(){
		return new Dog();
	}

	//4BeanPostProcessor
	@Bean
	public MyBeanPostProcessor myBeanPostProcessor(){
		return new MyBeanPostProcessor();
	}
}
