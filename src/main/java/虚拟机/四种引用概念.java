package 虚拟机;

import java.lang.ref.*;

public class 四种引用概念 {
    public static void main(String[] args) {
//      1.强引用
        Integer a = new Integer(999);
//      垃圾回收器永远不会回收的的对象
//      2.软引用
        Integer b = new Integer(999);
        SoftReference softReference = new SoftReference(b);
//      将b的引用给SoftReference 这个类转为软引用
//      有用但是不是必用 空间够不回收 空间不够先回收
        b = null;
//      消除对象的强引用
//      3.弱引用
        Integer c = new Integer(999);
        WeakReference weakReference = new WeakReference(c);
//      跟软引用一样 区别是活不过下次回收
        c = null;
//      4.虚引用
        Integer d = new Integer(999);
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference phantomReference = new PhantomReference(d, queue);
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    Object obj = queue.poll();
                    if (obj != null) {
                        System.out.println("说明此时对象被放到了队列中");
                    }
                }
            }
        }.start();
//      虚引用 不会造成对象复活 我们可以监听队列的情况判断对象是否死亡

    }
}
