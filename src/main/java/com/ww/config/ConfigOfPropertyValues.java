package com.ww.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ww.bean.Person;

//使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中;加载完外部的配置文件以后使用${}取出配置文件的值
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
