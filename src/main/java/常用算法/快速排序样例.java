package 常用算法;

import java.util.Arrays;


public class 快速排序样例 {
    public static void main(String[] args) {
        int [] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int s, int e) {
        if (s < e){
            int i = s;
            int j = e;
            while (i < j){
                while (i < j && arr[j] >= arr[s]) j --;
                while (i < j && arr[i] <= arr[s]) i ++;
                swap(arr, i, j);
            }
            swap(arr, s, i);
            quickSort(arr, s, i);
            quickSort(arr, i+1, e);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int v = arr[i];
        arr[i] = arr[j];
        arr[j] = v;
    }
}
