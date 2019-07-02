package 设计模式;

import java.util.ArrayList;
import java.util.List;

public class 观察者模式样例 {
    public static void main(String[] args) {
//      1.观察者模式概述
//        先提一个问题：假设当前类的成员是一个对象 这个对象不知道什么时候会被改变
//        当对象改变时 我的一些值需要根据这个对象重新计算 或者 这个对象改变时 我要
//        做出一个动作 嘿嘿 像不像监听事件
//        了解了上述问题 那么观察者模式就是为了解决这个问题
//      2.观察者要素
//        1.被观察者
//        2.观察者接口 观察者抽象类
//        3.观察者
//      3.模式原理 实际上就是在观察者内部持久保存每一个观察者 当自身改变时就通知所有的观察者
        Page page = new Page();
        Img img = new Img(page);
        System.out.println(img.status);
        page.setStatus("我现在是半屏");
        System.out.println(img.status);
    }
}

interface Observer {
    void updata();
}

/**
 * 被观察者 这个一个页面
 */
class Page {

    String status;

    List<Observer> observers;

    Page() {
        status = "我现在是全屏";
        observers = new ArrayList<>();
    }

    void setStatus(String status) {
        this.status = status;
        notice();
    }

    void notice() {
        for (Observer observer: observers) {
            observer.updata();
        }
    }

    public void add(Observer observer) {
        observers.add(observer);
    }
}

class Img implements Observer{

    String status;

    Page page;

    Img() {}

    Img(Page page) {
        this.page = page;
        page.add(this);
        updata();
    }

    @Override
    public void updata() {
        status = page.status+"图片";
    }
}