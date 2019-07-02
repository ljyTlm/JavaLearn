package 常用算法;

public class 数据结构详解 {

    static int num;

    public static void main(String[] args) {
        x(x(8));
        System.out.println(x(8));
    }
    static int x(int n)
    {
        num++;
        if (n <= 3)
            return 1;
        else
            return x(n - 2) + x(n - 4) + 1;
    }
}
/*
    1.广义表的长度和深度
        ( (a, (a,b), ((a, b), c)) )
        长度：1 最大括号中逗号的数目加1
        深度：4 最大括号中每个元素的最大匹配括号数加1
    2.算法的基本要素
        1.数据对象的运算和操作
        2.算法的空值结构






















 */