package 常用算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class 第K大快排写法 {

    private static Random rand = new Random();
    private static int k = 4;
    public static void main(String[] args) {
        Integer [] arr = new Integer[20];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i+1;
        }
        shuffle(arr);
        System.out.println(Arrays.toString(arr));
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[k]);
    }

    private static void sort(Integer[] arr, int s, int e) {
        if (s < e) {
            int flag = arr[s];
            int l = s;
            int r = e;
            while (l < r) {
                while (l < r && arr[r] <= flag) r --;
                while (l < r && arr[l] >= flag) l ++;
                swap(arr, l, r);
            }
            swap(arr, s, l);
            if (k >= s && k <= l)
                sort(arr, s, l);
            if (k > l && k <= e)
                sort(arr, l+1, e);
        }
    }

    public static <T> void shuffle(T[] arr) {
        int length = arr.length;
        for ( int i = length; i > 0; i-- ){
            int randInd = rand.nextInt(i);
            swap(arr, randInd, i - 1);
        }
    }

    public static <T> void swap(T[] a, int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
