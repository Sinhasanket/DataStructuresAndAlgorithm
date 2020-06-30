package Maths;

import java.util.Scanner;

public class BinomialCoeffDp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
     //   System.out.println(findRec(n,k));
        System.out.println(findDp(n,k));
    }

    public static int findRec(int n,int k){
        if (k==0 || k== n )return 1;
        else return findRec(n-1,k-1)+findRec(n-1,k);
    }

    public static int findDp(int n,int k){
        int dp[][]=new int[n+1][k+1];
        for (int i=0;i<=n;i++){
            for (int j=0;j<=Math.min(i,k);j++){
                if (j==0 ||i==j)dp[i][j] =  1;
                else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        return dp[n][k];
    }
}
