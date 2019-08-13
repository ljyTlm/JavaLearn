package 常用算法;

import java.util.Arrays;

import static 常用算法.第K大快排写法.shuffle;

public class 第K大二叉排序树写法 {
    public static void main(String[] args) {
        Integer [] arr = new Integer[20];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i+1;
        }
        shuffle(arr);
        System.out.println(Arrays.toString(arr));
        Node head = new Node();
        for (int i = 0; i < arr.length; i ++) {
            insert(head, arr[i]);
        }
        System.out.println(find(head, 5));
    }

    private static int find(Node node, int k) {
        System.out.println(node.val);
        if (node.left.num+1 == k)
            return node.val;
        if (node.left.num >= k )
            return find(node.left, k);
        return find(node.right, k-node.left.num-1);
    }

    private static void insert(Node node, Integer val) {
        if (node.val == null) {
            node.val = val;
            node.num = 1;
            node.left = new Node();
            node.right = new Node();
            return;
        }
        node.num ++;
        if (node.val > val) {
            insert(node.left, val);
        }else {
            insert(node.right, val);
        }
    }

    static class Node {
        Integer val;
        int num;
        Node left;
        Node right;
        Node() {
            num = 0;
        }
    }
}
