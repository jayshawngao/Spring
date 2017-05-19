package jayshawn.spring.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jayshawn.spring.aop.ArithmeticalCaculator;

public class TestAll {
	public static ApplicationContext applicationContext = null;
	
	static{
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}


	@Test
	public void testAOP() {
		ArithmeticalCaculator caculator = applicationContext.getBean(ArithmeticalCaculator.class);
		System.out.println(caculator.add(1, 2));
	}

}
