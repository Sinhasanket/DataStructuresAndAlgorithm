package DynamicProgramming;

import java.util.Scanner;

public class MinimumCostPath {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int mat[][]=new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                mat[i][j]=sc.nextInt();
            }
        }
        System.out.println(solve(mat,n,m));
    }
    public static int solve(int mat[][],int n,int m){
        int dp[][]=new int[n+1][m+1];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (i==0&&j==0 ){
                    dp[i][j] = mat[0][0];
                }else if(i==0){
                    dp[i][j] = dp[0][j-1]+mat[0][j];
                }else if(j==0){
                    dp[i][j] = dp[i-1][0]+mat[i][0];
                }else {
                    dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j])+mat[i][j];
                }

            }
        }
        return dp[n-1][m-1];
    }
}
