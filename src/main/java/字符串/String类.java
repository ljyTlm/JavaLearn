package 字符串;

public class String类 {
    public static void main(String[] args) {
//        1.String类的创建方式
            String a = new String("testA");
            byte [] bytes = {98, 99, 100};
//          通过使用平台的默认字符集解码指定的byte数组
            String b = new String(bytes);
            char [] chars = {'a', 'b', 'c'};
            String c = new String(chars);
            System.out.println(c);
//        2.String常量池
            String d = "abc";
            String e = "abc";
            System.out.println(d == e);
            System.out.println(d.equals(e));
//          在直接赋值字符串的过程中 先去常量池里里面扫描 没有就创建一个 有的话直接返回地址
            String f = new String("qwe");
            String g = new String("qwe");
            String h = "qwe";
            System.out.println(f == g);
            System.out.println(f.equals(g));
            System.out.println(g == h);
//          字符串在使用new关键字创建的时候 如果常量池没有这个字符序列 那么会创建两个对象
//          一个在堆内存 一个在常量池中
            String i = "a"+"b"+"c";
            String j = "abc";
            System.out.println(i == j);
//          java中有常量优化机制 "a"+"b"+"c" 优化--> "abc" 所以为true
            String k = "ab";
            String l = k+"c";
            String m = "abc";
            System.out.println(l == m);
//          ”常量优化机制“ k属于变量 会自动新生成一个对象StringBuffer 然后
//          通过append方法 和 toString方法 在堆中生成一个新的String对象 然后返回地址
            String n = "a"+'b';
            String o = "ab";
            System.out.println(n == o);
//          经过测试常量字符是好使的 结果为true
//          3.String常用方法
            String p = "abc";
            String q = "ABC";
            System.out.println(p.equals(p.equals(q)));
            System.out.println(p.equalsIgnoreCase(q));
            System.out.println(p.endsWith("c"));
            System.out.println(p.startsWith("a"));
            System.out.println(p.contains(q));
            System.out.println(p.substring(1));
            System.out.println(p.concat(q));
            System.out.println(p.getBytes());
            char[] chars1 = p.toCharArray();
            String.valueOf(1);
            String.valueOf(chars1);
//          嘿嘿 撸一个kmp算法吧
            String r = "ppcdfjaksdjfnagasdkjfalk";
            String s = "dfjaksdjf";
            int idx = kmp(r, s);
            System.out.println(idx);
    }

        private static int kmp(String r, String s) {
            int [] next = getNext(s);
            int i = 0;
            int j = 0;
            while (i < r.length() && j < s.length()){
                    if (j == -1 || r.charAt(i) == s.charAt(j)){
                            i++;
                            j++;
                    }else {
                            j = next[j];
                    }
                    if(j == s.length()) return i-j;
            }
            return -1;
        }

        private static int[] getNext(String s) {
            int [] next = new int [s.length()+1];
            next[0] = -1;
            int idx = -1;
            int i = 0;
            while (i < s.length()){
                    if (idx == -1 || s.charAt(idx) == s.charAt(i)){
                            idx ++;
                            i ++;
                            next[i] = idx;
                    }else {
                            idx = next[idx];
                    }
            }
            return next;
        }
}
/*
    1.String是什么基础数据嘛？ 他在那个包下？
        String不是基础数据类型，他在java.lang包下
    2.讲讲String的创建方式
        String有两种创建方式 一种是new 一种引号 推荐使用引号
    3.String不可变有什么好处？
        （1）在多线程环境下是安全的
        （2）在不可变的基础上构建 字符串池节约空间防止相同的字符串频繁的大量创建
    4.什么是字符串池？
        在java内存堆中有一个空间用来存储字符串
        需要注意的是new出来的字符串不仅会在池中创建
        还会在堆内存中创建 创建两次
    5.为什么使用HashMap的时候推荐使用string做key
        因为字符串的hashcode执行一次之后就会被缓存
        不会再重新创建
    6.下面这段代码创建了几个对象？
        String s1 = "Java";
        String s2 = "从0到1";
        String s3 = s1 + s2;
        String s4 = "Java从0到1";

        System.out.println(s3 == s4);
        正确答案6个对象 因为像s1 s2这类的引用无法预先得知
        所以执行的时候会复制s1 s2 s3是新生成的 结果为false
     7.String类能被继承嘛？
        不能 String类的修饰符是 final

 */