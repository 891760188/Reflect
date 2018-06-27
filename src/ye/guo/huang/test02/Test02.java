package ye.guo.huang.test02;

public class Test02 {
	
	public static void main(String[] args) {
		//不会初始化静态块
		Class clazz1 = Test01.class;
		System.out.println(clazz1);
		try {
			//会初始化静态库块
			Class clazz2 = Class.forName("ye.guo.huang.test02.Test01");
			//获取实例
			if(clazz2.newInstance() instanceof Test01){
				Test01 Test01 = (ye.guo.huang.test02.Test01) clazz2.newInstance();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
