package 设计模式;

public class 单例模式样例 {

    public static void main(String[] args) {
        Computer computer_1 = Computer.getComputer();
        Computer computer_2 = Computer.getComputer();
        System.out.println(computer_1 == computer_2);
//      1.单例模式是什么？
//        他的生命周期从调用开始一直到程序结束 只会被创建一次 并提供全局访问的方法
//      2.单例模式有什好处
//        主要是解决一个类频繁的创建和销毁
//      3.单例模式的7中写法
//        （1）懒汉写法 线程不安全
            Leader_1 leader1 = Leader_1.getLeader();
//        （2）懒汉写法 线程安全
            Leader_2 leader2 = Leader_2.getLeader();
//        （3）饿汉写法
            Leader_3 leader3 = Leader_3.getLeader();
//        （4）饿汉变种
            Leader_4 leader4 = Leader_4.getLeader();
//        （5）静态内部类
            Leader_5 leader5 = Leader_5.getLeader();
//        （6）枚举 1.5之后的语法
            Leader_6 leader6 = Leader_6.getLeader();
//        （7）双重验证
            Leader_7 leader7 = Leader_7.getLeader();
//          单例模式在设计的过程中要考虑三个问题
//              （1）多线程
//              （2）序列化
//              （3）反射攻击

    }
}
class Computer{
    public static Computer cop = new Computer();
    public static Computer getComputer(){
        return cop;
    }
}
class Leader_1{
    public static Leader_1 leader1;
    public static Leader_1 getLeader(){
        if (leader1 == null) leader1 = new Leader_1();
        return leader1;
    }
}
class Leader_2{
    public static Leader_2 leader2;
    public static synchronized Leader_2 getLeader(){
        if (leader2 == null) leader2 = new Leader_2();
        return leader2;
    }
}
class Leader_3{
    public static Leader_3 leader3 = new Leader_3();
    public static Leader_3 getLeader(){
        return leader3;
    }
}
class Leader_4{
    public static Leader_4 leader4;
    static {
        leader4 = new Leader_4();
    }
    public static Leader_4 getLeader(){
        return leader4;
    }
}
class Leader_5{
    static class Leader{
        public final static Leader_5 leader5 = new Leader_5();
    }
    public static Leader_5 getLeader(){
        return Leader.leader5;
    }
}
enum Leader_6{
    INSTANCE;
    public static Leader_6 getLeader(){
        return INSTANCE;
    }
}
class Leader_7{
    public static Leader_7 leader7;
    public static Leader_7 getLeader(){
        if (leader7 == null){
            synchronized (Leader_7.class){
                if (leader7 == null) leader7 = new Leader_7();
            }
        }
        return leader7;
    }
}