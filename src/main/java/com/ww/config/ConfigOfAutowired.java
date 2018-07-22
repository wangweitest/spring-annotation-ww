package com.ww.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.ww.bean.Color;
import com.ww.bean.Car;
import com.ww.dao.BookDao;


@Configuration
@ComponentScan(value={"com.ww.service","com.ww.dao","com.ww.bean"})
public class ConfigOfAutowired {
	
	//@Primary
	@Bean
	public BookDao bookDao2(){
		BookDao bookDao = new BookDao();
		bookDao.setLable("2");
		return bookDao;
	}
	
	@Bean
	public Car car(){
		return new Car();
	}
	
	/**
	 * @Bean标注的方法创建对象的时候，方法参数的值从容器中获取
	 * @param car
	 * @return
	 */
	@Bean
	public Color color(Car car){
		Color color = new Color();
		color.setCar(car);
		return color;
	}
	
	
}
