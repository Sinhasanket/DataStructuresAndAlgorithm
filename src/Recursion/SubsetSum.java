package Recursion;

import java.util.Scanner;

public class SubsetSum {
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0){
                int n = sc.nextInt();
                int arr[]=new int[n];
                for(int i=0;i<n;i++)arr[i]=sc.nextInt();
                if(solve(arr,arr.length,0)){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }

        public static boolean solve(int arr[],int len,int sum){
            if (len==0)return true;

            int ans=0;
            ans = sum+arr[len-1];
            if (ans==0)return true;

            Boolean exclude = solve(arr,len-1,sum);
            Boolean include = solve(arr,len-1,ans);

            return  exclude || include;
        }

    static boolean isSubsetSum(int set[], int n, int sum) {
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;
        if (set[n - 1] > sum)
            return isSubsetSum(set, n - 1, sum);
        return isSubsetSum(set, n - 1, sum)
                || isSubsetSum(set, n - 1, sum - set[n - 1]);
    }
//SUBSET WITH 0 SUM
    static int maxSum = 100001;
    static int arrSize = 100001;

    static int[][] dp = new int[arrSize][maxSum];
    static boolean[][] visit = new boolean[arrSize][maxSum];

    static int SubsetCnt(int i, int s, int arr[], int n) {
        if (i == n) {
            if (s == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (visit[i][s + arrSize]) {
            return dp[i][s + arrSize];
        }

        visit[i][s + arrSize] = true;
        dp[i][s + arrSize] = SubsetCnt(i + 1, s + arr[i], arr, n)
                + SubsetCnt(i + 1, s, arr, n);
        return dp[i][s + arrSize];
    }
}
