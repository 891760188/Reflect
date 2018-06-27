package ye.guo.huang.test01;

import java.lang.reflect.Method;

public class InvokeTester {
	 public int add(int param1, int param2)
    {
        return param1 + param2;

    }

    public String echo(String message)
    {
        return "Hello: " + message;
    }
    
    public static void main(String[] args) throws Exception {
    	Class<?> classType = InvokeTester.class;

        // 生成新的对象：用newInstance()方法 
        Object invokeTester = classType.newInstance();
        System.out.println(invokeTester instanceof InvokeTester);
        
        InvokeTester instance = (InvokeTester)invokeTester;
        instance.echo("world");
        
        Method addMethod = classType.getMethod("add", new Class[] {int.class,int.class});
        Object obj = addMethod.invoke(instance, new Object[]{1,2});
        int objInt = (int) obj;
        
        Method echoMethad = classType.getDeclaredMethod("echo", new Class[] {String.class});
        echoMethad.invoke(invokeTester, new Object[]{"fanshe.."});
	}
}
