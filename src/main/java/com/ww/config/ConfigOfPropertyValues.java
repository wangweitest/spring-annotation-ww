package com.ww.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ww.bean.Person;

//ʹ��@PropertySource��ȡ�ⲿ�����ļ��е�k/v���浽���еĻ���������;�������ⲿ�������ļ��Ժ�ʹ��${}ȡ�������ļ���ֵ
@PropertySource(value={"classpath:/person.properties"})
@Configuration
public class ConfigOfPropertyValues {
	
	@Value("${person.nickName2}")
	private String nickName;
	
	@Bean
	public Person person(){
		
		Person person = new Person();
		person.setNickName(nickName);
		return person;
	}

}
