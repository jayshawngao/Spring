package jayshawn.spring.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	/**
	 *	 Pointcutע��ķ������ڸ�֮��ĸ���֪ͨʹ�ã��������в���Ҫ�����������
	 */
	@Pointcut("execution(public int jayshawn.spring.aop.ArithmeticalCaculator.*(..))")
	public void declareJointPointExpression(){}
	
	@Before("execution(public int jayshawn.spring.aop.ArithmeticalCaculator.*(..))")
	public void beforeMethod(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		System.out.println("before execution of "+methodName+" with args "+args);
	}
	
	@AfterReturning(value="declareJointPointExpression()", returning="result")
	public void AfterReturningMethod(JoinPoint joinpoint, Object result){
		String methodName = joinpoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		System.out.println("end execution of "+methodName+" with args "+args+" with result: "+result);

	}
}
