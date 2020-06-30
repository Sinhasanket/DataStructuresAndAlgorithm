package String;

import java.util.Scanner;

public class LexicographicalRank {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String S = sc.next();
            System.out.println(findRank(S));
        }
    }
    static int findRank(String S) {
        int n = S.length();
        int mul = fact(n);
        int rank=1;
        int countRight;
        for(int i=0;i<S.length();i++){
            for(int j=i+1;j<S.length();j++){
                if(S.charAt(i)==S.charAt(j)){
                    return 0;
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            mul /= n - i;
            countRight = findSmallerInRight(S,i,n-1);
            rank += countRight * mul;
        }

        return rank%1000000007 ;
    }

    static int fact(int n){
        if(n==1 || n==0){
            return 1;
        }
        return n*(fact(n-1));
    }

    static int findSmallerInRight(String str, int low,int high){
        int countRight = 0, i;

        for (i = low + 1; i <= high; ++i)
            if (str.charAt(i) < str.charAt(low))
                ++countRight;

        return countRight;
    }
}
