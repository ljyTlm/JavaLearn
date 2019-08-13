package 常用算法;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.TreeMap;

public class 页面置换详解 {
    public static void main(String[] args) {
        Cache cache = new Cache(2);
        cache.put("1","1");
        cache.put("2", "2");
        cache.get("1");
        cache.put("3", "3");
        System.out.println(cache.get("2"));
        System.out.println(cache.toString());
    }
    static class Cache {

        Integer size;

        Integer edition;

        TreeMap<Node, String> map;

        public Cache(int size) {
            this.size = size;
            edition = 0;
            map = new TreeMap<>();
        }

        public void put(String key, String val) {
            if (map.size() == size) clean();
            map.put(new Node(key, edition), val);
            edition ++;
        }

        private void clean() {
            map.remove(map.firstKey());
        }

        public String get(String name) {
            String val = map.get(new Node(name, 0));
            if (val != null)
                put(name, val);
            return val;
        }

        static class Node implements Comparable<Node>{
            String key;
            Integer edition;

            public Node(String key, Integer edition) {
                this.key = key;
                this.edition = edition;
            }

            @Override
            public int compareTo(@NotNull 页面置换详解.Cache.Node o) {
                return edition.compareTo(o.edition);
            }

            @Override
            public boolean equals(Object obj) {
                return key.equals(obj);
            }

            @Override
            public int hashCode() {
                return key.hashCode();
            }

            @Override
            public String toString() {
                return key+"  "+edition;
            }
        }

        @Override
        public String toString() {
            String str = "";
            for (Node node: map.keySet()) {
                str += node.toString()+"  "+map.get(node)+"\n";
            }
            return str;
        }
    }
}
