package com.ww.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.ww.bean.ColorFactoryBean;
import com.ww.bean.Person;
import com.ww.bean.Red;
import com.ww.condition.LinuxCondition;
import com.ww.condition.MyImportBeanDefinitionRegistrar;
import com.ww.condition.MyImportSelector;
import com.ww.condition.WindowsCondition;



@Configuration
//@ComponentScan(value={"com.ww"}) 
//@Conditional(value=WindowsCondition.class)
@Import(value={Red.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {
	
	//Ĭ���ǵ�ʵ����
	/**
	 * ConfigurableBeanFactory#SCOPE_PROTOTYPE    
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON  
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  request
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION	 sesssion
	 * @return\
	 * @Scope:����������
	 * prototype����ʵ���ģ�ioc��������������ȥ���÷�������������������С�
	 * 					ÿ�λ�ȡ��ʱ��Ż���÷�����������
	 * singleton����ʵ���ģ�Ĭ��ֵ����ioc������������÷�����������ŵ�ioc�����С�
	 * 			�Ժ�ÿ�λ�ȡ����ֱ�Ӵ�������map.get()�����ã�
	 * request��ͬһ�����󴴽�һ��ʵ��
	 * session��ͬһ��session����һ��ʵ��
	 * 
	 * �����أ�
	 * 		��ʵ��bean��Ĭ��������������ʱ�򴴽�����
	 * 		�����أ������������������󡣵�һ��ʹ��(��ȡ)Bean�������󣬲���ʼ����
	 * 
	 */
	//@Lazy(value=true)
	//@Scope(value="prototype")
	@Bean("person")
	public Person person01(){
		System.out.println("������ʼ��������1��������");
		return new Person("lisi", 20);
	}
	
	
	/**
	 * @Conditional({Condition}) �� ����һ�������������жϣ�����������������ע��bean��
	 * ���Է�����ͷ����ϣ����������Ե�ǰ������������Ե�ǰ�࣬������ʱ���������еķ���������ע��
	 * 
	 * ���ϵͳ��windows����������ע��("bill")
	 * �����linuxϵͳ����������ע��("linus")
	 * ����ͨ���޸�run configrations�е�arguments  -Dos.name=linux ���в���ϵͳ���л�
	 */
//	@Conditional(WindowsCondition.class)
	@Bean("bill")
	public Person person02(){
		System.out.println("������ʼ��������2��������");
		return new Person("lisi", 20);
	}
	
//	@Conditional(LinuxCondition.class)
	@Bean("linus")
	public Person person03(){
		System.out.println("������ʼ��������3��������");
		return new Person("lisi", 20);
	}
	
	/**
	 * ��������ע�������
	 * 1������ɨ��+�����עע�⣨@Controller/@Service/@Repository/@Component��[�Լ�д����]
	 * 2����@Bean[����ĵ���������������]
	 * 3����@Import[���ٸ������е���һ�����]��������������
	 * 		1����@Import(Ҫ���뵽�����е����)�������оͻ��Զ�ע����������idĬ����ȫ����
	 * 		2����ImportSelector:������Ҫ����������ȫ�������飻
	 * 		3����ImportBeanDefinitionRegistrar:�ֶ�ע��bean��������
	 * 4����ʹ��Spring�ṩ�� FactoryBean������Bean��;
	 * 		1����Ĭ�ϻ�ȡ�����ǹ���bean����getObject�����Ķ���
	 * 		2����Ҫ��ȡ����Bean����������Ҫ��idǰ���һ��&
	 * 			&colorFactoryBean
	 */
	@Bean
	public ColorFactoryBean colorFactoryBean(){
		return new ColorFactoryBean();
	}
}
