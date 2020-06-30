package DynamicProgramming;

import java.util.Scanner;

public class MaxSubarraySum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];
        for (int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println(find(arr,n));
    }

    public static int find(int arr[],int n){
        int dp[]=new int[n];
        dp[0] = arr[0] < 0? 0 : arr[0];
        int max_so_far = dp[0];
        for (int i=1;i<n;i++){
            dp[i] = dp[i-1] + arr[i];
            if (dp[i] < 0)dp[i]=0;
            max_so_far = Math.max(max_so_far,dp[i]);
        }
        return max_so_far;
    }
}
