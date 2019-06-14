package 初始化和清理;

public class 垃圾清理样例 {
    public static void main(String[] args) {
        //引言：java引入了垃圾回收机制 解决了令人头疼的内存管理
//        垃圾回收算法的两件事：
//               1.发现无用信息对象
//               2.回收被无用对象占用的内存空间，使该空间可被程序再次使用。
//        java的Gc(自动回收机制)只负责内存的相关清理 其他资源必须有程序员手动回收 例如调用close等方法
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        //知识点：这个方法用于对象销毁 只是不太靠谱 java语言规范并不能保证这个
        // 方法会被及时的执行 而且根本不会保证他会不会执行
    }
}
