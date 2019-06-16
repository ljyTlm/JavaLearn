package 常用算法;

public class 二分查找样例 {
    public static void main(String[] args) {
        int [] arr = {34,67,89,109,567,789,3456,4567,23456};
        int idx_1 = selectUp(arr, 2345); //返回数组里第一个大于等于他的角标
        System.out.println(idx_1);
    }

    private static int selectUp(int[] arr, int i) {
        return select_1(arr, 0, arr.length-1, i);
    }

    private static int select_1(int[] arr, int s, int e, int flag) {
        if (s == e){
            if (arr[s] >= flag) return s;
            return -1;
        }else if(s < e){
            int k = (s+e)/2;
            if (arr[k] < flag){
                return select_1(arr, k+1, e, flag);
            }else {
                return Math.min(k, select_1(arr, s, k, flag));
            }
        }
        return -1;
    }
}
