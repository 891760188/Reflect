package ye.guo.huang.test03;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

    /**
     * ���䣺��������ֽ���
     * 
     * @throws SecurityException
     * @throws NoSuchMethodException
     */
    public static void main(String[] args) throws Exception {

        refGetClass();

        // ��ȡ�������޲ι��캯��
        refGetPublicConstructor();

        // ��ȡ������˽�еĺ��ι��캯��
        refGetPrivateConstructor();

        // ��ȡ�������޲η��� fun
        refGetMethodWithNoArg();

        // ��ȡ�������в������� fun
        refGetMethodWithArg();

        // ��ȡ����ֶ�
        refGetField();
    }

    private static void refGetField() throws Exception {

        Class clazz = Class.forName("com.yano.reflect.Person");
        Constructor c = clazz
                .getDeclaredConstructor(new Class[] { String.class });
        // ���ڹ��캯���� private �ģ�������Ҫ��ȡ����Ȩ��
        c.setAccessible(true);
        Person p = (Person) c
                .newInstance(new Object[] { "I'm a reflect name!" });

        Field f = clazz.getField("name");
        Object value = f.get(p);
        Class type = f.getType();
        System.out.println(type);

        if (type.equals(String.class)) {
            System.out.println((String) value);
        }
        System.out.println();
    }

    private static void refGetMethodWithArg() throws Exception {

        Class clazz = Class.forName("com.yano.reflect.Person");
        Constructor c = clazz.getConstructor(null);
        Person p = (Person) c.newInstance(null);

        Method method = clazz.getMethod("fun", new Class[] { String.class });
        method.invoke(p, new Object[] { "I'm a reflect method!" });
        System.out.println();
    }

    private static void refGetMethodWithNoArg() throws Exception {

        Class clazz = Class.forName("com.yano.reflect.Person");
        Constructor c = clazz.getConstructor(null);
        Person p = (Person) c.newInstance(null);

        Method method = clazz.getMethod("fun", null);
        method.invoke(p, null);
        System.out.println();
    }

    private static void refGetPrivateConstructor() throws Exception {

        Class clazz = Class.forName("com.yano.reflect.Person");
        Constructor c = clazz
                .getDeclaredConstructor(new Class[] { String.class });

        // ���ڹ��캯���� private �ģ�������Ҫ����Java���Եķ��ʼ��
        c.setAccessible(true);

        Person p = (Person) c
                .newInstance(new Object[] { "I'm a reflect name!" });
        System.out.println();
    }

    private static void refGetPublicConstructor() throws Exception {

        Class clazz = Class.forName("com.yano.reflect.Person");
        Constructor c = clazz.getConstructor(null);

        Person p = (Person) c.newInstance(null);
        System.out.println();
    }

    private static void refGetClass() throws ClassNotFoundException {
        // �������3�ַ���
        Class clazz = Class.forName("com.yano.reflect.Person");
        Class clazz1 = new Person().getClass();
        Class class2 = Person.class;
        System.out.println();
    }

}
