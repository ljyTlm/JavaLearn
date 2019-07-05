package 设计模式;

public class 回调模式样例 {
    public static void main(String[] args) {
//      1.回调模式是实现异步的重要手段
//      2.回调模式要素
//        （1）请求者
//        （2）响应者
//        （3）响应接口（抽象类）
        Thread thread = new Thread(new Answer("太阳为啥是圆的", new Res() {
            @Override
            public void doSomeing() {
                System.out.println("好的， 谢谢您嘞~~");
            }
        }));
        thread.start();
        for (int i = 0; i < 10; i ++) {
            System.out.println("我正在拔草~~~");
        }
    }
}

interface Res {
    void doSomeing();
}

class Answer implements Runnable{

    Res res;

    String problem;

    Answer() {}

    Answer(String problem, Res res) {
        this.problem = problem;
        this.res = res;
    }

    @Override
    public void run() {
        System.out.println("我听你的问题是："+problem);
        System.out.println("你让我找一会，你先干别的吧");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("你的问题我解决了，现在我按照之前的约定调用方法");
        res.doSomeing();
    }
}