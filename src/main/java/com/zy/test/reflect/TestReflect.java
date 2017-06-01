package com.zy.test.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;
public class TestReflect  implements Serializable{
	/**
	 * 通过一个对象获得完整的包名和类名
	 */
//    public static void main(String[] args) throws Exception {
//        TestReflect testReflect = new TestReflect();
//        System.out.println(testReflect.getClass().getName());
//        // 结果 net.xsoftlab.baike.TestReflect
//    }

/**
 * 实例化Class类对象
 */

//	 public static void main(String[] args) throws Exception {
//	        Class<?> class1 = null;
//	        Class<?> class2 = null;
//	        Class<?> class3 = null;
//	        // 一般采用这种形式
//	        class1 = Class.forName("com.zy.test.reflect.TestReflect");//类加载
//	        class2 = new TestReflect().getClass();//获得类
//	        class3 = TestReflect.class;
//	        System.out.println("类名称   " + class1.getName());
//	        System.out.println("类名称   " + class2.getName());
//	        System.out.println("类名称   " + class3.getName());
//	    }
	
	/**
	 * 获取一个对象的父类与实现的接口
	 */
//public static void main(String[] args) {
//	try {
//		Class<?> clazz=Class.forName("com.zy.test.reflect.TestReflect");
//		Class<?> parentClass=clazz.getSuperclass();
//		System.out.println(parentClass.getName());
//		Class<?> intes[]=clazz.getInterfaces();//获得接口
//		for (Class<?> class1 : intes) {
//			System.err.println(class1.getName());
//		}
//	} catch (ClassNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
	
//}
	
	/**
	 * 通过反射操作某个类方法
	 * 
	 */
//	public static void main(String[] args) throws Exception {
//        Class<?> clazz = Class.forName("com.zy.test.reflect.TestReflect");
//        // 调用TestReflect类中的reflect1方法
//        Method method = clazz.getMethod("reflect1");
//        method.invoke(clazz.newInstance());
//        // Java 反射机制 - 调用某个类的方法1.
//        // 调用TestReflect的reflect2方法
//        method = clazz.getMethod("reflect2", int.class, String.class);
//        method.invoke(clazz.newInstance(), 20, "张三");
//        // Java 反射机制 - 调用某个类的方法2.
//        // age -> 20. name -> 张三
//    }
//    public void reflect1() {
//        System.out.println("Java 反射机制 - 调用某个类的方法1.");
//    }
//    public void reflect2(int age, String name) {
//        System.out.println("Java 反射机制 - 调用某个类的方法2.");
//        System.out.println("age -> " + age + ". name -> " + name);
//    }
	
	/**
	 * 通过反射操作某个类的属性
	 */
//	  private String proprety = null;
//	    public static void main(String[] args) throws Exception {
//	        Class<?> clazz = Class.forName("com.zy.test.reflect.TestReflect");
//	        Object obj = clazz.newInstance();
//	        // 可以直接对 private 的属性赋值
//	        Field field = clazz.getDeclaredField("proprety");
//	        field.setAccessible(true);
//	        field.set(obj, "Java反射机制");
//	        System.out.println(field.get(obj));
//	    }
	/**
	 * 在java中有三种类类加载器。
	 * 
	 * 1）Bootstrap ClassLoader 此加载器采用c++编写，一般开发中很少见。
	 * 
	 * 2）Extension ClassLoader 用来进行扩展类的加载，一般对应的是jrelibext目录中的类
	 * 
	 * 3）AppClassLoader 加载classpath指定的类，是最常用的加载器。同时也是java中默认的加载器。
	 * 
	 * 如果想要完成动态代理，首先需要定义一个InvocationHandler接口的子类，已完成代理的具体操作。
	 * 
	 * @author xsoftlab.net
	 * 
	 */

//	public static void main(String[] args) throws Exception {
//        MyInvocationHandler demo = new MyInvocationHandler();
//        Subject sub = (Subject) demo.bind(new RealSubject());
//        String info = sub.say("Rollen", 20);
//        System.out.println(info);
//    }
//	
//}
//
//
////定义项目接口
//interface Subject {
//    public String say(String name, int age);
//}
//// 定义真实项目
//class RealSubject implements Subject {
//    public String say(String name, int age) {
//        return name + "  " + age;
//    }
//}
//class MyInvocationHandler implements InvocationHandler {
//    private Object obj = null;
//    public Object bind(Object obj) {
//        this.obj = obj;
//        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
//    }
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        Object temp = method.invoke(this.obj, args);
//        return temp;
//    }

	public static void main(String[] args) throws Exception {

	
        fruit f = Factory.getInstance("com.zy.test.reflect.Apple");
        if (f != null) {
            f.eat();
           
        }
       
    }
	
	
}
interface fruit {
    public abstract void eat();
}
class Apple implements fruit {
    public void eat() {
        System.out.println("Apple");
    }
	public String  getString()
	{
		Properties p = new Properties();
		InputStream inputStream = this.getClass().getClassLoader()
		       .getResourceAsStream("/config/application.properties");
		  
		try {
			p.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p.getProperty("server.port");
	}
}
class Orange implements fruit {
    public void eat() {
        System.out.println("Orange");
    }
}
class Factory {
    public static fruit getInstance(String ClassName) {
        fruit f = null;
        try {
            f = (fruit) Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
