package 设计模式;

import java.util.Arrays;

public class 策略模式样例 {
    public static void main(String[] args) {
//      1.策略模式的特性就是 实现的过程不同 但是结果是一样的
//        比如排序 最终的结果就是排序 然而可以用快速排序 也可以用归并
        Integer [] arr = {9,8,7,6,5,4,3,2,1};
//        Sort.sort_1(arr);
//        Sort.sort_2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
class Sort{
    public static void sort_1(Integer [] arr){
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(Integer[] arr, int s, int e) {
        if (s < e){
            int i = s;
            int j = e;
            while (i < j){
                while (i < j && arr[j] >= arr[s]) j --;
                while (i < j && arr[i] <= arr[s]) i ++;
                int a = arr[j];
                arr[j] = arr[i];
                arr[i] = a;
            }
            int a = arr[s];
            arr[s] = arr[i];
            arr[i] = a;
            quickSort(arr, s, i);
            quickSort(arr, i+1, e);
        }
    }

    public static void sort_2(Integer [] arr){
        mergeSort(arr, 0, arr.length-1);
    }

    private static void mergeSort(Integer[] arr, int s, int e) {
        if (s < e){
            int k = (s+e) / 2;
            mergeSort(arr, s, k);
            mergeSort(arr, k+1, e);
            Integer [] val = new Integer[e-s+1];
            int a = s;
            int b = k+1;
            int c = 0;
            while (a <= k && b <= e){
                if (arr[a] < arr[b]){
                    val[c++] = arr[a++];
                }else {
                    val[c++] = arr[b++];
                }
            }
            while (a <= k) val[c++] = arr[a++];
            while (b <= e) val[c++] = arr[b++];
            for(int i = 0; i < val.length; i ++) arr[i+s] = val[i];
        }
    }
}