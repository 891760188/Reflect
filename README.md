# Reflect
java 反射 learn
JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。
Java程序可以加载一个运行时才得知名称的class，获悉其完整构造（但不包括methods定义），并生成其对象实体、或对其fields设值、或唤起其methods。

Java反射机制主要提供了以下功能： 
在运行时判断任意一个对象所属的类；
在运行时构造任意一个类的对象；
在运行时判断任意一个类所具有的成员变量和方法；
在运行时调用任意一个对象的方法；生成动态代理。

众所周知Java有个Object 类，是所有Java 类的继承根源，其内声明了数个应该在所有Java 类中被改写的方法：hashCode()、equals()、clone()、toString()、getClass()等。其中getClass()返回一个Class 对象。
Class 类十分特殊。它和一般类一样继承自Object，其实体用以表达Java程序运行时的classes和interfaces，也用来表达enum、array、primitive Java types（boolean, byte, char, short, int, long, float, double）以及关键词void。当一个class被加载，或当加载器（class loader）的defineClass()被JVM调用，JVM 便自动产生一个Class 对象

可以利用反射机制在Java程序中，动态的去调用一些protected甚至是private的方法或类，这样可以很大程度上满足我们的一些比较特殊需求

Class类：代表一个类。
Field类：代表类的成员变量(成员变量也称为类的属性)。
Method类：代表类的方法。
Constructor 类：代表类的构造方法。
Array类：提供了动态创建数组，以及访问数组元素的静态方法。



获得一个 Class 对象的方法之一：
1  java.lang.Class c = Class.forName("java.lang.String");//获得类Method m[] = c.getDeclaredMethods(); //取得类的方法Constructor ctorlist[] = c.getDeclaredConstructors();//获取构造器信息Field fieldlist[] = c.getDeclaredFields();//获取属性字段  

http://www.cnblogs.com/mengdd/archive/2013/01/26/2877972.html

常用的获取Class对象的3种方式：
Class.forName("java.lang.String");
String.class;
String str = "aa";
Class<?> classType1 = str.getClass();//对象

通过反射调用方法
import java.lang.reflect.Method;
public class InvokeTester
{
    public int add(int param1, int param2)
    {
        return param1 + param2;
    }

    public String echo(String message)
    {
        return "Hello: " + message;
    }

    public static void main(String[] args) throws Exception
    {
        // 以前的常规执行手段
        InvokeTester tester = new InvokeTester();
        System.out.println(tester.add(1, 2));
        System.out.println(tester.echo("Tom"));
        System.out.println("---------------------------");
        // 通过反射的方式
        // 第一步，获取Class对象
        // 前面用的方法是：Class.forName()方法获取
        // 这里用第二种方法，类名.class
        Class<?> classType = InvokeTester.class;
        // 生成新的对象：用newInstance()方法
        Object invokeTester = classType.newInstance();
        System.out.println(invokeTester instanceof InvokeTester); // 输出true
        // 通过反射调用方法
        // 首先需要获得与该方法对应的Method对象
        Method addMethod = classType.getMethod("add", new Class[] { int.class,
                int.class });
        // 第一个参数是方法名，第二个参数是这个方法所需要的参数的Class对象的数组
        // 调用目标方法
        Object result = addMethod.invoke(invokeTester, new Object[] { 1, 2 });
        System.out.println(result); // 此时result是Integer类型
        //调用第二个方法
        Method echoMethod = classType.getDeclaredMethod("echo", new Class[]{String.class});
        Object result2 = echoMethod.invoke(invokeTester, new Object[]{"Tom"});
        System.out.println(result2);
    }
}
//获得对象的另外一种方式
先获取class对象，然后通过该对象获取对应的constructor对象，然后通过该对象的newInstance()方法生成
Class<?> classType = Customer.class;
 // 获得Constructor对象,此处获取第一个无参数的构造方法的
Constructor cons = classType.getConstructor(new Class[] {});//此处可以带参数
 // 通过构造方法来生成一个对象
 Object obj = cons.newInstance(new Object[] {});//此处可以带参数

 Class<?> classType = Customer.class;
    Constructor cons2 = classType.getConstructor(new Class[] {String.class,int.class});
 Object obj2 = cons2.newInstance(new Object[] {"ZhangSan",20});

------------------------------------------------------------------------------------------------------------------
------------------------------------------Java反射-----------------------------------------------------------
------------------------------------------------------------------------------------------------------------------
https://www.jianshu.com/p/53eb4e16d00e	
// 加载类的3种方法 
Class clazz = Class.forName("com.yano.reflect.Person"); 
Class clazz1 = new Person().getClass();
Class class2 = Person.class;

// 获取类的无参构造函数，并实例化
Class clazz = Class.forName("com.yano.reflect.Person");
Constructor c = clazz.getConstructor(null); 
Person p = (Person) c.newInstance(null);

// 获取类的有参构造函数，私有的构造函数，并实例化
Class clazz = Class.forName("com.yano.reflect.Person"); 
Constructor c = clazz .getDeclaredConstructor(new Class[] { String.class }); 
// 由于构造函数是 private 的，所以需要屏蔽Java语言的访问检查 
c.setAccessible(true); 
Person p = (Person) c .newInstance(new Object[] { "I'm a reflect name!" });

// 获取并且调用类的无参方法
Class clazz = Class.forName("com.yano.reflect.Person"); 
Constructor c = clazz.getConstructor(null);
 Person p = (Person) c.newInstance(null);
 Method method = clazz.getMethod("fun", null);
 method.invoke(p, null);

// 获取并且调用类的有参方法
Class clazz = Class.forName("com.yano.reflect.Person"); 
Constructor c = clazz.getConstructor(null); 
Person p = (Person) c.newInstance(null); 
Method method = clazz.getMethod("fun", new Class[] { String.class }); 
method.invoke(p, new Object[] { "I'm a reflect method!" });

// 获取类的字段
Class clazz = Class.forName("com.yano.reflect.Person"); 
Constructor c = clazz .getDeclaredConstructor(new Class[] { String.class }); 
// 由于构造函数是 private 的，所以需要获取控制权限
 c.setAccessible(true); 
Person p = (Person) c .newInstance(new Object[] { "I'm a reflect name!" }); 
Field f = clazz.getField("name");
Object value = f.get(p); 
Class type = f.getType();
System.out.println(type); 
if (type.equals(String.class)) {
 	System.out.println((String) value);
 }


