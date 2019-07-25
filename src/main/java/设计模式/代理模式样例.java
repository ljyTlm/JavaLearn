package 设计模式;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class 代理模式样例 {
    public static void main(String[] args) {
//        1.代理模式是什么？
//          在实现类的功能时 他一定要做这个功能
//          但是他自己做这件事情有缺陷或者说他干起来太费劲了、
//          更严重的就是他可能干不成！此时我们希望雇佣一个专业的人士
//          来干我们一定要做的事 那么这个专业人士我们把它叫做代理人
//          我们解决问题的方式就是找代理人-----也就是代理模式
//        2.静态代理
            Man man_1 = new Man();
            FoodProxy proxy = new FoodProxy(man_1);
            proxy.eat();
//          为啥叫静态代理呢？ 因为代理类你必须预先写出来实现接口 然后在编译
//        3.jdk动态代理
            FoodHandler handler = new FoodHandler(man_1, 1);
            Person person_1 = (Person) Proxy.newProxyInstance(man_1.getClass().getClassLoader(), man_1.getClass().getInterfaces(), handler);
            person_1.eat();
            person_1.run();
//        4.cglib动态代理
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Woman.class);
            enhancer.setCallback(new WeightInterceptor());
            Woman proxy_2 = (Woman) enhancer.create();
            proxy_2.eat();
//        5.两种动态代理的差异
//          jdk动态代理 只能代理有接口继承的类 没有接口就束手无策了
//          cglib动态代理 就可以直接对类进行操作 而且性能优秀（asm的包 字节码文件操作工具 短小精悍）
//          Hibernate 和 springAop都使用了cglib动态代理

    }
}
interface Person {
    void eat();
    void run();
}
class Man implements Person {

    public void eat() {
        System.out.println("我想吃米饭！");
    }
    public void run() {
        System.out.println("我正在走路！");
    }
}
class FoodProxy implements Person {

    Person person;

    FoodProxy(Person person){
        this.person = person;
    }

    public void eat() {
        System.out.println("嘿嘿 我到餐馆了 你想吃啥？");
        System.out.println("------------------------");
        person.eat();
        System.out.println("------------------------");
        System.out.println("服务员来两碗米饭！！！！！");
    }

    @Override
    public void run() {

    }
}
class FoodHandler implements InvocationHandler {

    Object obj;

    FoodHandler(Object obj, int a){
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("嘿嘿 我到餐馆了 你想吃啥？");
        System.out.println("------------------------");
        Object o = method.invoke(obj, args);
        System.out.println("------------------------");
        System.out.println("服务员来两碗米饭！！！！！");
        return o;
    }
}
class Woman {
    public void eat(){
        System.out.println("我吃了一桌子菜");
    }
    public void run(){
        System.out.println("我跑了1000米 (＾－＾)V");
    }
}
class WeightInterceptor implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("量体重");
        System.out.println("------------------------");
        Object obj = methodProxy.invokeSuper(o, objects);
        System.out.println("------------------------");
        System.out.println("量体重");
        return obj;
    }
}