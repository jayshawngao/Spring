package jayshawn.spring.aop.xml;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAll {


	@Test
	public void testAOPXML() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
		ArithmeticalCaculator caculator = (ArithmeticalCaculator) context.getBean("arithmeticalCaculator");
		System.out.println(caculator.add(1, 2));
	}

}
