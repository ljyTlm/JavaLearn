package 常用算法;

import java.util.LinkedList;
import java.util.Scanner;

public class 单源最短路样例 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [][] graph = new int [n+1][n+1];
        while (k-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = c;
            graph[b][a] = c;
        }
        LinkedList<Node> qu = new LinkedList<>();
        int [] len = new int [n+1];
        len[1] = 1;
        qu.add(new Node(1, 1));
        while (qu.isEmpty()){
            Node point = qu.poll();
            for (int i = 1; i <= n; i ++){
                if (graph[point.idx][i] != 0){
                    if (len[i] == 0 || len[i] > point.val + graph[point.idx][i]){
                        len[i] = point.val + graph[point.idx][i];
                        qu.add(new Node(i, len[i]));
                    }
                }
            }
        }
        for (int i = 2; i <= n; i ++){
            System.out.println(len[i]);
        }
    }
    static class Node {
        int idx;
        int val;
        Node(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
}
