package ye.guo.huang.test02;

public class Test02 {
	
	public static void main(String[] args) {
		//�����ʼ����̬��
		Class clazz1 = Test01.class;
		System.out.println(clazz1);
		try {
			//���ʼ����̬���
			Class clazz2 = Class.forName("ye.guo.huang.test02.Test01");
			//��ȡʵ��
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
