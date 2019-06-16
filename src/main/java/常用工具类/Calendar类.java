package 常用工具类;

import java.util.Calendar;

public class Calendar类 {
    public static void main(String[] args) {
//        此类是一个抽象类
        Calendar calendar_1 = Calendar.getInstance();
        int year_1 = calendar_1.get(Calendar.YEAR);
        System.out.println(year_1);
        int month_1 = calendar_1.get(Calendar.MONTH);
        System.out.println(month_1);
//        注意“月”是从0开始编号的
        int day_1 = calendar_1.get(Calendar.DAY_OF_MONTH);
        System.out.println(day_1);
        System.out.println(calendar_1.get(Calendar.DAY_OF_WEEK));
//        注意“星期几”周日是第一天！！！！
//      类中的add方法 提供了 对各个字段的操作 整数+ 负数-
        calendar_1.add(Calendar.YEAR, 10);
        System.out.println(calendar_1.get(Calendar.YEAR));
//      类中的set方法 提供了 对各个字段的修改操作
        calendar_1.set(Calendar.YEAR, 2000);
        System.out.println(calendar_1.get(Calendar.YEAR));
//      小练习: 通过这个类判断任意一年是否为闰年?
        Calendar calendar_2 = Calendar.getInstance();
        calendar_2.set(2019, 2, 1);
        calendar_2.add(Calendar.DAY_OF_MONTH, -1);
        System.out.println(calendar_2.get(Calendar.DAY_OF_MONTH));
        if(calendar_2.get(Calendar.DAY_OF_MONTH) == 28)
            System.out.println("当前不是闰年");
        else
            System.out.println("当前是闰年！");
    }
}
