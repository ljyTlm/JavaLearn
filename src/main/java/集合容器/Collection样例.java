package 集合容器;

import java.util.*;

public class Collection样例 {
    public static void main(String[] args) {
//      集合里的知识点第一个就是迭代器：iterator
//      1.iterator简述
//        提供遍历结合的方法
//      2.iterator的意义
//        因为每个集合的存 和 取 都是不一样的 每个集合都要有专属的遍历方法
//        而使用iterator 一是封装操作 不用关心底层实现 二是规范遍历方式 解耦
//      3.iterator的注意事项
//        remove方法需要配合hasNext方法使用 移除的是最后一个被遍历过的元素
//        遍历结合对象 隐藏内部实现
//        在迭代的过程中如果对原集合进行修改和删除操作 此时会抛出异常
//      4.ArrayList 线程不安全 底层数组实现
        ArrayList<String> list = new ArrayList<>();
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.add("asdf");
            iterator.remove();
        }
//      5.vector 已经基本不用了
//        1.vector是线程安全的 效率低
//        2.vector空间满了扩容一倍
//        3.vector分配空间的时候需要连续存储空间 如果数据太多容易分配内存失败
//        4.只能在尾部进行插入和删除操作，效率低
//      6.LinkedList 底层链表实现 增删较快 查改较慢 线程不安全
    }
}

class MyCollection<T extends Comparable<? super T>> implements Collection {

    private T [] arr;

    private int size;

    MyCollection() {
        this(100);
    }

    MyCollection(int len) {
        arr = (T [])new Object[len];
        size = 0;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        int idx = indexOf(o);
        return idx >= 0;
    }

    private int indexOf(Object o) {
        T v = (T)o;
        for(int i = 0; i < size; i ++) {
            if(arr[i].compareTo(v) == 0) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int idx;

            @Override
            public boolean hasNext() {
                return idx < size;
            }

            @Override
            public T next() {
                return arr[idx++];
            }

            @Override
            public void remove() {
                for(int i = idx-1; i < size-1; i ++) {
                    arr[i] = arr[i+1];
                }
            }
        };
        return it;
    }

    @Override
    public Object[] toArray() {
        Object [] objects = new Object[size];
        for (int i = 0; i < size; i ++) {
            objects[i] = arr[i];
        }
        return objects;
    }

    @Override
    public boolean add(Object o) {
        if (size == arr.length) {
            T [] val = (T [])new Object[arr.length+arr.length/2];
            for(int i = 0; i < size; i ++) {
                val[i] = arr[i];
            }
            arr = val;
        }
        arr[size++] = (T)o;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int idx = indexOf(o);
        if (idx == -1) return false;
        for(int i = idx; i < size-1; i ++) {
            arr[i] = arr[i+1];
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        Iterator iterator = c.iterator();
        while (iterator.hasNext()) {
            add(iterator.hasNext());
        }
        return true;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}