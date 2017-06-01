package com.zy.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zy.test.aspectj.TestforAspectJ;

import de.invesdwin.instrument.DynamicInstrumentationLoader;



//注解有顺序 ，按这个顺序
//@Configuration
//@ComponentScan(basePackages = {"com.zy.test"})
//@EnableAutoConfiguration
//@EnableCaching

/**
 *  *EnableAspectJAutoProxy开启切面编程
 *ComponentScan指定包之后，SpringBoot会自动扫描该包下面的功能，如Controller，Model，Aspect功能
 *org.sun.spring是我的包名，各位看客自行修改成自己的package name
 * @author eaves.zhu
 * 
 */

@Configurable(preConstruction=true,dependencyCheck=true,autowire=Autowire.BY_TYPE)
@EnableCaching  //ehcache
@EnableScheduling  //定时
@EnableSpringConfigured
@EnableAspectJAutoProxy //aop
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@EnableLoadTimeWeaving(aspectjWeaving= EnableLoadTimeWeaving.AspectJWeaving.ENABLED) //等价于xml@ImportResource(locations = "classpath:/config/ctx.spring.weaving.xml") //make @Configurable work
//@ImportResource(value = {"classpath:/META-INF/applicationContext-service.xml"})
@SpringBootApplication
@ComponentScan(basePackages = "com.zy.test")
@MapperScan(basePackages="com.zy.test.mapper")
public class SpringbootBaseDemo {
	static {
		DynamicInstrumentationLoader.waitForInitialized(); //dynamically attach java agent to jvm if not already present
	    DynamicInstrumentationLoader.initLoadTimeWeavingContext(); //weave all classes before they are loaded as beans
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBaseDemo.class, args);
		System.out.println("new Configureable bean");
		TestforAspectJ testforAspectJ=new TestforAspectJ();
		testforAspectJ.cut();
	}

}


