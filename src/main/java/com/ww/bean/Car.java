package com.ww.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

//���Կ��������������ڷ�����ִ��˳��
@Component
public class Car /**implements InitializingBean,DisposableBean**/{
	
	public Car(){
		System.out.println("car constructor...");
	}
	
	public void init(){
		System.out.println("car ... init...");
	}
	
	public void detory(){
		System.out.println("car ... detory...");
	}
//----------------------------------------------------------------------
//	@Override
//	public void destroy() throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("car ... destroy...");
//	}
//
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("car ... afterPropertiesSet...");
//		
//	}
//	
////----------------------------------------------------------------------
//	//���󴴽�����ֵ֮�����
//	@PostConstruct
//	public void postConstruct(){
//		System.out.println("car....@PostConstruct...");
//	}
//	
//	//�����Ƴ�����֮ǰ
//	@PreDestroy
//	public void preDestroy(){
//		System.out.println("car....@PreDestroy...");
//	}
	

}
