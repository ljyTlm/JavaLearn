package 常用算法;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class 页面置换详解 {
    public static void main(String[] args) {
        Cache cache = new CacheTreeMap(2);
        cache.put("1","1");
        cache.put("2", "2");
        cache.get("1");
        cache.put("3", "3");
        System.out.println(cache.get("2"));
        System.out.println(cache.toString());
    }
    interface Cache {
        void put(String key, String val);
        String get(String key);
        void clean();
    }
    static class CacheTreeMap implements Cache{

        Integer size;

        Integer edition;

        TreeMap<Node, String> map;

        public CacheTreeMap(int size) {
            this.size = size;
            edition = 0;
            map = new TreeMap<>();
        }

        public void put(String key, String val) {
            put(new Node(key, edition), val);
        }

        private void put(Node key, String val) {
            if (map.size() == size) clean();
            map.put(key, val);
            edition ++;
        }

        public void clean() {
            map.remove(map.firstKey());
        }

        public String get(String name) {
            Node node = new Node(name, edition);
            String val = map.get(node);
            if (val != null)
                put(node, val);
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
            public int compareTo(@NotNull 页面置换详解.CacheTreeMap.Node o) {
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
    static class CacheHashMap implements Cache{

        HashMap<String, String> map = new HashMap<>();

        Integer size;
        Node head;
        Node end;

        CacheHashMap(Integer size) {
            this.size = size;
        }

        @Override
        public void put(String key, String val) {
            String v = map.get(new Node(key));
            if (v == null) {
                if (map.size() == size) {
                    clean();
                }

            }
        }

        @Override
        public String get(String key) {
            return null;
        }

        @Override
        public void clean() {
            end = end.nex;
            map.remove(end.pre.key);
            end.pre = null;
        }

        static class Node {
            String key;
            Node pre;
            Node nex;

            Node(String key) {
                this.key = key;
            }

            @Override
            public boolean equals(Object obj) {
                return key.equals(obj);
            }

            @Override
            public int hashCode() {
                return key.hashCode();
            }
        }
    }
}
