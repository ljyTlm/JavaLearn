package 反射;

import java.lang.reflect.Method;

public class 反射样例 {
    public static void main(String[] args) throws Exception{
//        反射的基础：Class类
//        Class是什么？
//          Class类相当于一个类的详细描述 就好比一个人想知道自己的眼睛长什么样
//          而自己的眼睛是看不到自己的眼睛的 所以我们需要借助点东西 比如镜子 此时
//          Class类就是Java中所有类的镜子 镜子里的内容就是照镜子的类的所有描述
//          现在你应该知道 java的这种机制为什么叫反射了吧
//        知识点：
//          1.对于每个类而言，jre都为其保留了一个不变的class对象
//          2.class对象只能由系统创建，在JVM中只会有一个Class实例
            Test_1 a = new Test_1();
            Test_1 b = new Test_1();
            System.out.println(a.getClass() == b.getClass());
//          输出是true
//        首先我们已经了解了Clas类 那么接下来我来利用Class类演示反射
//          1.获取Class有三种方式
                Class cla_1 = Test_1.class;
                Class cla_2 = new Test_1().getClass();
                Class cla_3 = Class.forName("反射.Test_1");
//          2.Class类提供了那些方法？
                Object obj = cla_1.newInstance();
                Test_1 t_1 = (Test_1)obj;
                t_1.setName("设置名字");
                System.out.println(t_1.getName());
//              function: newInstance() 返回此类型的一个实例化对象 
        
                Method setName_1 = cla_1.getMethod("setName", new Class[]{String.class});
                setName_1.invoke(obj, "123");
                Method getName_1 = cla_1.getMethod("getName");
                System.out.println(getName_1.invoke(obj));
//              function: getMethod(name, Class) 获取指定名称和参数的方法 
//              注意两个坑点：1.只能获取public修饰的方法 2.当参数为基础数据类型 那么得是包装类才行 或者传int.class

                Method setName_2 = cla_1.getDeclaredMethod("setName", String.class);
                setName_2.setAccessible(true);
                setName_2.invoke(obj, "111");
//              function: getDeclaredMethod(name, Class) 也是获取方法可以获取所有的方法
//              一个坑点：在调用private修饰的方法时 得先使用setAccessible(true)详细的解释

                Method setName_3 = cla_1.getMethod("setName", String.class);
                setName_3.setAccessible(true);
//              function: setAccessible(bool) 作用就是可以访问私有的成员
//              一个坑点：是概念上的坑点 这个方法不是把变量的修饰符给改了 而是取消java对private关键字的检查

                Method setName_4 = cla_1.getMethod("setName", String.class);
                setName_4.invoke(obj, "test");
//              function: invoke(Obj, args..) 调用指定类的这个方法



    }
}
class Test_1{
    String name;
    protected void setName(String name){
        this.name = name;
    }
    protected String getName(){
        return name;
    }
}