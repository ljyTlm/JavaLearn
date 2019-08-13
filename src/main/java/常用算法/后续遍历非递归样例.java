package 常用算法;

import java.util.Stack;


public class 后续遍历非递归样例 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.left.right.right = new Node(8);
        Stack<Node> stack = new Stack<>();
        Stack<Integer> flag = new Stack<Integer>();
        stack.push(head);
        flag.push(2);
        while (!stack.isEmpty()) {
            while (true) {
                Node node = stack.peek();

                if (node.right != null){
                    stack.push(node.right);
                    flag.push(1);
                }

                if (node.left != null){
                    stack.push(node.left);
                    flag.push(0);
                }

                node = stack.peek();
                if (node.left == null && node.right == null)
                    break;
            }
            Node last = null;
            while (true) {
                Node node = stack.peek();
                Integer v = flag.peek();
                if (v == 0) {
                    last = stack.pop();
                    System.out.print(last.val+" ");
                    flag.pop();
                }else if (v == 1) {
                    if (last == stack.peek().left || last == stack.peek().right) {
                        last = stack.pop();
                        System.out.print(last.val+" ");
                        flag.pop();
                    }else {
                        break;
                    }
                }else {
                    break;
                }
            }
            if (flag.peek() == 2) {
                System.out.println(stack.pop().val);
                flag.pop();
            }
        }
        pri(head);
    }

    private static void pri(Node head) {
        if (head != null) {
            pri(head.left);
            pri(head.right);
            System.out.print(head.val+" ");
        }
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int i) {
            val = i;
        }
    }
}
