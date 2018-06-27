package ye.guo.huang.test02;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test04 {
	public static void main(String[] args) {
		Test03 test03 = new Test03(11, "ÕÅÈý");
		Class clazz = test03.getClass();
		Class clazz2 = Test03.class;
		try {
	
			Field [] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				String key = field.getName();
				PropertyDescriptor descriptor = new PropertyDescriptor(key, clazz);
				Method method = descriptor.getReadMethod();
				Method method2 = descriptor.getWriteMethod();
				Object value = method.invoke(test03);
//				Object value2 = method2.invoke(test03,null);
				System.out.println(value);
//				System.out.println(value2);
				System.out.println("-------------");
			}
		Class clazz3 = Class.forName("ye.guo.huang.test02.Test03");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
