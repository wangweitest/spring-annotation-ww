package com.ww.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.ComponentScan.Filter;

import com.ww.bean.Person;



@Configuration
@ComponentScan(value={"com.ww"},
//excludeFilters={@Filter(type=FilterType.ANNOTATION,classes={Controller.class})},
includeFilters={@Filter(type=FilterType.ANNOTATION,classes={Controller.class})},
useDefaultFilters=false)
//@ComponentScan  value:ָ��Ҫɨ��İ�
//excludeFilters = Filter[] ��ָ��ɨ���ʱ����ʲô�����ų���Щ���
//includeFilters = Filter[] ��ָ��ɨ���ʱ��ֻ��Ҫ������Щ�����ʹ�õ�ʱ��Ҫָ��useDefaultFilters=false
//FilterType.ANNOTATION������ע��
//FilterType.ASSIGNABLE_TYPE�����ո��������ͣ�
//FilterType.ASPECTJ��ʹ��ASPECTJ���ʽ
//FilterType.REGEX��ʹ������ָ��
//FilterType.CUSTOM��ʹ���Զ������

public class MainConfig {
	
	//@Bean ��������ע��һ��Bean;����Ϊ����ֵ�����ͣ�idĬ�����÷�������Ϊid
	@Bean("person")
	public Person person01(){
		return new Person("lisi", 20);
	}
	
}
