package 常用算法;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class 单链表样例 {
    public static void main(String[] args) {
        SingList list = new SingList();
        list.add("dsafas");
        list.add("qqqqq");
        list.add("wwwww");
        list.add("rrrrrr");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
class SingList implements List {

    private Node head;

    private Node end;

    private int size;

    SingList() {
        head = end = new Node();
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

    @Override
    public Iterator iterator() {
        Iterator it = new Iterator() {

            Node now = head;

            int idx;

            @Override
            public boolean hasNext() {
                return idx < size;
            }

            @Override
            public Object next() {
                now = now.next;
                idx ++;
                return now.val;
            }

            @Override
            public void remove() {

            }
        };
        return it;
    }

    @Override
    public Object[] toArray() {
        Object [] val = new Object[size];
        int idx = 0;
        Node now = head;
        while (idx < size) {
            val[idx++] = now.next.val;
            now = now.next;
        }
        return val;
    }

    @Override
    public boolean add(Object o) {
        end.next = new Node(o);
        size ++;
        end = end.next;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        Node now = head;
        int idx = 0;
        while (now.next != null) {
            if(now.next.val.equals(o)) {
                return idx;
            }
            idx ++;
            now = now.next;
        }
        return idx;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
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


    class Node {

        Node next;

        Object val;

        Node() {

        }

        Node(Object e) {
            val = e;
        }
    }
}