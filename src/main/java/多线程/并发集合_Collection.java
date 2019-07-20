package 多线程;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class 并发集合_Collection {
    public static void main(String[] args) {
        List<Object> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        Set<Object> synchronizedSet = Collections.synchronizedSet(new HashSet<>());
        Map<Object, Object> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
        Collection<Object> synchronizedCollection = Collections.synchronizedCollection(new PriorityQueue<>());
        new ConcurrentHashMap<>();
        new ConcurrentLinkedQueue<>();
        new ConcurrentLinkedDeque<>();

    }
}
