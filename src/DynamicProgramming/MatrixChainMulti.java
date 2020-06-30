package DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

//dp[x][y] = Math.min(dp[x][y],dp[x][k]+dp[k+1][y]*arr[x]*arr[k+1]*arr[c+1]);

public class MatrixChainMulti {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0) {
            int n = s.nextInt();
            ArrayList<Long> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) arr.add(s.nextLong());
            System.out.println(solve(arr));
        }
    }
    public static long solve(ArrayList<Long> arr){
        int n = arr.size()-1;
        long dp[][]=new long[n+1][n+1];

        for (int i=1;i<n;i++){
            long r=0,c=i;
            while (c<n){
                long val = Integer.MAX_VALUE;
                for (int pivot=(int)r;pivot<c;pivot++){
                    val = Math.min(val,dp[(int)r][pivot]+dp[pivot+1][(int)c]
                            *arr.get((int)r)*arr.get(pivot+1)*arr.get((int)c+1));
                }
                dp[(int)r][(int)c] = val;
                c++;r++;
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[0][n-1];
    }
}
