package 集合容器;

import java.util.*;

public class Map样例 {
    public static void main(String[] args) {
//      1.HashMap
        HashMap<String, Integer> hashMap = new HashMap<>();
        Integer integer = hashMap.put("123", 1);
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<String, Integer> entry: entries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        Set<String> strings = hashMap.keySet();
        for(String key: strings) {
            System.out.println(key);
            System.out.println(hashMap.get(key));
        }
        Collection<Integer> values = hashMap.values();
        for(Integer val: values) {
            System.out.println(val);
        }
        System.out.println(hashMap.size());
//      2.LinkedHashMap
        LinkedHashMap<String, Integer>  linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("qwe", 1);
        linkedHashMap.put("asd", 1);
        linkedHashMap.put("zxc", 1);
        for(String key: linkedHashMap.keySet()) {
            System.out.println(key);
        }
//      3.TreeMap
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        String firstKey = treeMap.firstKey();
//      4.Hashtable
//        与HashMap的区别：
//          1.Hashtable是线程安全的 始于1.0版本
//          2.HashMap是线程不安全的 始于1.2版本
//          3.HashMap可以key是null、value是null
//          4.Hashtable不可以存储null键和null值
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("123", 3);
//       // Make sure the value is not null
//        if (value == null) {
//            throw new NullPointerException();
//        }
//
//        // Makes sure the key is not already in the hashtable.
//        Entry<?,?> tab[] = table;
//        int hash = key.hashCode();
//      在hashtable中源码已经写得很详细了 值当然不能为null
//      key也不能为null 不然 key.hashCode() 程序直接就崩掉了
//      HashMap中键的值为null时 实际上在源码中HashMap判断如果key为null则hash值为0
    }
}
