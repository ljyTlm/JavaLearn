package 内部类;

public class 成员内部类样例 {

    private String a_1;
    public static Integer a_2;

    void show(){
        Node node = new Node();
        node.print(); //示例3
        //知识点：外部类访问内部类的方法和变量 就没那么简单了 得实例化对象
    }

    static void see(){
//        Node node = new Node(); 知识点：静态方法内实例化内部类 内部类必须为静态
    }

    //最普通的内部类
    //知识点：成员内部类可以无条件的访问外部类的方法和变量 包括private 和 static 变量
    //知识点：静态内部类只能访问外部类的静态变量
    class Node {

        Integer a_2; //知识点：当这两个类变量名相同时 会发生隐藏现象 默认调用本类的变量

        void print(){
            System.out.println(a_1); //示例1
            System.out.println(a_2);
            //知识点：如果想调用外部类的变量 得写成如下形式 类名.this.变量名或方法名
            System.out.println(成员内部类样例.this.a_2); //示例2
        }

//        static void show(){
//          知识点：内部类是不允许创建静态方法和变量 而静态内部类是可以的
//        }
    }

    /* 知识点总结：
            1.外部类访问内部类的方法和变量 就没那么简单了 得实例化对象
            2.外部类静态方法内实例化内部类 内部类必须为静态
            3.成员内部类可以无条件的访问外部类的方法和变量 包括private 和 static 变量
            4.静态内部类只能访问外部类的静态变量
            5.当这两个类变量名相同时 会发生隐藏现象 默认调用本类的变量
            6.如果想调用外部类的变量 得写成如下形式 类名.this.变量名或方法名
            7.内部类是不允许创建静态方法和变量 而静态内部类是可以的
     */
}
