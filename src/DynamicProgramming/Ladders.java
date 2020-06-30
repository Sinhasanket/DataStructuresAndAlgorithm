package DynamicProgramming;

import java.util.Scanner;

public class Ladders {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int dp[]=new int[n+1];
       // System.out.println( solve(n,k,dp));
          System.out.println( ladders(n,k,dp));
    }

    //top down dp
    private static int solve(int n,int k,int dp[]){
        if (n==0)return 1;
        if (dp[n] != 0)return dp[n];
        int ways = 0;
        for (int i=1;i<=k;i++){
            if (n-i >= 0)
            ways+=solve(n-i,k,dp);
        }
        return dp[n] = ways;
    }

    //Bottom up
    private static int solveBottomUp(int n,int k,int dp[]){
       dp[0]=1;
       for (int i=1;i<=n;i++){
           dp[i] = 0;
           for (int j=1;j<=k;j++){
               if (i-j>=0){
                   dp[i] += dp[i-j];
               }
           }
       }
       return dp[n];
    }

    //Optimized
    private static int ladders(int n,int k,int dp[]){
        dp[0]=dp[1]=1;
        for (int i=2;i<=k;i++){
           dp[i] = 2*dp[i-1];
        }
        for (int i=k+1;i<=n;i++){
            dp[i] = 2*dp[i-1]- dp[i-k-1];
        }
        return dp[n];
    }

    //this is a different problem
    private static int cellmitosis(int n,int x,int y,int z){
        int dp[]=new int[n+1];
        dp[0]=0;dp[1]=0;
        for (int i=2;i<=n;i++){
            if (i%2==0){
                dp[i] = Math.min(dp[i/2]+x,dp[i-1]+y);
            }else {
                dp[i] = Math.min(dp[i-1]+y , dp[(i+1)/2]+x+z);
            }
        }
        return dp[n];
    }
}
