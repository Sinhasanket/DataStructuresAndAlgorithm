package DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class Submatrixwith1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        //MATRIX REPRESENTATION
//        int mat[][]=new int[n][m];
//        for (int i=0;i<n;i++){
//            for (int j=0;j<m;j++){
//                mat[i][j]=sc.nextInt();
//            }
//        }

//        ARRAYLIST REPRESENTATION
            ArrayList<ArrayList<Integer>> li = new ArrayList<ArrayList<Integer> >(n);
            for (int i = 0; i < n; i++)
                li.add(new ArrayList<Integer>());

            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    int a = sc.nextInt();
                    li.get(i).add(a);
                }
            }
            
           System.out.println(maxSubMatrix(li));
        //System.out.println(solve(mat,n,m));
    }

    public static int maxSubMatrix(ArrayList<ArrayList<Integer>> arr) {
        /* write your solution here */
        int n= arr.size();
        int m = arr.get(0).size();
        int dp[][]=new int[n+1][m+1];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)dp[i][0]=arr.get(i).get(0);
        for(int i=0;i<m;i++)dp[0][i]=arr.get(0).get(i);

        for (int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if (arr.get(i).get(j)==1){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    max = Math.max(max,dp[i][j]);
                }else if(arr.get(i).get(j)==0){
                    dp[i][j]=0;
                }
            }
        }

//        for (int i=0;i<n;i++){
//            for (int j=0;j<m;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        return max;
    }

    public static int solve(int mat[][],int n,int m){
        int dp[][]=new int[n+1][m+1];
        int max = Integer.MIN_VALUE;
        for (int i=0;i<n;i++)dp[i][0]=mat[i][0];
        for (int i=0;i<m;i++)dp[0][i]=mat[0][i];
        for (int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if (mat[i][j]==1){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    max = Math.max(max,dp[i][j]);
                }else if(mat[i][j]==0){
                    dp[i][j]=0;
                }
            }
        }

//        CHECKING
//        for (int i=0;i<dp.length;i++){
//            for (int j=0;j<dp[0].length;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }

        return max;
    }
}
