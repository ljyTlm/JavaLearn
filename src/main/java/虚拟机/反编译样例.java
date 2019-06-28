package 虚拟机;

public class 反编译样例 {
    public static void  main(String[] args) {
//      反编译命令：javap -c xxx.class > xxx.txt
//      生成的文件记录着jvm的每一步操作
//      有个软件叫 VisualVM 可以用来监控jvm的运行
//      下面是 jvm 的 执行 流程图
//      class文件---->类加载器
//                      |
//      堆       栈       本地方法栈
//      元空间    计数器-------->执行引擎
//      堆：new 的对象都存在这里面
//      栈：执行的方法存在这里面
//      本地方法栈： native会表示此方法由jvm解释调用系统库的函数
//      元空间： 存储的是 静态信息和字节码文件 在java8 将元空间从虚拟机内存改为直接内存
//              解决元空间溢出 OOM问题： 申请的空间jvm给不了 自杀了
//      计数器：程序下一次执行的内存地址
//
//      栈原理解释图：
//      ---------------------------
//      |       thread 线程        |
//      |        方法栈            |
//      |     --------------      |
//      |     |  局域变量表  |      |
//      |     |  操作数栈    |     |
//      |     |  动态链接    |     |
//      |     |  方法出口    |     |
//      |     --------------      |
//      |     --------------      |
//      |     |    main    |      |
//      |     |            |      |
//      |     |            |      |
//      |     |            |      |
//      |     --------------      |
//      |-------------------------|
//
//      堆原理解释图：
//      Survivor区  （Survivor幸存） 顾名思义 嘻嘻
//      ---------        ----------        ----------          ----------
//      | Eden  |        |   s0   |        |  s1    |          |   old  |
//      |       | -----> |        | -----> |        | -------> |        |
//      | 伊甸园 |        |   From |        |  To    |          |  老年代 |
//      ---------        ----------        ----------          ----------
//      |                                           |
//      ---------------------------------------------
//                          |
//                        年轻代
//                        Minor                                    Major
//      每一个区满了 就会触发gc
//      gc： （Minor gc） （Major gc）
    }
}
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//        for (int i = 40; i < 40*2; i ++){
//            int v = i*i;
//            String str = v +"";
//            int k = 0;
//            for (int j = 0; j < str.length(); j ++){
//                k += (str.charAt(j)-'0');
//            }
//            System.out.print(k+" ");
//        }
//    }
//}

//--------------------------------------------------------------------

//public class Main {
//    public Main();
//    Code:
//            0: aload_0
//       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//            4: return
//
//    public static void main(java.lang.String[]);
//    Code:
//            0: bipush        40
//            2: istore_1
//       3: iload_1
//       4: bipush        80
//            6: if_icmpge     100
//            9: iload_1
//      10: iload_1
//      11: imul
//      12: istore_2
//      13: new           #2                  // class java/lang/StringBuilder
//              16: dup
//      17: invokespecial #3                  // Method java/lang/StringBuilder."<init>":()V
//            20: iload_2
//      21: invokevirtual #4                  // Method java/lang/StringBuilder.append:(I)Ljava/lang/S
//    tringBuilder;
//      24: ldc           #5                  // String
//            26: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/Str
//    ing;)Ljava/lang/StringBuilder;
//      29: invokevirtual #7                  // Method java/lang/StringBuilder.toString:()Ljava/lang/
//    String;
//      32: astore_3
//      33: iconst_0
//      34: istore        4
//            36: iconst_0
//      37: istore        5
//            39: iload         5
//            41: aload_3
//      42: invokevirtual #8                  // Method java/lang/String.length:()I
//            45: if_icmpge     68
//            48: iload         4
//            50: aload_3
//      51: iload         5
//            53: invokevirtual #9                  // Method java/lang/String.charAt:(I)C
//            56: bipush        48
//            58: isub
//      59: iadd
//      60: istore        4
//            62: iinc          5, 1
//            65: goto          39
//            68: getstatic     #10                 // Field java/lang/System.out:Ljava/io/PrintStream;
//            71: new           #2                  // class java/lang/StringBuilder
//            74: dup
//      75: invokespecial #3                  // Method java/lang/StringBuilder."<init>":()V
//            78: iload         4
//            80: invokevirtual #4                  // Method java/lang/StringBuilder.append:(I)Ljava/lang/S
//    tringBuilder;
//      83: ldc           #11                 // String
//            85: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/Str
//    ing;)Ljava/lang/StringBuilder;
//      88: invokevirtual #7                  // Method java/lang/StringBuilder.toString:()Ljava/lang/
//    String;
//      91: invokevirtual #12                 // Method java/io/PrintStream.print:(Ljava/lang/String;)
//    V
//      94: iinc          1, 1
//            97: goto          3
//            100: return
//}
