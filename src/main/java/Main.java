import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        for (int i = 40; i < 40*2; i ++){
            int v = i*i;
            String str = v +"";
            int k = 0;
            for (int j = 0; j < str.length(); j ++){
                k += (str.charAt(j)-'0');
            }
            System.out.print(k+" ");
        }
    }
}
