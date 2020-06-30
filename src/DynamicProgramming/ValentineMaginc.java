package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class ValentineMaginc {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[]=new int[n];
        for (int i=0;i<n;i++)arr[i]=sc.nextInt();
        int arr1[]=new int[m];
        for (int i=0;i<m;i++)arr1[i]=sc.nextInt();
        Arrays.sort(arr);
        Arrays.sort(arr1);
        int dp[][]=new int[200][200];
        int ans = find(arr,arr1,0,0,dp);
        System.out.println(ans);
    }
    public static int find(int arr[],int arr1[],int i,int j,int dp[][]){
        if (i==arr.length)return 0;
        if (j==arr1.length)return Integer.MAX_VALUE;
        if (dp[i][j] != 0){
            return dp[i][j];
        }
        int option1 = Math.abs(arr[i]-arr1[j])+find(arr,arr1,i+1,j+1,dp);
        int option2 = find(arr,arr1,i,j+1,dp);
        return dp[i][j] = Math.min(option1,option2);
    }
}
