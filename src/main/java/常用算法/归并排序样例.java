package 常用算法;

import java.util.Arrays;

public class 归并排序样例 {
    public static void main(String[] args) {
        int [] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    private static void mergeSort(int[] arr, int s, int e) {
        if (s < e){
            int k = (s+e)>>1;
            mergeSort(arr, s, k);
            mergeSort(arr, k+1, e);
            int [] val = new int[e-s+1];
            int a = 0;
            int b = s;
            int c = k+1;
            while (b <= k && c <= e){
                if(arr[b] < arr[c]){
                    val[a++] = arr[b++];
                }else {
                    val[a++] = arr[c++];
                }
            }
            while (b <= k) val[a++] = arr[b++];
            while (c <= e) val[a++] = arr[c++];
            for(int i = 0; i < val.length; i++) arr[i+s] = val[i];
        }
    }
}
