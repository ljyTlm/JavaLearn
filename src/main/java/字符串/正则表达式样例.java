package 字符串;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 正则表达式样例 {
    public static void main(String[] args) {
//      1.样例需求
//      （1）必须是5-15位数字
//      （2）0不能开头
//      （3）必须都是数字
//      []代表单个字符规则
//          [abc]代表字母可以是a、b、c
//          [^abc]代表除了字母abc
//          [a-cA-C]并集
//          [a-c[A-C]]并集
//          [a-c&&[b]]交集
//      \代表单个字符规则
//          \d 代表 数字
//          \D 代表 非数字
//          \s 代表 空白字符
//          \S 代表 非空白字符
//          \w 代表 单词字符
//          \W 代表 非单词字符
//      ? 代表 数量词
//          X? 代表 问号前面的集合 出现一次或一次都没有
//          注意 一直都没有 指的是空字符串 没有也不能出现其他字符
//      * 同上
//          X* 代表 出现任意次
//      + 同上
//          X+ 代表 大于等于一次
//      {}同上
//          X{n} 代表 恰好出现n次
//          X{n,}代表 至少n次
//          X{n,m}代表 至少n次 但是不超过m次
        String str_1 = "647162381";
        String result = "[64]";
        System.out.println(str_1.matches(result));
//      字符串拆分
        String str_2 = "asdaafa adfaasdf sdaafa fsdafaa";
        String[] split_1 = str_2.split("[ ]");
        System.out.println(Arrays.toString(split_1));
        String[] split_2 = str_2.split("[a]");
        System.out.println(Arrays.toString(split_2));
        String[] split_3 = str_2.split("[f][a]");
        System.out.println(Arrays.toString(split_3));
        String[] split_4 = str_2.split("[a]{2}");
        System.out.println(Arrays.toString(split_4));
        String[] split_5 = str_2.split("[a-d]");
        System.out.println(Arrays.toString(split_5));
//      字符串替换
        String str_3 = "wer2asdfasd34asfasdf4dfasd4";
        String str_4 = str_3.replaceAll("\\d", "*");
        System.out.println(str_4);
        String str_5 = "wer2asdfasd34asfasdf4dfasd4";
        String str_6 = str_5.replaceAll("[0-9][a-z]", "*");
        System.out.println(str_6);
//      正则表达式分组功能
        String str_7 = "aabb";
        System.out.println(str_7.matches("(.){2}(.){2}"));
        String str_8 = "ababab";
        System.out.println(str_8.matches("(..){3}"));
        String str_9 = "ababab";
        System.out.println(str_9.matches("([a][^0-9]){3}"));
        String str_10 = "ababab";
        System.out.println(str_10.matches("([a][^0-9])+"));
//      即时练习！！！
        String str_11 = "我我....我...我.要...要学....学学..学.编..编编.编.程.程.程..程";
//      目标：我要学编程
        String regex_1 = "(.\\.+)";
        System.out.println(str_11.replaceAll(regex_1, ""));
//      Pattern类的使用
//        这个类类似于预编译正则表达式 并且具备
//        此类的实例是不可变的，可供多个并发线程安全使用。Matcher 类的实例用于此目的则不安全。
        Pattern pattern_1 = Pattern.compile("[a-z]");
        Matcher matcher_1 = pattern_1.matcher("a");
        System.out.println(matcher_1.matches());
//      小练习：获取手机号码
        String str_12 = "wodeshouji hao17645479673bangbuang hhh15776547718 ";
        Pattern pattern_2 = Pattern.compile("[0-9]{11}");
        Matcher matcher_2 = pattern_2.matcher(str_12);
        while (matcher_2.find()){
            System.out.println(matcher_2.group());
        }
    }
}
