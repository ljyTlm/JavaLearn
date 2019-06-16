package 异常;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.Executors;

public class 异常样例 {
    public static void main(String[] args) {
//      1.java中的异常分两大类
//        Throwable 是所有异常的超类
//       （1）Error
//       （2）Exception
//      2.Exception
//        （1）IO
//        （2）SQL
//        （3）Runtime 运行时异常 我们程序员自身犯的错误
//      3.异常有两种处理方式
//        （1）自己手动处理 然后继续运行
//        （2）交给jvm处理 jvm会将异常信息打印在控制台 然后终止程序
//        System.out.println(9/0);
//      4.手动处理异常 try catch finally 代码块
//        （1）try 检测异常
//        （2）catch 捕获异常
//        （3）finally 无论怎么样都执行的代码块 主要作用释放资源
        try {
            System.out.println(9/0);
        }catch (RuntimeException e){
            System.out.println("除0了。。。。");
        }
//      5.多异常处理
        try {
            String s = null;
            System.out.println((9/0)+s.toString());
        }/*catch (Exception e){

        }*/catch (NullPointerException e){
            System.out.println("空指针异常");
        }catch (ArithmeticException e){
            System.out.println("除0了");
        }
//          （1）多异常在处理时 每个都抛一遍 因为你不确定那行代码出错
//          （2）catch代码接受异常时 他的底下不能有他的子类 不然什么异常都被他捕获 就没意义了
//      6.jdk1.7异常新特性
        try {
            String s = null;
            System.out.println((9/0)+s.toString());
        }/*catch (Exception e){

        }*/catch (NullPointerException | ArithmeticException e){
            System.out.println("空指针异常");
        }
//      7.编译时异常
        try {
            FileInputStream file = new FileInputStream("xxx.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//      编译时的异常原因可能不在你的身上 但是一旦发生了就很致命 你需要告诉程序一旦发生了他该怎么做
//      提前做好准备 保证程序的健壮性
//      8.了解Throwable类
        try {
            System.out.println(9/0);
        }catch (Exception e){
            System.out.println(e.getMessage());
//          获取异常提示
            System.out.println(e.toString());
//          返回类名和异常信息  java.lang.ArithmeticException: / by zero
            e.printStackTrace();
//          jvm默认就用这种方式
        }
//      9.抛给调用者处理异常 throw throws
        try {
            int val = getVal(-1);
        }catch (Exception e){
            System.out.println("编译时异常 不处理无法通过编译");
        }
        try {
            String vla = getStr(-1);
        }catch (RuntimeException e){
            e.printStackTrace();
            System.out.println("运行时异常 方法可以不用throws 编译可以通过");
        }
//      10.throw 和 throws的区别
//        throw：需要把出现的问题交给调用者处理 可用throw关键字 只能在方法体内抛出一个异常
//        throws：用在方法声明后 后面是异常的类名 写多个时 用逗号隔开
//      11.finally 关键字
        FileInputStream file = null;
        try {
            file = new FileInputStream("xxx.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//      finally里面的代码体 一定会执行 只有jvm终止了才会不执行 System.exit(0)
//      千万不要在finally里面写return语句没有意义
    }

    private static String getStr(int i) {
        if (i > 0) return "1";
        else
            throw new RuntimeException("数值不能为负数");
    }

    private static int getVal(int i) throws Exception{
        if (i > 0) return 1;
        else
            throw new Exception("数值不能为负数");
    }
}
