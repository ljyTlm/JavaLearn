package 集合容器.实现类底层解析;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMap详解 {

    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        map.put(1, 1);
        map.get(1);
    }
}
/**
 *      1.在1.8版本中添加key value 首先是先进行一次cas操作 如果失败则使用synchronized加锁
 *      之后的操作跟正常的HashMap一样
 *
 *      2.get操作不加锁 不可以插入null值
 *
 *
 * */