package jayshawn.spring.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	/**
	 *	 Pointcut注解的方法用于给之后的各种通知使用，方法体中不需要添加其他代码
	 */
	@Pointcut("execution(public int jayshawn.spring.aop.ArithmeticalCaculator.*(..))")
	public void declareJointPointExpression(){}
	
//	@Before("execution(public int jayshawn.spring.aop.ArithmeticalCaculator.*(..))")
//	public void beforeMethod(JoinPoint joinpoint) {
//		String methodName = joinpoint.getSignature().getName();
//		List<Object> args = Arrays.asList(joinpoint.getArgs());
//		System.out.println("before execution of "+methodName+" with args "+args);
//	}
//	
//	@AfterReturning(value="declareJointPointExpression()", returning="result")
//	public void AfterReturningMethod(JoinPoint joinpoint, Object result){
//		String methodName = joinpoint.getSignature().getName();
//		List<Object> args = Arrays.asList(joinpoint.getArgs());
//		System.out.println("end execution of "+methodName+" with args "+args+" with result: "+result);
//
//	}
	
	@Around(value="declareJointPointExpression()")
	public int aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("before execution of "+joinPoint.getSignature().getName()+" with args "+Arrays.toString(joinPoint.getArgs()));
		int result = (int) joinPoint.proceed(joinPoint.getArgs());
		System.out.println("end execution of "+joinPoint.getSignature().getName()+" with args "+Arrays.toString(joinPoint.getArgs())+" with result: "+result);
		return result;
	}
}
