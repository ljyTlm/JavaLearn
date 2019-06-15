package 常用算法;

import java.util.Arrays;

public class 冒泡排序样例 {
    public static void main(String[] args) {
        int [] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for(int i = 0; i < arr.length-1; i ++){
            for(int j = 0; j < arr.length-1-i; j ++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
