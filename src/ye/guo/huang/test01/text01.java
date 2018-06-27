package ye.guo.huang.test01;

import java.lang.reflect.Method;

public class text01 {
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> clz = Class.forName("java.lang.String");
		Method [] methods = clz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
	}
}
