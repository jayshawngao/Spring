package jayshawn.spring.aop.xml;

import org.springframework.stereotype.Component;

public class ArithmeticalCaculator {
	public int add(int i, int j){
		return i+j;
	}
	public int sub(int i, int j){
		return i-j;
	}
	public int mul(int i, int j){
		return i*j;
	}
	public int div(int i, int j){
		return i/j;
	}
}
