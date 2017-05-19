package jayshawn.spring.aop.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {
	
	
	public void beforeMethod(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		System.out.println("before execution of "+methodName+" with args "+args);
	}
	
	public void AfterReturningMethod(JoinPoint joinpoint, Object result){
		String methodName = joinpoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		System.out.println("end execution of "+methodName+" with args "+args+" with result: "+result);

	}
}
