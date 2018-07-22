package com.ww.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ww.bean.Boss;
import com.ww.bean.Car;
import com.ww.bean.Color;
import com.ww.config.ConfigOfAurowired;
import com.ww.service.BookService;

/**
 * 自动装配;
 * 		Spring利用依赖注入（DI），完成对IOC容器中中各个组件的依赖关系赋值；
 * 
 * 1）、@Autowired：自动注入：
 * 		1）、默认优先按照类型去容器中找对应的组件:applicationContext.getBean(BookDao.class);找到就赋值
 * 		2）、如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找
 * 							applicationContext.getBean("bookDao")
 * 		3）、@Qualifier("bookDao")：使用@Qualifier指定需要装配的组件的id，而不是使用属性名，和@autowired一块使用的
 * 		4）、自动装配默认一定要将属性赋值好，没有就会报错；
 * 			可以使用@Autowired(required=false);
 * 		5）、@Primary：让Spring进行自动装配的时候，默认使用首选的bean；和@bean一块使用的
 * 				也可以继续使用@Qualifier指定需要装配的bean的名字
 * 		====优先级：@Qualifier>@Primary>默认====
 * 		
 * 		BookService{
 * 			@Autowired
 * 			BookDao  bookDao;
 * 		}
 * 
 * 2）、Spring还支持使用@Resource(JSR250)和@Inject(JSR330)[java规范的注解]
 * 		@Resource:
 * 			可以和@Autowired一样实现自动装配功能；默认是按照组件名称进行装配的；
 * 			没有能支持@Primary功能没有支持@Autowired（reqiured=false）;
 * 		@Inject:
 * 			需要导入javax.inject的包，和Autowired的功能一样。没有required=false的功能；
 *  ===@Autowired:Spring定义的； @Resource、@Inject都是java规范====
 * 	
 * AutowiredAnnotationBeanPostProcessor:解析完成自动装配功能；		
 * 
 * 3）、 @Autowired:构造器，参数，方法，属性；都是从容器中获取参数组件的值
 * 		1）、[标注在方法位置]：@Bean+方法参数；参数从容器中获取;默认不写@Autowired效果是一样的；都能自动装配
 * 		2）、[标在构造器上]：如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从容器中获取
 * 		3）、放在参数位置：
 * 
 * 4）、自定义组件想要使用Spring容器底层的一些组件（ApplicationContext，BeanFactory，xxx）；
 * 		自定义组件实现xxxAware；在创建对象的时候，会调用接口规定的方法注入相关组件；Aware；
 * 		把Spring底层一些组件注入到自定义的Bean中；
 * 		xxxAware：功能使用xxxProcessor；
 * 			ApplicationContextAware==》ApplicationContextAwareProcessor；
 * 		===这个的例子可以看Dog类
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
//		//标注在set方法上，构造器上
//		Boss boss = applicationContext.getBean(Boss.class);
//		System.out.println(boss);
//		Car car = applicationContext.getBean(Car.class);
//		System.out.println(car);
		
		//标注在参数上或者不标
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
