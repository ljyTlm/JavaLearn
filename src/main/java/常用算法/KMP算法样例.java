package 常用算法;

public class KMP算法样例 {
    public static void main(String[] args) {
        String s = "asdfasdfasdfaasdfasdfasdfasdfasdfsdfasdfasdghgash";
        String t = "asdfasdfas";
        int idx = kmp(s, t);
        System.out.println(idx);
    }

    private static int kmp(String s, String t) {
        int [] next = getNext(t);
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()){
            if (j == -1 || s.charAt(i) == t.charAt(j)){
                i ++; j ++;
            }else {
                j = next[j];
            }
            if (j == t.length()) return i-j;
        }
        return -1;
    }

    private static int[] getNext(String t) {
        int [] next = new int[t.length()+1];
        next[0] = -1;
        int idx = -1;
        int i = 0;
        while (i < t.length()){
            if (idx == -1 || t.charAt(idx) == t.charAt(i)){
                idx ++; i ++;
                next[i] = idx;
            }else {
                idx = next[idx];
            }
        }
        return next;
    }
}
