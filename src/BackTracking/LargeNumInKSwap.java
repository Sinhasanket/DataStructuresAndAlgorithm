package BackTracking;

import java.util.Scanner;
import java.lang.*;


//WRONG OUTPUT
class Res {
    static String max = "";
}
public class LargeNumInKSwap {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Res r = new Res();
             r.max = str;
            findMaximumNum(str,k, r.max);
            System.out.println(r.max);
        }
    }

    static void findMaximumNum( String str, int k, String max){

        if(k == 0)
            return;

        int n = str.length() ;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (str.charAt(i) < str.charAt(j)) {
                    swap(str.charAt(i), str.charAt(j));
                    if (str.compareTo(max) > 0)
                        max = str;

                    findMaximumNum(str, k - 1, max);

                    swap(str.charAt(i), str.charAt(j));
                }
            }
        }
    }


    static void swap(char a,char b){
        char t=a;
        a=b;
        b=t;
    }
}